using Newtonsoft.Json;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Ionic.Crc;

namespace OKExSDKLibrary
{
    public class WebSocketor : IDisposable
    {
        string url_puclic = "wss://ws.okex.com:8443/ws/v5/public?brokerId=9999";
        string url_private = "wss://ws.okex.com:8443/ws/v5/private?brokerId=9999";
        ClientWebSocket ws = null;
        CancellationTokenSource cts = new CancellationTokenSource();
        public event WebSocketPushHandler WebSocketPush;
        public delegate void WebSocketPushHandler(string message);
        public string asks_start = "asks\":[[";
        public string asks_end = "]],\"bids";
        public string bids_start = "bids\":[[";
        public string bids_end = "]],\"ts";
        public static SortedDictionary<double, string[]> baseAsks = new SortedDictionary<double, string[]>();
        public static SortedDictionary<double, string[]> baseBids = new SortedDictionary<double, string[]>();
        private bool isLogin = false;
        private string apiKey;
        private string secret;
        private string phrase;
        private HashSet<string> channels = new HashSet<string>();
        private ConcurrentQueue<PendingChannel> pendingChannels = new ConcurrentQueue<PendingChannel>();
        private System.Timers.Timer pendingTimer;
        private System.Timers.Timer closeCheckTimer = new System.Timers.Timer();
        private int retryNum = 0;
        public int retryLimit { get; set; } = 20;

        public WebSocketor()
        {
            ws = new ClientWebSocket();
            closeCheckTimer.Interval = 31000;
            closeCheckTimer.Elapsed += async (s, e) =>
            {
                await rebootAsync();
            };
        }

        public async Task ConnectAsync(string text)
        {
            string url = "";
            if (text.Contains("私有频道") || text.Contains("交易"))
            {
                url = url_private;
            }
            else if (text.Contains("public"))
            {
                url = url_puclic;
            }
            await ws.ConnectAsync(new Uri(url), cts.Token);

            closeCheckTimer.Interval = 31000;
            closeCheckTimer.Start();
            receive();
            keeponline();
        }

        public async Task LoginAsync(string apiKey, string secret, string phrase)
        {
            this.apiKey = apiKey;
            this.secret = secret;
            this.phrase = phrase;
            isLogin = true;
            if (ws.State == WebSocketState.Open)
            {
                var sign = Encryptor.MakeSign(apiKey, secret, phrase);
                byte[] buff = Encoding.UTF8.GetBytes(sign);
                await ws.SendAsync(new ArraySegment<byte>(buff), WebSocketMessageType.Text, true, CancellationToken.None);
                closeCheckTimer.Interval = 31000;
            }
            else if (ws.State == WebSocketState.CloseReceived || ws.State == WebSocketState.Closed || ws.State == WebSocketState.Aborted)
            {
                await rebootAsync();
            }
        }

        public async Task Subscribe(List<Dictionary<string, string>> args)
        {
            if (ws.State == WebSocketState.Open)
            {
                args.ForEach(channel =>
                {
                    channels.Add(channel["channel"]);
                });
                var message = new
                {
                    op = "subscribe",
                    args
                };
                var messageStr = JsonConvert.SerializeObject(message);
                byte[] buffer = Encoding.UTF8.GetBytes(messageStr);
                await ws.SendAsync(new ArraySegment<byte>(buffer), WebSocketMessageType.Text, true, CancellationToken.None);
                closeCheckTimer.Interval = 31000;
            }
            else if (ws.State == WebSocketState.CloseReceived || ws.State == WebSocketState.Closed || ws.State == WebSocketState.Aborted)
            {
                args.ForEach(channel =>
                {
                    channels.Add(channel["channel"]);
                });
                await rebootAsync();
            }
            else
            {
                pendingChannels.Enqueue(new PendingChannel { action = "subscribe", args = args });
                setPendingTimer();
            }
        }
        public async Task Subscribe_order(string msg_id, string _channel, List<Dictionary<string, object>> args)
        {
            if (ws.State == WebSocketState.Open)
            {
                channels.Add(_channel);
                var message = new
                {
                    id = msg_id,
                    op = _channel,
                    args
                };
                var messageStr = JsonConvert.SerializeObject(message);
                byte[] buffer = Encoding.UTF8.GetBytes(messageStr);
                await ws.SendAsync(new ArraySegment<byte>(buffer), WebSocketMessageType.Text, true, CancellationToken.None);
                closeCheckTimer.Interval = 31000;
            }
            else if (ws.State == WebSocketState.CloseReceived || ws.State == WebSocketState.Closed || ws.State == WebSocketState.Aborted)
            {
                args.ForEach(channel =>
                {
                    channels.Add(_channel);
                });
                await rebootAsync();
            }
            else
            {
                //pendingChannels.Enqueue(new PendingChannel { action = "subscribe", args = args });
                setPendingTimer();
            }
        }
        public void keeponline()
        {
            Task.Factory.StartNew(
                async () =>
                {
                    while (ws.State == WebSocketState.Open)
                    {
                        Thread.Sleep(10000);
                        if (ws.State == WebSocketState.Open)
                        {
                            byte[] buffer = Encoding.UTF8.GetBytes("ping");
                            await ws.SendAsync(new ArraySegment<byte>(buffer), WebSocketMessageType.Text, true, CancellationToken.None);
                            closeCheckTimer.Interval = 31000;
                        }
                    }
                }, cts.Token, TaskCreationOptions.LongRunning,
                 TaskScheduler.Default);
        }

        public async Task UnSubscribe(List<Dictionary<string, string>> args)
        {
            foreach (var channel in args)
            {
                channels.Remove(channel["channel"]);
            }
            if (ws.State == WebSocketState.Open)
            {
                var message = new
                {
                    op = "unsubscribe",
                    args
                };
                var messageStr = JsonConvert.SerializeObject(message);
                byte[] buffer = Encoding.UTF8.GetBytes(messageStr);
                await ws.SendAsync(new ArraySegment<byte>(buffer), WebSocketMessageType.Text, true, CancellationToken.None);
                closeCheckTimer.Interval = 31000;
            }
            else if (ws.State == WebSocketState.CloseReceived || ws.State == WebSocketState.Closed || ws.State == WebSocketState.Aborted)
            {
                await rebootAsync();
            }
            else
            {
                pendingChannels.Enqueue(new PendingChannel { action = "unsubscribe", args = args });
                setPendingTimer();
            }
        }

        public void Dispose()
        {
            if (!cts.Token.CanBeCanceled)
            {
                cts.Cancel();
            }
            if (ws != null)
            {
                ws.Dispose();
                ws = null;
            }
            channels = null;
            pendingChannels = null;
            if (pendingTimer != null)
            {
                pendingTimer.Stop();
                pendingTimer.Dispose();
            }
            if (closeCheckTimer != null)
            {
                closeCheckTimer.Stop();
                closeCheckTimer.Dispose();
            }
        }

        private void receive()
        {
            Task.Factory.StartNew(
              async () =>
              {
                  int length = 0;
                  string resultStr = "";
                  while (ws.State == WebSocketState.Open)
                  {
                      byte[] buffer_part = new byte[1024 * 1024];
                      var result = await ws.ReceiveAsync(new ArraySegment<byte>(buffer_part), CancellationToken.None);
                      if (result.MessageType == WebSocketMessageType.Text)
                      {
                          closeCheckTimer.Interval = 31000;
                          string result_part = System.Text.Encoding.UTF8.GetString(buffer_part);
                          result_part = result_part.TrimEnd('\0');
                          if (result_part.Contains("pong"))
                          {
                              continue;
                          }
                          if (result.EndOfMessage)
                          {
                              if (length == 0)
                              {
                                  resultStr = result_part;
                              }
                              else
                              {
                                  resultStr += result_part;
                              }
                          }
                          else
                          {
                              resultStr += result_part;
                              length += result.Count;
                              continue;
                          }
                          //If is depth
                          try
                          {
                              if (resultStr.IndexOf("event") < 0 && !(resultStr.IndexOf("books5") > 0) && resultStr.IndexOf("books") > 0)
                              {
                                  int index_asksStart = resultStr.IndexOf(asks_start);
                                  int index_asksEnd = resultStr.IndexOf(asks_end);
                                  int index_bidsStart = resultStr.IndexOf(bids_start);
                                  int index_bidsEnd = resultStr.IndexOf(bids_end);
                                  string beforeAsks = "", asks = "", bids = "", afterBids = "";
                                  if (index_asksStart > 0)
                                  {
                                      beforeAsks = resultStr.Substring(0, index_asksStart + 8);
                                      asks = resultStr.Substring(index_asksStart + 8, index_asksEnd - (index_asksStart + 8));
                                  }
                                  if (index_bidsStart > 0 && index_bidsEnd > 0)
                                  {
                                      bids = resultStr.Substring(index_bidsStart + 8, index_bidsEnd - index_bidsStart - 8);
                                      afterBids = resultStr.Substring(index_bidsEnd);
                                  }
                                  List<string> list_askContents = asks.Split(new[] { "],[" }, StringSplitOptions.None).ToList();
                                  List<string> list_bidContents = bids.Split(new[] { "],[" }, StringSplitOptions.None).ToList();
                                  combineIncrementalData(list_askContents, "asks");
                                  combineIncrementalData(list_bidContents, "bids");
                                  if (list_askContents.Count != 200 && (!list_askContents.Contains("snapshot")))
                                  {
                                      var obj = buildStr_checksum_asks_bids();
                                      int crc32 = getCRC32(obj.Item1);
                                      resultStr = "增量数据：" + resultStr + "\n" + "checksum值：" + crc32.ToString() + "\n" + "合并后的" + beforeAsks + obj.Item2 + "],\"bids\":[" + obj.Item3 + afterBids + "\n";
                                  }
                              }
                          }
                          catch (Exception e)
                          {
                              resultStr = e.Message + e.StackTrace;
                          }
                          WebSocketPush.Invoke(resultStr);
                          resultStr = "";
                          length = 0;

                      }

                      if (result.MessageType == WebSocketMessageType.Close)
                      {
                          try
                          {
                              await ws.CloseOutputAsync(WebSocketCloseStatus.Empty, null, cts.Token);
                          }
                          catch (Exception)
                          {
                              break;
                          }
                          break;
                      }
                  }
              }, cts.Token, TaskCreationOptions.LongRunning,
                 TaskScheduler.Default);
        }


        public int getCRC32(string value)
        {
            if (string.IsNullOrWhiteSpace(value)) return 0;
            byte[] array = Encoding.ASCII.GetBytes(value);
            MemoryStream stream = new MemoryStream(array);
            return new CRC32().GetCrc32(stream);
        }

        public Tuple<string, string, string> buildStr_checksum_asks_bids()
        {
            List<string> list_checkSumStr = new List<string>(new string[50]);
            List<string> list_askContents = new List<string>();
            List<string> list_bidContents = new List<string>();
            int i = 0;
            foreach (var bid in baseBids.Reverse())
            {
                if (i < 50)
                {
                    list_checkSumStr[i] = bid.Value[0] + ":" + bid.Value[1];
                    i += 2;
                }

                list_bidContents.Add("[" + String.Join(",", bid.Value) + "]");
            }
            i = 1;
            foreach (var ask in baseAsks)
            {
                if (i < 50)
                {
                    list_checkSumStr[i] = ask.Value[0] + ":" + ask.Value[1];
                    i += 2;
                }
                list_askContents.Add("[" + String.Join(",", ask.Value) + "]");
            }
            List<string> removeNull_list_checksum = new List<string>();

            for (int index = 0; index < 50; index++)
            {
                if (list_checkSumStr[index] != null)
                {
                    removeNull_list_checksum.Add(list_checkSumStr[index]);
                }
            }
            string checksumStr = String.Join(":", removeNull_list_checksum).Replace("\"", "");
            string asks = string.Join(",", list_askContents);
            string bids = string.Join(",", list_bidContents);
            Tuple<string, string, string> obj = new Tuple<string, string, string>(checksumStr, asks, bids);
            return obj;
        }

        public void combineIncrementalData(List<string> incrementalData, string type)
        {
            if (type == "bids")
            {
                if (baseBids.Count == 0)
                {
                    foreach (var content in incrementalData)
                    {
                        string[] detail = content.Split(',');
                        try
                        {
                            if (!string.IsNullOrWhiteSpace(detail[0].Replace("\"", "")))
                            {
                                baseBids.Add(Convert.ToDouble(detail[0].Replace("\"", "")), detail);
                            }

                        }
                        catch (Exception e)
                        {
                            File.AppendAllText(@"D:\\error.txt", "CreateDate" + DateTime.Now.ToString() + "detail[0]:" + detail[0].Replace("\"", "") + "\n" + e.Message + "\n" + e.StackTrace + "\n");
                        }
                    }

                }
                else
                {
                    if (baseBids.Count > 0)
                    {
                        foreach (var content in incrementalData)
                        {
                            string[] detail = content.Split(',');
                            if (string.IsNullOrWhiteSpace(detail[0]))
                            {
                                continue;
                            }
                            try
                            {
                                if (baseBids.Keys.Contains(Convert.ToDouble(detail[0].Replace("\"", ""))))
                                {
                                    if (detail[1].Replace("\"", "") == "0")
                                    {
                                        if (baseBids.Keys.Contains(Convert.ToDouble(detail[0].Replace("\"", ""))))
                                        {
                                            baseBids.Remove(Convert.ToDouble(detail[0].Replace("\"", "")));
                                        }
                                    }
                                    else
                                    {
                                        baseBids[Convert.ToDouble(detail[0].Replace("\"", ""))] = detail;
                                    }
                                }
                                else
                                {
                                    baseBids.Add(Convert.ToDouble(detail[0].Replace("\"", "")), detail);
                                }
                            }
                            catch (Exception e)
                            {
                                File.AppendAllText(@"D:\\error.txt", "CreateDate" + DateTime.Now.ToString() + "detail[0]:" + detail[0].Replace("\"", "") + "\n" + e.Message + "\n" + e.StackTrace + "\n");
                            }
                        }
                    }
                }
            }
            if (type == "asks")
            {
                if (baseAsks.Count == 0)
                {
                    foreach (var content in incrementalData)
                    {
                        string[] detail = content.Split(',');
                        if (string.IsNullOrWhiteSpace(detail[0]))
                        {
                            continue;
                        }
                        try
                        {
                            baseAsks.Add(Convert.ToDouble(detail[0].Replace("\"", "")), detail);
                        }
                        catch (Exception e)
                        {
                            File.AppendAllText(@"D:\\error.txt", "CreateDate" + DateTime.Now.ToString() + "detail[0]:" + detail[0].Replace("\"", "") + "\n" + e.Message + "\n" + e.StackTrace + "\n");
                        }
                    }

                }
                else
                {
                    if (baseAsks.Count > 0)
                    {
                        foreach (var content in incrementalData)
                        {
                            string[] detail = content.Split(',');
                            if (string.IsNullOrWhiteSpace(detail[0]))
                            {
                                continue;
                            }
                            try
                            {
                                if (baseAsks.Keys.Contains(Convert.ToDouble(detail[0].Replace("\"", ""))))
                                {
                                    if (detail[1].Replace("\"", "") == "0")
                                    {
                                        if (baseAsks.Keys.Contains(Convert.ToDouble(detail[0].Replace("\"", ""))))
                                        {
                                            baseAsks.Remove(Convert.ToDouble(detail[0].Replace("\"", "")));
                                        }
                                    }
                                    else
                                    {
                                        baseAsks[Convert.ToDouble(detail[0].Replace("\"", ""))] = detail;
                                    }
                                }
                                else
                                {
                                    baseAsks.Add(Convert.ToDouble(detail[0].Replace("\"", "")), detail);
                                }

                            }
                            catch (Exception e)
                            {
                                File.AppendAllText(@"D:\\error.txt", "CreateDate" + DateTime.Now.ToString() + "detail[0]:" + detail[0].Replace("\"", "") + "\n" + e.Message + "\n" + e.StackTrace + "\n");
                            }
                        }
                    }
                }
            }
        }

        private string Decompress(byte[] baseBytes)
        {
            try
            {
                using (var decompressedStream = new MemoryStream())
                using (var compressedStream = new MemoryStream(baseBytes))
                using (var deflateStream = new DeflateStream(compressedStream, CompressionMode.Decompress, true))
                {
                    deflateStream.CopyTo(decompressedStream);
                    decompressedStream.Position = 0;
                    using (var streamReader = new StreamReader(decompressedStream, Encoding.UTF8))
                    {
                        return streamReader.ReadToEnd();
                    }
                }
            }
            catch (Exception ex)
            {
                return ex.Message;
            }

        }

        private void setPendingTimer()
        {
            if (pendingTimer == null)
            {
                pendingTimer = new System.Timers.Timer(10000);
                pendingTimer.Elapsed += async (s, e) => { await retryPending(); };
                pendingTimer.Start();
            }
            else
            {
                pendingTimer.Start();
            }
        }

        private async Task retryPending()
        {
            while (pendingChannels.Count > 0)
            {
                retryNum++;
                if (retryNum > retryLimit)
                {
                    break;
                }
                PendingChannel channel;

                if (pendingChannels.TryDequeue(out channel))
                {
                    switch (channel.action)
                    {
                        case "subscribe":
                            await Subscribe(channel.args);
                            break;
                        case "unsubscribe":
                            await UnSubscribe(channel.args);
                            break;
                    }
                }
            }
            retryNum = 0;
            pendingTimer.Stop();
        }

        private async Task rebootAsync()
        {
            if (ws.State != WebSocketState.Aborted || ws.State != WebSocketState.Closed)
            {
                await ws.CloseOutputAsync(WebSocketCloseStatus.Empty, null, cts.Token);
            }
            if (cts.Token.CanBeCanceled)
            {
                cts.Cancel();
                cts = new CancellationTokenSource();
            }
            ws.Dispose();
            ws = null;
            ws = new ClientWebSocket();
            if (pendingTimer != null)
            {
                pendingTimer.Stop();
            }

            await ConnectAsync("public");
            if (isLogin)
            {
                await LoginAsync(apiKey, secret, phrase);
                await Task.Delay(500);//等待登录
            }

            setPendingTimer();
        }

        private class PendingChannel
        {
            public string action { get; set; }
            public List<Dictionary<string, string>> args { get; set; }
            public List<Dictionary<string, object>> Args { get; set; }
        }
    }
}

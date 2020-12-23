using OKExSDK;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WebSocketDemo
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        private string apiKey = "";
        private string secret = "";
        private string passPhrase = "";
        List<string> list_instId = new List<string>() { "tickers", "open-interest", "trades", "mark-price", "price-limit", "funding-rate", "index-tickers" };
        List<string> list_instType = new List<string>() { "instruments" };
        List<string> list_instType_uly = new List<string>() { "estimated-price" };
        List<string> list_uly = new List<string>() { "opt-summary" };
        // 创建Websocketor对象
        private string cleanTag(string content)
        {
            int sign = content.IndexOf("/");
            return sign > 0 ? content.Substring(0, sign) : content;
        }

        public static Dictionary<string, object> cleanNullKey(Dictionary<string, object> parameters)
        {
            List<string> remove_key = new List<string>();
            foreach (var param in parameters)
            {
                if (string.IsNullOrWhiteSpace(param.Value.ToString()))
                {
                    remove_key.Add(param.Key);
                }
            }
            remove_key.ForEach(key => parameters.Remove(key));
            return parameters;
        }

        public static Dictionary<string, string> cleanNullKey(Dictionary<string, string> parameters)
        {
            List<string> remove_key = new List<string>();
            foreach (var param in parameters)
            {
                if (string.IsNullOrWhiteSpace(param.Value.ToString()))
                {
                    remove_key.Add(param.Key);
                }
            }
            remove_key.ForEach(key => parameters.Remove(key));
            return parameters;
        }

        private WebSocketor websocketor = new WebSocketor();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnSetKey(object sender, RoutedEventArgs e)
        {
            apiKey = this.apikey.Text;
            secret = this.secret_.Text;
            passPhrase = this.passphrase.Text;
            handleWebsocketMessage("初始化Apikey信息成功！");
        }

        private async void btnConnect(object sender, RoutedEventArgs e)
        {
            Button btn = (Button)sender;
            string text = btn.Content.ToString();
            websocketor.WebSocketPush -= this.handleWebsocketMessage;
            websocketor.WebSocketPush += this.handleWebsocketMessage;
            await websocketor.ConnectAsync(text);
            handleWebsocketMessage("连接成功");
        }
        /// <summary>
        /// WebSocket消息推送侦听
        /// </summary>
        /// <param name="msg">WebSocket消息</param>
        private void handleWebsocketMessage(string msg)
        {
            try
            {
                this.Dispatcher.BeginInvoke(new Action(() =>
                {
                    this.msgBox.AppendText(msg + Environment.NewLine);//换行标识
                    //Console.WriteLine(msg);
                }));
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message + ex.StackTrace.ToString());
            }
        }

        private async void btnSubscribe(object sender, RoutedEventArgs e)
        {
            string channel_public = cleanTag(this.channel_public.Text), instType = cleanTag(this.instType_public.Text), instId = cleanTag(this.instId_public.Text), candlesSize = cleanTag(this.candle_public.Text),
                uly = cleanTag(this.uly_public.Text), books_public = cleanTag(this.books_public.Text).Replace("books", ""), private_ccy = cleanTag(this.ccy_private.Text), private_instType = cleanTag(this.instType_private.Text),
                private_uly = cleanTag(this.uly_private.Text), private_instId = cleanTag(this.instId_private.Text), channel_private = cleanTag(this.channel_private.Text), channel_order = cleanTag(this.channel_order.Text),
                id_order = cleanTag(this.id_order.Text), instId_order = cleanTag(this.instId_order.Text), clOrdId_order = cleanTag(this.clOrdId_order.Text), tdMode_order = cleanTag(this.tdMode_order.Text),
                ccy_order = cleanTag(this.ccy_order.Text), side_order = cleanTag(this.side_order.Text), ordType_order = cleanTag(this.ordType_order.Text), sz_order = cleanTag(this.sz_order.Text), posSide_order = cleanTag(this.posSide_order.Text),
                tag_order = cleanTag(this.tag_order.Text), px_order = cleanTag(this.px_order.Text), reduceOnly_order = cleanTag(this.reduceOnly_order.Text), id_cancel = cleanTag(this.id_cancel.Text),
                instId_cancel = cleanTag(this.instId_cancel.Text), ordId_cancel = cleanTag(this.ordId_cancel.Text), clOrdId_cancel = cleanTag(this.clOrdId_cancel.Text), instId_amend = cleanTag(this.instId_amend.Text),
                ordId_amend = cleanTag(this.ordId_amend.Text), clOrdId_amend = cleanTag(this.clOrdId_amend.Text), cxlOnFail_amend = cleanTag(this.cxlOnFail_amend.Text), reqId_amend = cleanTag(this.reqId_amend.Text), newSz_amend = cleanTag(this.newSz_amend.Text),
                newPx_amend = cleanTag(this.newPx_amend.Text), id_amend = cleanTag(this.id_amend.Text);
            Button btn = (Button)sender;
            string btn_type = btn.Content.ToString();
            switch (btn_type)
            {
                case "订阅(public)":
                    if (channel_public.Contains("books"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public + books_public);
                        Params.Add("instId", instId);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    else if (channel_public.Contains("candle"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public + candlesSize);
                        Params.Add("instId", instId);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    else if (list_instType.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("instType", instType);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    else if (list_instId.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("instId", instId);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    else if (list_instType_uly.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("instType", instType);
                        Params.Add("uly", uly);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    else if (list_uly.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("uly", uly);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    break;
                case "订阅(私有频道)":
                    if (channel_private.Contains("account"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_private);
                        Params.Add("ccy", private_ccy);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    else if (channel_private.Contains("positions") || channel_private.Contains("orders") || channel_private.Contains("orders-algo"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_private);
                        Params.Add("instId", private_instId);
                        Params.Add("instType", private_instType);
                        Params.Add("uly", private_uly);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.Subscribe(list_params);
                    }
                    break;
                case "订阅(交易)":
                    if (channel_order == "order")
                    {
                        Dictionary<string, object> Params = new Dictionary<string, object>();
                        Params.Add("instId", instId_order);
                        Params.Add("tdMode", tdMode_order);
                        Params.Add("ccy", ccy_order);
                        Params.Add("clOrdId", clOrdId_order);
                        Params.Add("tag", tag_order);
                        Params.Add("side", side_order);
                        Params.Add("posSide", posSide_order);
                        Params.Add("ordType", ordType_order);
                        Params.Add("sz", sz_order);
                        Params.Add("px", px_order);
                        Params.Add("reduceOnly", reduceOnly_order);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, object>>();
                        list_params.Add(context);
                        await websocketor.Subscribe_order(id_order, channel_order, list_params);
                    }
                    else if (channel_order == "batch-orders")
                    {
                        var list_params = new List<Dictionary<string, object>>();
                        var _instIds = instId_order.Split(',');
                        var _tdMode = tdMode_order.Split(',');
                        var _ccy = ccy_order.Split(',');
                        var _clOrdId = clOrdId_order.Split(',');
                        var _tag = tag_order.Split(',');
                        var _side = side_order.Split(',');
                        var _posSide = posSide_order.Split(',');
                        var _ordType = ordType_order.Split(',');
                        var _sz = sz_order.Split(',');
                        var _px = px_order.Split(',');
                        var _reduceOnly = reduceOnly_order.Split(',');
                        for(int index = 0; index < _instIds.Length; index++)
                        {
                            Dictionary<string, object> Params = new Dictionary<string, object>();
                            Params.Add("instId", _instIds[index]);
                            Params.Add("tdMode", _tdMode.Length== _instIds.Length?_tdMode[index]:"");
                            Params.Add("ccy", _ccy.Length == _instIds.Length ? _ccy[index] : "");
                            Params.Add("clOrdId", _clOrdId.Length == _instIds.Length ? _clOrdId[index] : "");
                            Params.Add("tag", _tag.Length == _instIds.Length ? _tag[index] : "");
                            Params.Add("side", _side.Length == _instIds.Length ? _side[index] : "");
                            Params.Add("posSide", _posSide.Length == _instIds.Length ? _posSide[index] : "");
                            Params.Add("ordType", _ordType.Length == _instIds.Length ? _ordType[index] : "");
                            Params.Add("sz", _sz.Length == _instIds.Length ? _sz[index] : "");
                            Params.Add("px", _px.Length == _instIds.Length ? _px[index] : "");
                            Params.Add("reduceOnly", _reduceOnly.Length == _instIds.Length ? _reduceOnly[index] : "");
                            var context = cleanNullKey(Params);
                            list_params.Add(context);
                        }
                        await websocketor.Subscribe_order(id_order, channel_order, list_params);
                    }
                    else if (channel_order == "cancel-order")
                    {
                        Dictionary<string, object> Params = new Dictionary<string, object>();
                        Params.Add("instId",instId_cancel);
                        Params.Add("ordId",ordId_cancel);
                        Params.Add("clOrdId",clOrdId_cancel);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, object>>();
                        list_params.Add(context);
                        await websocketor.Subscribe_order(id_cancel,channel_order, list_params);
                    }
                    else if (channel_order == "batch-cancel-orders")
                    {
                        var list_params = new List<Dictionary<string, object>>();
                        var _instIds = instId_cancel.Split(',');
                        var _clOrdId = clOrdId_cancel.Split(',');
                        var _ordId = ordId_cancel.Split(',');
                        for (int index = 0; index < _instIds.Length; index++)
                        {
                            Dictionary<string, object> Params = new Dictionary<string, object>();
                            Params.Add("instId", _instIds[index]);
                            Params.Add("ordId", _ordId.Length == _instIds.Length ? _ordId[index] : "");
                            Params.Add("clOrdId", _clOrdId.Length == _instIds.Length ? _clOrdId[index] : "");
                            var context = cleanNullKey(Params);
                            list_params.Add(context);
                        }
                        await websocketor.Subscribe_order(id_cancel, channel_order, list_params);
                    }
                    else if (channel_order == "amend-order")
                    {
                        Dictionary<string, object> Params = new Dictionary<string, object>();
                        Params.Add("instId", instId_amend);
                        Params.Add("cxlOnFail",cxlOnFail_amend);
                        Params.Add("ordId",ordId_amend);
                        Params.Add("clOrdId",clOrdId_amend);
                        Params.Add("reqId",reqId_amend);
                        Params.Add("newSz",newSz_amend);
                        Params.Add("newPx",newPx_amend);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, object>>();
                        list_params.Add(context);
                        await websocketor.Subscribe_order(id_amend, channel_order, list_params);
                    }
                    else if (channel_order == "batch-amend-orders")
                    {
                        var list_params = new List<Dictionary<string, object>>();
                        var _instIds = instId_amend.Split(',');
                        var _cxlOnFail = cxlOnFail_amend.Split(',');
                        var _ordId = ordId_amend.Split(',');
                        var _clOrdId = clOrdId_amend.Split(',');    
                        var _reqId = reqId_amend.Split(',');    
                        var _newSz = newSz_amend.Split(',');    
                        var _newPx = newPx_amend.Split(',');    
                        for (int index = 0; index < _instIds.Length; index++)
                        {
                            Dictionary<string, object> Params = new Dictionary<string, object>();
                            Params.Add("instId", _instIds[index]);
                            Params.Add("cxlOnFail", _cxlOnFail.Length == _instIds.Length ? _cxlOnFail[index] : "");
                            Params.Add("clOrdId", _clOrdId.Length == _instIds.Length ? _clOrdId[index] : "");
                            Params.Add("ordId", _ordId.Length == _instIds.Length ? _ordId[index] : "");
                            Params.Add("reqId", _reqId.Length == _instIds.Length ? _reqId[index] : "");
                            Params.Add("newSz", _newSz.Length == _instIds.Length ? _newSz[index] : "");
                            Params.Add("newPx", _newPx.Length == _instIds.Length ? _newPx[index] : "");
                            var context = cleanNullKey(Params);
                            list_params.Add(context);
                        }
                        await websocketor.Subscribe_order(id_amend, channel_order, list_params);
                    }
                    break;
                default:
                    break;
            }

        }
        private async void btnUnSubscribe(object sender, RoutedEventArgs e)
        {
            string channel_public = cleanTag(this.channel_public.Text), instType = cleanTag(this.instType_public.Text), instId = cleanTag(this.instId_public.Text), candlesSize = cleanTag(this.candle_public.Text),
                uly = cleanTag(this.uly_public.Text), books_public = cleanTag(this.books_public.Text).Replace("books", ""), private_ccy = cleanTag(this.ccy_private.Text), private_instType = cleanTag(this.instType_private.Text),
                private_uly = cleanTag(this.uly_private.Text), private_instId = cleanTag(this.instId_private.Text), channel_private = cleanTag(this.channel_private.Text), channel_order = cleanTag(this.channel_order.Text), id_order = cleanTag(this.id_order.Text), instId_order = cleanTag(this.instId_order.Text), clOrdId_order = cleanTag(this.clOrdId_order.Text), tdMode_order = cleanTag(this.tdMode_order.Text), ccy_order = cleanTag(this.ccy_order.Text), side_order = cleanTag(this.side_order.Text), ordType_order = cleanTag(this.ordType_order.Text), sz_order = cleanTag(this.sz_order.Text), posSide_order = cleanTag(this.posSide_order.Text), tag_order = cleanTag(this.tag_order.Text), px_order = cleanTag(this.px_order.Text), reduceOnly_order = cleanTag(this.reduceOnly_order.Text), id_cancel = cleanTag(this.id_cancel.Text), instId_cancel = cleanTag(this.instId_cancel.Text), ordId_cancel = cleanTag(this.ordId_cancel.Text), clOrdId_cancel = cleanTag(this.clOrdId_cancel.Text), instId_amend = cleanTag(this.instId_amend.Text), ordId_amend = cleanTag(this.ordId_amend.Text), clOrdId_amend = cleanTag(this.clOrdId_amend.Text), cxlOnFail_amend = cleanTag(this.cxlOnFail_amend.Text), reqId_amend = cleanTag(this.reqId_amend.Text), newSz_amend = cleanTag(this.newSz_amend.Text), newPx_amend = cleanTag(this.newPx_amend.Text), id_amend = cleanTag(this.id_amend.Text);
            Button btn = (Button)sender;
            string btn_type = btn.Content.ToString();

            switch (btn_type)
            {
                case "取消订阅(public)":
                    if (channel_public.Contains("books"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public + books_public);
                        Params.Add("instId", instId);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    else if (channel_public.Contains("candle"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public + candlesSize);
                        Params.Add("instId", instId);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    else if (list_instType.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("instType", instType);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    else if (list_instId.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("instId", instId);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    else if (list_instType_uly.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("instType", instType);
                        Params.Add("uly", uly);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    else if (list_uly.Contains(channel_public))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_public);
                        Params.Add("uly", uly);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    break;
                case "取消订阅(私有频道)":
                    if (channel_private.Contains("account"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_private);
                        Params.Add("ccy", private_ccy);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    else if (channel_private.Contains("positions") || channel_private.Contains("orders") || channel_private.Contains("orders-algo"))
                    {
                        Dictionary<string, string> Params = new Dictionary<string, string>();
                        Params.Add("channel", channel_private);
                        Params.Add("instId", private_instId);
                        Params.Add("instType", private_instType);
                        Params.Add("uly", private_uly);
                        var context = cleanNullKey(Params);
                        var list_params = new List<Dictionary<string, string>>();
                        list_params.Add(context);
                        await websocketor.UnSubscribe(list_params);
                    }
                    break;
                default:
                    break;
            }
        }

        private async void btnLogin(object sender, RoutedEventArgs e)
        {
            await websocketor.LoginAsync(this.apiKey, this.secret, this.passPhrase);
        }


        private void btnOrder(object sender, RoutedEventArgs e)
        {

        }

        private void btnBatch_orders(object sender, RoutedEventArgs e)
        {

        }
    }
}

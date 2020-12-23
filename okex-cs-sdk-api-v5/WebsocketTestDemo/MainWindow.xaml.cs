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

namespace WebsocketTestDemo
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        private string apiKey = "";
        private string secret = "";
        private string passPhrase = "";
        // 创建Websocketor对象
        private string cleanTag(string content)
        {
            int sign = content.IndexOf("(");
            return sign > 0 ? content.Substring(0, sign) : content;
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
        }

        private async void btnConnect(object sender, RoutedEventArgs e)
        {
            websocketor.WebSocketPush -= this.handleWebsocketMessage;
            websocketor.WebSocketPush += this.handleWebsocketMessage;
            await websocketor.ConnectAsync();
            Console.WriteLine("连接成功");
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
                    //this.msgBox.AppendText(msg + Environment.NewLine);//换行标识
                    Console.WriteLine(msg);
                }));
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message + ex.StackTrace.ToString());
            }
        }

        private async void btnSubscribe(object sender, RoutedEventArgs e)
        {
            string channel = "", instType = "";
            Button btn = (Button)sender;
            string btn_type = btn.Content.ToString();
            switch (btn_type)
            {
                case "订阅(public)":
                    channel = cleanTag(this.channel_public.Text);
                    if (channel == "instruments")
                    {
                        instType = this.instType_public.Text;
                        if (string.IsNullOrWhiteSpace(instType))
                        {

                            return;
                        }
                    }
                    break;
                case "订阅(futures)":

                    break;

                default:
                    break;
            }
            await websocketor.Subscribe(new List<Dictionary<string,string>>() { new Dictionary<string, string>(){ } });

        }
        private async void btnUnSubscribe(object sender, RoutedEventArgs e)
        {
            string channel = "", instType = "";
            Button btn = (Button)sender;
            string btn_type = btn.Content.ToString();
            switch (btn_type)
            {
                case "订阅(public)":
                    channel = cleanTag(this.channel_public.Text);
                    if (channel == "instruments")
                    {
                        instType = this.instType_public.Text;
                        if (string.IsNullOrWhiteSpace(instType))
                        {

                            return;
                        }
                    }
                    break;
                case "订阅(futures)":

                    break;

                default:
                    break;
            }
            await websocketor.Subscribe(new List<Dictionary<string, string>>() { new Dictionary<string, string>() { } });

        }
        private async void btnLogin(object sender, RoutedEventArgs e)
        {
            string channel = "", instType = "";
            Button btn = (Button)sender;
            string btn_type = btn.Content.ToString();
            switch (btn_type)
            {
                case "订阅(public)":
                    channel = cleanTag(this.channel_public.Text);
                    if (channel == "instruments")
                    {
                        instType = this.instType_public.Text;
                        if (string.IsNullOrWhiteSpace(instType))
                        {

                            return;
                        }
                    }
                    break;
                case "订阅(futures)":

                    break;

                default:
                    break;
            }
            await websocketor.Subscribe(new List<Dictionary<string, string>>() { new Dictionary<string, string>() { } });

        }
    }
}

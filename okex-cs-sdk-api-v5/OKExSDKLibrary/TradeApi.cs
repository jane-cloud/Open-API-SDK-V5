using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace OKExSDKLibrary
{
    public class TradeApi:SdkApi
    {
        private string TRADE_SEGMENT = "api/v5/trade";
        public TradeApi(string apikey, string secret, string passPhrase) : base(apikey, secret, passPhrase) { }

        public async Task<string> PlaceOrder(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/order";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> PlaceMultipleOrders(List<Dictionary<string, string>> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/batch-orders";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> CancelOrder(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/cancel-order";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> CancelMultipleOrders(List<Dictionary<string, string>> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/cancel-batch-orders";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> AmendOrder(Dictionary<string, object> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/amend-order";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> AmendMultipleOrders(List<Dictionary<string, object>> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/amend-batch-orders";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> ClosePositions(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/close-position";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetOrderDetails(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/order";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetOrderList(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/orders-pending";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetOrderHistory_7days(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/orders-history";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetOrderHistory_3months(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/orders-history-archive";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetTransactionDetails(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/fills";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> PlaceAlgoOrder(Dictionary<string, object> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/order-algo";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> CancelAlgoOrder(List<Dictionary<string, string>> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/cancel-algos";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetAlgoOrderList(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/orders-algo-pending";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetAlgoOrderHistory(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.TRADE_SEGMENT}/orders-algo-history";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }
    }
}

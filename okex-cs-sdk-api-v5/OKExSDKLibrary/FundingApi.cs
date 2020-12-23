using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace OKExSDKLibrary
{
    public class FundingApi:SdkApi
    {
        private string FUNDING_SEGMENT = "api/v5/asset";
        public FundingApi(string apikey, string secret, string passPhrase) : base(apikey, secret, passPhrase) { }

        /// <summary>
        /// 获取充值地址信息
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetDepositAddress(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/deposit-address";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 获取资金账户余额信息
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetBalance(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/balances";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 资金划转
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> FundsTransfer(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/transfer";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 提币
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> Withdrawal(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/withdrawal";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 充值记录
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetDepositHistory(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/deposit-history";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 提币记录
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetWithdrawalHistory(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/withdrawal-history";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 获取币种列表
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetCurrencies(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/currencies";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 余币宝申购/赎回
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> PiggyBankPurchasOrRedemption(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/purchase_redempt";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 资金流水查询
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> AssetBillsDetails(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.FUNDING_SEGMENT}/bills";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }
    }
}

using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace OKExSDKLibrary
{
    public class AccountApi : SdkApi
    {
        private string ACCOUNT_SEGMENT = "api/v5/account";
        public AccountApi(string apiKey, string secret, string passPhrase) : base(apiKey, secret, passPhrase) { }


        /// <summary>
        /// 查看账户余额
        /// Get Balance
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetBalance(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/balance";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 查看持仓信息
        /// Get Positions
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetPositions(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/positions";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 账单流水查询（近七天）
        /// Get Bills Details (last 7 days)
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetBillsDetails(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/bills";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 账单流水查询（近三个月）
        /// Get Bills Details (last 3 months)
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetBillsDetails_archive(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/bills-archive";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 查看账户配置
        /// Get Account Configuration
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetAccountConfiguration(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/config";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 设置持仓模式
        /// Set Position mode
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> SetPositionMode(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/set-position-mode";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 设置杠杆倍数
        /// Set Leverage
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> SetLeverage(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/set-leverage";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 获取最大可交易数量
        /// Get Maximum Tradable Size For Instrument
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetMaximumTradableSizeForInstrument(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/max-size";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 获取最大可用数量
        /// Get Maximum Available Tradable Amount
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetMaximumAvailableTradableAmount(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/max-avail-size";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }

        /// <summary>
        /// 调整保证金
        /// Increase/Decrease margin
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> IncreaseOrDecreaseMargin(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/position/margin-balance";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 获取杠杆倍数
        /// Get Leverage
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetLeverage(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/leverage-info";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 获取币币逐仓杠杆最大可借
        /// Get the maximum loan of isolated MARGIN
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetTheMaximumLoanOfIsolatedMARGIN(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/max-loan";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 获取当前账户交易手续费费率
        /// Get Fee Rates
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetFeeRates(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/trade-fee";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 获取计息记录
        /// Get interest-accrued
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetInterest_accrued(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/interest-accrued";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 期权希腊字母PA/BS切换
        /// Set Greeks (PA/BS)
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> SetGreeks(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/set-greeks";
            var bodyStr = JsonConvert.SerializeObject(requestParams);
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, bodyStr)))
            {
                var res = await client.PostAsync(url, new StringContent(bodyStr, Encoding.UTF8, "application/json"));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        /// <summary>
        /// 查看账户最大可转余额
        /// Get Maximum Withdrawals
        /// </summary>
        /// <param name="requestParams"></param>
        /// <returns></returns>
        public async Task<string> GetMaximumWithdrawals(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.ACCOUNT_SEGMENT}/max-withdrawal";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }
    }
}

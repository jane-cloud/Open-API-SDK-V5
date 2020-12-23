using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace OKExSDKLibrary
{
    public class PublicDataApi:SdkApi
    {
        private string PUBLIC_SEGMENT = "api/v5/public";
        public PublicDataApi(string apikey, string secret, string passPhrase) : base(apikey, secret, passPhrase) { }

        public async Task<string> GetInstruments(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/instruments";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetDeliveryOrExerciseHistory(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/delivery-exercise-history";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetOpenInterest(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/open-interest";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetFundingRate(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/funding-rate";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetFundingRateHistory(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/funding-rate-history";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetLimitPrice(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/price-limit";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


                public async Task<string> GetOptionMarketData(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/opt-summary";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetEstimatedDeliveryOrExcercisePrice(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/estimated-price";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetDiscountRateAndInterest_FreeQuota(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/discount-rate-interest-free-quota";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetSystemTime(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/time";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetLiquidationOrders(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/liquidation-orders";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }


        public async Task<string> GetMarkPrice(Dictionary<string, string> requestParams)
        {
            var url = $"{this.BASEURL}{this.PUBLIC_SEGMENT}/mark-price";
            using (var client = new HttpClient(new HttpInterceptor(this._apiKey, this._secret, this._passPhrase, null)))
            {
                var res = await client.GetAsync(await createGetUrl(url, requestParams));
                var contentStr = await res.Content.ReadAsStringAsync();
                return contentStr;
            }
        }
    }
}

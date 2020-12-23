using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace OKExSDKLibrary
{
    public class SdkApi
    {
        protected string BASEURL = "https://www.okex.com/";

        protected string _apiKey;
        protected string _secret;
        protected string _passPhrase;

        public SdkApi(string apiKey, string secret, string passPhrase)
        {
            this._apiKey = apiKey;
            this._secret = secret;
            this._passPhrase = passPhrase;
        }

        /// <summary>
        /// 生成Get请求Url
        /// Create Get Url From params
        /// </summary>
        /// <param name="url">BaseUrl</param>
        /// <param name="queryParams">Params</param>
        /// <returns></returns>
        public async Task<string> createGetUrl(string url, Dictionary<string, string> queryParams)
        {
            var encodedContent = new FormUrlEncodedContent(queryParams);
            var paramsStr = await encodedContent.ReadAsStringAsync();
            return queryParams.Count == 0 ? url : $"{url}?{paramsStr}";
        }
    }
}

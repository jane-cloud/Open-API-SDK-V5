using OKExSDKLibrary;
using System;
using System.Collections.Generic;
using System.Text;

namespace UnitTestDemo
{
    public class UnitTestBasic
    {
        private static string apiKey = "";
        private static string secret = "";
        private static string passPhrase = "";

        public static AccountApi accountApi = new AccountApi(apiKey, secret, passPhrase);
        public static FundingApi fundingApi = new FundingApi(apiKey, secret, passPhrase);
        public static MarketDataApi marketDataApi = new MarketDataApi(apiKey, secret, passPhrase);
        public static PublicDataApi publicDataApi = new PublicDataApi(apiKey, secret, passPhrase);
        public static TradeApi tradeApi = new TradeApi(apiKey, secret, passPhrase);

        public static Dictionary<string, string> cleanNullKey(Dictionary<string, string> parameters)
        {
            List<string> remove_key = new List<string>();
            foreach (var param in parameters)
            {
                if (string.IsNullOrWhiteSpace(param.Value))
                {
                    remove_key.Add(param.Key);
                }
            }
            remove_key.ForEach(key => parameters.Remove(key));
            return parameters;
        }

        public static Dictionary<string,object> cleanNullKey(Dictionary<string,object> parameters)
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
      
    }
}

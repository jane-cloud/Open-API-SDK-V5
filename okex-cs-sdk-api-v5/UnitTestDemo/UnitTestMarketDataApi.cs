using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestDemo
{
    [TestClass]
    public class UnitTestMarketDataApi
    {
        /// <summary>
        /// 获取所有产品行情信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getTickers()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SPOT";
            requestParameters["uly"] = "";
            var result = await UnitTestBasic.marketDataApi.GetTickers(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取单个产品行情信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getTicker()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            var result = await UnitTestBasic.marketDataApi.GetTicker(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取指数行情
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getIndexTickers()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["quoteCcy"] = "USD";
            requestParameters["instId"] = "";
            var result = await UnitTestBasic.marketDataApi.GetIndexTickers(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取产品深度
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOrderBook()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            requestParameters["sz"] = "";
            var result = await UnitTestBasic.marketDataApi.GetOrderBook(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取所有交易产品K线数据
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getCandlesticks()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["bar"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.marketDataApi.GetCandlesticks(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取交易产品历史K线数据（仅主流币）
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getCandlesticksHistory()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["bar"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.marketDataApi.GetCandlesticksHistory(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取指数K线数据
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getIndexCandlesticks()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["bar"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.marketDataApi.GetIndexCandlesticks(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取标记价格K线数据
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getMarkPriceCandlesticks()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["bar"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.marketDataApi.GetMarkPriceCandlesticks(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取交易产品公共成交数据
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getTrades()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.marketDataApi.GetTrades(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }
    }
}

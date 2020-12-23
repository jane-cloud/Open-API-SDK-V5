using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestDemo
{
    [TestClass]
    public class UnitTestPublicDataApi
    {
        /// <summary>
        /// 获取交易产品基础信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getInstruments()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SPOT";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            var result = await UnitTestBasic.publicDataApi.GetInstruments(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取交割和行权记录
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getDeliveryOrExerciseHistory()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "FUTURES";
            requestParameters["uly"] = "BTC-USD";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.publicDataApi.GetDeliveryOrExerciseHistory(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取持仓总量
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOpenInterest()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SWAP";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            var result = await UnitTestBasic.publicDataApi.GetOpenInterest(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取永续合约当前资金费率
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getFundingRate()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            var result = await UnitTestBasic.publicDataApi.GetFundingRate(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取永续合约历史资金费率
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getFundingRateHistory()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.publicDataApi.GetFundingRateHistory(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取限价
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getLimitPrice()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-SWAP";
            var result = await UnitTestBasic.publicDataApi.GetLimitPrice(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取期权定价
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOptionMarketData()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["uly"] = "BTC-USD";
            requestParameters["expTime"] = "";
            var result = await UnitTestBasic.publicDataApi.GetOptionMarketData(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取预估交割/行权价格
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getEstimatedDeliveryOrExcercisePrice()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USDT-210625";
            var result = await UnitTestBasic.publicDataApi.GetEstimatedDeliveryOrExcercisePrice(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取免息额度和币种折算率
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getDiscountRateAndInterest_FreeQuota()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "";
            var result = await UnitTestBasic.publicDataApi.GetDiscountRateAndInterest_FreeQuota(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取系统时间
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getSystemTime()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            var result = await UnitTestBasic.publicDataApi.GetSystemTime(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取平台公共爆仓单信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getLiquidationOrders()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SWAP";
            requestParameters["mgnMode"] = "";
            requestParameters["instId"] = "";
            requestParameters["ccy"] = "";
            requestParameters["uly"] = "BTC-USD";
            requestParameters["alias"] = "";
            requestParameters["state"] = "filled";
            requestParameters["before"] = "";
            requestParameters["after"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.publicDataApi.GetLiquidationOrders(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取标记价格
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getMarkPrice()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SWAP";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            var result = await UnitTestBasic.publicDataApi.GetMarkPrice(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }
    }
}

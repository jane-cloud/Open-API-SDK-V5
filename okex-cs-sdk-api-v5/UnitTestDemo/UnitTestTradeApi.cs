using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestDemo
{
    [TestClass]
    public class UnitTestTradeApi
    {
        /// <summary>
        /// 下单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task placeOrder()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USDT";
            requestParameters["tdMode"] = "cross";
            requestParameters["ccy"] = "";
            requestParameters["clOrdId"] = "";
            requestParameters["tag"] = "";
            requestParameters["side"] = "buy";
            requestParameters["posSide"] = "";
            requestParameters["ordType"] = "market";
            requestParameters["sz"] = "1000";
            requestParameters["px"] = "";
            requestParameters["reduceOnly"] = "";
            var result = await UnitTestBasic.tradeApi.PlaceOrder(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 批量下单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task placeMultipleOrders()
        {
            Dictionary<string, string> requestParameters1 = new Dictionary<string, string>();
            requestParameters1["instId"] = "BTC-USDT";
            requestParameters1["tdMode"] = "cross";
            requestParameters1["ccy"] = "";
            requestParameters1["clOrdId"] = "testplaceorder120201211";
            requestParameters1["tag"] = "";
            requestParameters1["side"] = "buy";
            requestParameters1["posSide"] = "";
            requestParameters1["ordType"] = "market";
            requestParameters1["sz"] = "1000";
            requestParameters1["px"] = "";
            requestParameters1["reduceOnly"] = "";
            Dictionary<string, string> requestParameters2 = new Dictionary<string, string>();
            requestParameters2["instId"] = "ETH-USDT";
            requestParameters2["tdMode"] = "cross";
            requestParameters2["ccy"] = "";
            requestParameters2["clOrdId"] = "testplaceorder2eth20201211";
            requestParameters2["tag"] = "";
            requestParameters2["side"] = "buy";
            requestParameters2["posSide"] = "";
            requestParameters2["ordType"] = "limit";
            requestParameters2["sz"] = "1";
            requestParameters2["px"] = "550";
            requestParameters2["reduceOnly"] = "";
            var obj1 = UnitTestBasic.cleanNullKey(requestParameters1);
            var obj2 = UnitTestBasic.cleanNullKey(requestParameters2);
            List<Dictionary<string, string>> objs = new List<Dictionary<string, string>>();
            objs.Add(obj1);
            objs.Add(obj2);

            var result = await UnitTestBasic.tradeApi.PlaceMultipleOrders(objs);
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 撤单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task cancelOrder()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "ETH-USDT";
            requestParameters["ordId"] = "";
            requestParameters["clOrdId"] = "testplaceorder2eth20201211";
            var result = await UnitTestBasic.tradeApi.CancelOrder(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 批量撤单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task cancelMultipleOrders()
        {
            Dictionary<string, string> requestParameters1 = new Dictionary<string, string>();
            requestParameters1["instId"] = "ETH-USDT";
            requestParameters1["ordId"] = "";
            requestParameters1["clOrdId"] = "testplaceorder2eth20201211";
            Dictionary<string, string> requestParameters2 = new Dictionary<string, string>();
            requestParameters2["instId"] = "BTC-USDT";
            requestParameters2["ordId"] = "";
            requestParameters2["clOrdId"] = "testplaceorder120201211";
            var obj1 = UnitTestBasic.cleanNullKey(requestParameters1);
            var obj2 = UnitTestBasic.cleanNullKey(requestParameters2);
            List<Dictionary<string, string>> objs = new List<Dictionary<string, string>>();
            objs.Add(obj1);
            objs.Add(obj2);
            var result = await UnitTestBasic.tradeApi.CancelMultipleOrders(objs);
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 修改订单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task amendOrder()
        {
            Dictionary<string, object> requestParameters = new Dictionary<string, object>();
            requestParameters["instId"] = "BTC-USDT";
            requestParameters["cxlOnFail"] = false;
            requestParameters["ordId"] = "";
            requestParameters["clOrdId"] = "testplaceorder120201211";
            requestParameters["reqId"] = "";
            requestParameters["newSz"] = "1.3";
            requestParameters["newPx"] = "16666";
            var result = await UnitTestBasic.tradeApi.AmendOrder(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 批量修改订单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task amendMultipleOrders()
        {
            Dictionary<string, object> requestParameters1 = new Dictionary<string, object>();
            requestParameters1["instId"] = "BTC-USDT";
            requestParameters1["cxlOnFail"] = false;
            requestParameters1["ordId"] = "";
            requestParameters1["clOrdId"] = "testplaceorder120201211";
            requestParameters1["reqId"] = "";
            requestParameters1["newSz"] = "1.3";
            requestParameters1["newPx"] = "16666";
            Dictionary<string, object> requestParameters2 = new Dictionary<string, object>();
            requestParameters2["instId"] = "BTC-USDT";
            requestParameters2["cxlOnFail"] = false;
            requestParameters2["ordId"] = "";
            requestParameters2["clOrdId"] = "testplaceorder120201211";
            requestParameters2["reqId"] = "";
            requestParameters2["newSz"] = "1.3";
            requestParameters2["newPx"] = "16666";
            
            List<Dictionary<string, object>> objs = new List<Dictionary<string, object>>();
            objs.Add(UnitTestBasic.cleanNullKey(requestParameters1));
            objs.Add(UnitTestBasic.cleanNullKey(requestParameters2));
            var result = await UnitTestBasic.tradeApi.AmendMultipleOrders(objs);
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 市价仓位全平
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task closePositions()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USD-201225";
            requestParameters["posSide"] = "long";
            requestParameters["mgnMode"] = "cross";
            requestParameters["ccy"] = "";
            var result = await UnitTestBasic.tradeApi.ClosePositions(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取订单信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOrderDetails()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instId"] = "BTC-USDT";
            requestParameters["ordId"] = "258542316990898178";
            requestParameters["clOrdId"] = "";
            var result = await UnitTestBasic.tradeApi.GetOrderDetails(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取未成交订单列表
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOrderList()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            requestParameters["ordType"] = "";
            requestParameters["state"] = "";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.tradeApi.GetOrderList(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取历史订单记录（近七天）
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOrderHistory_7days()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SWAP";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            requestParameters["ordType"] = "";
            requestParameters["state"] = "";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.tradeApi.GetOrderHistory_7days(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取历史订单记录（近三个月）
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getOrderHistory_3months()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "SWAP";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            requestParameters["ordType"] = "";
            requestParameters["state"] = "";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.tradeApi.GetOrderHistory_3months(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取成交明细
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getTransactionDetails()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["instType"] = "";
            requestParameters["uly"] = "";
            requestParameters["instId"] = "";
            requestParameters["ordId"] = "";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.tradeApi.GetTransactionDetails(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 策略委托下单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task placeAlgoOrder()
        {
            Dictionary<string, object> requestParameters = new Dictionary<string, object>();
            requestParameters["instId"] = "BTC-USDT";
            requestParameters["tdMode"] = "isolated";
            requestParameters["ccy"] = "";
            requestParameters["side"] = "sell";
            requestParameters["posSide"] = "";
            requestParameters["ordType"] = "conditional";
            requestParameters["sz"] = "20";
            requestParameters["reduceOnly"] = false;
            //止盈止损
            requestParameters["tpTriggerPx"] = "23000";
            requestParameters["tpOrdPx"] = "28500";
            requestParameters["slTriggerPx"] = "";
            requestParameters["slOrdPx"] = "";
            //计划委托
            requestParameters["triggerPx"] = "";
            requestParameters["orderPx"] = "";
            var result = await UnitTestBasic.tradeApi.PlaceAlgoOrder(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 撤销策略委托订单
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task cancelAlgoOrder()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["algoId"] = "260170643321270272";
            requestParameters["instId"] = "BTC-USDT";
            List<Dictionary<string, string>> objs = new List<Dictionary<string, string>>();
            objs.Add(UnitTestBasic.cleanNullKey(requestParameters));
            var result = await UnitTestBasic.tradeApi.CancelAlgoOrder(objs);
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取未完成策略委托单列表
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getAlgoOrderList()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["algoId"] = "260170643321270272";
            requestParameters["instType"] = "";
            requestParameters["instId"] = "";
            requestParameters["ordType"] = "conditional";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.tradeApi.GetAlgoOrderList(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取历史策略委托单列表
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getAlgoOrderHistory()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["state"] = "canceled";
            requestParameters["algoId"] = "";
            requestParameters["instType"] = "";
            requestParameters["instId"] = "";
            requestParameters["ordType"] = "conditional";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.tradeApi.GetAlgoOrderHistory(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }
    }
}

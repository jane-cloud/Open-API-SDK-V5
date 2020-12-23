using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestDemo
{
    [TestClass]
    public class UnitTestFundingApi
    {
        /// <summary>
        /// 获取充值地址信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getDepositAddress()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "BTC";
            var result = await UnitTestBasic.fundingApi.GetDepositAddress(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取资金账户余额信息
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getBalance()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            var result = await UnitTestBasic.fundingApi.GetBalance(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 资金划转
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task fundsTransfer()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "USDT";
            requestParameters["amt"] = "10";
            requestParameters["type"] = "0";
            requestParameters["from"] = "1";
            requestParameters["to"] = "3";
            requestParameters["subAcct"] = "";
            requestParameters["instId"] = "";
            requestParameters["toInstId"] = "BTC-USDT";
            var result = await UnitTestBasic.fundingApi.FundsTransfer(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 提币
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task withdrawal()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "USDT";
            requestParameters["amt"] = "10";
            requestParameters["dest"] = "3";
            requestParameters["toAddr"] = "ARDOR-7JF3-8F2E-QUWZ-CAN7F:123456";
            requestParameters["pwd"] = "123456";
            requestParameters["fee"] = "1";
            var result = await UnitTestBasic.fundingApi.Withdrawal(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 充值记录
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getDepositHistory()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "";
            var result = await UnitTestBasic.fundingApi.GetDepositHistory(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 提币记录
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getWithdrawalHistory()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "";
            requestParameters["state"] = "";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.fundingApi.GetWithdrawalHistory(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 获取币种列表
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task getCurrencies()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            var result = await UnitTestBasic.fundingApi.GetCurrencies(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }

        /// <summary>
        /// 余币宝申购/赎回
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task piggyBankPurchaseOrRedemption()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "BTC";
            requestParameters["amt"] = "0.1";
            requestParameters["side"] = "purchase";
            var result = await UnitTestBasic.fundingApi.PiggyBankPurchasOrRedemption(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }


        /// <summary>
        /// 资金流水查询
        /// </summary>
        /// <returns></returns>
        [TestMethod]
        public async Task assetBillsDetails()
        {
            Dictionary<string, string> requestParameters = new Dictionary<string, string>();
            requestParameters["ccy"] = "BTC";
            requestParameters["type"] = "";
            requestParameters["after"] = "";
            requestParameters["before"] = "";
            requestParameters["limit"] = "";
            var result = await UnitTestBasic.fundingApi.AssetBillsDetails(UnitTestBasic.cleanNullKey(requestParameters));
            System.Console.WriteLine(result);
        }
    }
}

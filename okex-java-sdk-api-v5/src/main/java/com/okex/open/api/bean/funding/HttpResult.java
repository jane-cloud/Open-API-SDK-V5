package com.okex.open.api.bean.funding;

import java.util.List;

public class HttpResult {

    private int code;



    private String msg;
    private int sCode;

    public int getsCode() {
        return sCode;
    }

    public void setsCode(int sCode) {
        this.sCode = sCode;
    }

    public String getsMsg() {
        return sMsg;
    }

    public void setsMsg(String sMsg) {
        this.sMsg = sMsg;
    }

    private String sMsg;

    private List data;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }




// [{"code":"50001","data":[],"msg":"Service temporarily unavailable. Try again later"}]

    @Override
    public String toString() {
//        return "Response Body:{" + "code : " + code + ",data:[], msg : " + msg + "}";
        return "\t\tResponse Body:{" + "\"code\":\"" + code+"\",\"data\":[],\"msg\":\""+msg+"\"}";


    }


//    public String toString() {
//        return "HttpResult{" +
//                "code=" + code +
//                ", message='" + msg + '\'' +
//                ", msg='" + msg + '\'' +
//                ", errorCode=" + sCode +
//                ", errorMessage='" + sMsg + '\'' +
//                ", order_id='" + order_id + '\'' +
//                ", result=" + result +
//                '}';
//    }
}
package com.okex.open.api.test.ws.publicChannel.config;

public class WebSocketConfig {
    //ws  模拟盘
//    private static final String SERVICE_URL = "wss://ws.okex.com:8443/ws/v5/public?brokerId=9999";
    //ws  实盘
    private static final String SERVICE_URL = "wss://ws.okex.com:8443/ws/v5/public";


    // api key
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";
    private static final String PASSPHRASE = "";



    public static void publicConnect(WebSocketClient webSocketClient) {
        System.out.println(SERVICE_URL);
        WebSocketClient.connection(SERVICE_URL);
    }

    public static void loginConnect(WebSocketClient webSocketClient) {
        System.out.println(SERVICE_URL);
        //与服务器建立连接
        WebSocketClient.connection(SERVICE_URL);
        //登录账号,用户需提供 api-key，passphrase,secret—key 不要随意透漏 ^_^
        WebSocketClient.login(API_KEY , PASSPHRASE , SECRET_KEY);

    }
}

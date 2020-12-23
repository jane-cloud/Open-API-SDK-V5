package com.okex.open.api.test.ws.tradeChannel.config;

import com.alibaba.fastjson.JSONArray;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.okex.open.api.bean.other.SpotOrderBook;
import com.okex.open.api.enums.CharsetEnum;
import com.okex.open.api.test.ws.tradeChannel.TradeChannelTest;
import com.okex.open.api.utils.DateUtils;
import net.sf.json.JSONObject;
import okhttp3.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class WebSocketClient {
    private static WebSocket webSocket = null;
    private static Boolean flag = true;
    private static Boolean isConnect = false;
    private static String sign;
    private final static HashFunction crc32 = Hashing.crc32();
    private static Map<String,Optional<SpotOrderBook>> bookMap = new HashMap<>();
    private static Logger logger = Logger.getLogger(TradeChannelTest.class);
    public WebSocketClient() {
    }



    //与服务器建立连接，参数为服务器的URL
    public static WebSocket connection(final String url) {

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();

        webSocket = client.newWebSocket(request, new WebSocketListener() {
            ScheduledExecutorService service;

            @Override
            public void onOpen(final WebSocket webSocket, final Response response) {
                //连接成功后，设置定时器，每隔25s，自动向服务器发送心跳，保持与服务器连接
                isConnect = true;
                System.out.println(Instant.now().toString() + " Connected to the server success!");
                Runnable runnable = new Runnable() {
                    public void run() {
                        // task to run goes here
                        sendMessage("ping");
                    }
                };
                service = Executors.newSingleThreadScheduledExecutor();
                // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
                service.scheduleAtFixedRate(runnable, 25, 25, TimeUnit.SECONDS);
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                System.out.println("Connection is about to disconnect！");
                webSocket.close(1000, "Long time no message was sent or received！");
                webSocket = null;
            }

            @Override
            public void onClosed(final WebSocket webSocket, final int code, final String reason) {
                System.out.println("Connection dropped！");
            }

            @Override
            public void onFailure(final WebSocket webSocket, final Throwable t, final Response response) {
                System.out.println("Connection failed,Please reconnect!");
                if (Objects.nonNull(service)) {

                    service.shutdown();
                }
            }

            @Override
            public void onMessage(final WebSocket webSocket, final String bytes) {
                //测试服务器返回的字节
                final String byteString=bytes.toString();

                final String s = byteString;

                System.out.println(DateFormatUtils.format(new Date(), DateUtils.TIME_STYLE_S4) + " Receive: " + s);

                if (null != s && s.contains("login")) {
                    if (s.endsWith("true}")) {
                        flag = true;
                    }
                }
            }
        });
        return webSocket;
    }



    private static void isLogin(String s) {
        if (null != s && s.contains("login")) {
            if (s.endsWith("true}")) {
                flag = true;
            }
        }
    }

    //获得sign
    private static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(CharsetEnum.UTF_8.charset()), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes(CharsetEnum.UTF_8.charset()));
            hash = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    private static String listToJson(List<Map> list) {
        JSONArray jsonArray = new JSONArray();
        for (Map map : list) {
            jsonArray.add(JSONObject.fromObject(map));
        }
        return jsonArray.toJSONString();
    }

    //登录
    public static void login(String apiKey, String passPhrase, String secretKey) {
        String timestamp = DateTime.now().getMillis() / 1000+ "";
        String message = timestamp + "GET" + "/users/self/verify";
        sign = sha256_HMAC(message, secretKey);
        String str = "{\"op\"" + ":" + "\"login\"" + "," + "\"args\"" + ":" + "[{" + "\"apiKey\"" + ":"+ "\"" + apiKey + "\"" + "," + "\"passphrase\"" + ":" + "\"" + passPhrase + "\"" + ","+ "\"timestamp\"" + ":"  + "\"" + timestamp + "\"" + ","+ "\"sign\"" + ":"  + "\"" + sign + "\"" + "}]}";
        sendMessage(str);
    }


    //ws下单 Place Order
    public static void wsPlaceOrder(List<Map> list,String id) {
        String s = listToJson(list);
        String str = "{\"id\": \""+id+"\",\"op\": \"order\", \"args\":" + s + "}";

        if (null != webSocket)
            sendMessage(str);
    }

    //ws批量下单 Place Multiple Orders
    public static void wsPlaceMultipleOrders(List<Map> list,String id) {
        String s = listToJson(list);
        String str = "{\"id\": \""+id+"\",\"op\": \"batch-orders\", \"args\":" + s + "}";

        if (null != webSocket)
            sendMessage(str);
    }

    //ws撤单 Cancel Order
    public static void wsCancelOrder(List<Map> list,String id) {
        String s = listToJson(list);
        String str = "{\"id\": \""+id+"\",\"op\": \"cancel-order\", \"args\":" + s + "}";

        if (null != webSocket)
            sendMessage(str);
    }

    //ws批量撤单 Cancel Order
    public static void wsCancelMultipleOrders(List<Map> list,String id) {
        String s = listToJson(list);
        String str = "{\"id\": \""+id+"\",\"op\": \"batch-cancel-orders\", \"args\":" + s + "}";

        if (null != webSocket)
            sendMessage(str);
    }

    //ws改单 Amend Order
    public static void wsAmendOrder(List<Map> list,String id) {
        String s = listToJson(list);
        String str = "{\"id\": \""+id+"\",\"op\": \"amend-order\", \"args\":" + s + "}";

        if (null != webSocket)
            sendMessage(str);
    }

    //ws批量改单 Amend Multiple Orders
    public static void wsAmendMultipleOrders(List<Map> list,String id) {
        String s = listToJson(list);
        String str = "{\"id\": \""+id+"\",\"op\": \"batch-amend-orders\", \"args\":" + s + "}";

        if (null != webSocket)
            sendMessage(str);
    }



    private static void sendMessage(String str) {
        if (null != webSocket) {
            try {
                Thread.sleep(1300);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Send a message to the server:" + str);
            webSocket.send(str);
        } else {
            System.out.println("Please establish the connection before you operate it！");
        }
    }

    //断开连接
    public static void closeConnection() {
        if (null != webSocket) {
            webSocket.close(1000, "User actively closes the connection");
        } else {
            System.out.println("Please establish the connection before you operate it！");
        }
    }

    public boolean getIsLogin() {
        return flag;
    }

    public boolean getIsConnect() {
        return isConnect;
    }


}

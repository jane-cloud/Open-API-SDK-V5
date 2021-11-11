package com.okcoin.websocket;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.okcoin.websocket.WebSocket.CHANNEL_NAME;

@Slf4j
public class MsgFactory {



    public static String createPingMsg() {
        return "ping";
    }

    public static JSONObject subOrUnSub() {
        String[] split = CHANNEL_NAME.split(",");
        JSONObject obj = new JSONObject();
        List<JSONObject> tmp = new ArrayList<>();
        obj.put("op", "subscribe");
        for (String str : split) {
            try {
                String[] channel = str.split("#");
                String name = channel[0];
                String instId = channel[1];
                JSONObject channelObj = new JSONObject();
                channelObj.put("channel", name);
                channelObj.put("instId", instId);
                tmp.add(channelObj);
            } catch (Exception e) {
                log.info("", e);
            }
        }
        obj.put("args", tmp);
        return obj;
    }

}

package com.okcoin.websocket;

import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;

/**
 * @author okcoin
 */
public interface WebsocketClient {
    void start();
    void send(Object text);
    void connect();
    WebSocketClientHandshaker createHandleShake();
}

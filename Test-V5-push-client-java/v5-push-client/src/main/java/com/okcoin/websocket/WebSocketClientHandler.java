package com.okcoin.websocket;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.TimeUnit;


/**
 * @author okcoin
 */

@ChannelHandler.Sharable
@Slf4j
public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object> implements ApplicationListener<ApplicationEvent> {

    private final WebSocket websocket;
    private WebSocketClientHandshaker handshake;
    private ChannelPromise handshakeFuture;
    private boolean sub = false;

    public WebSocketClientHandler(WebSocket webSocketClient) {
        this.websocket = webSocketClient;
        this.websocket.start();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        handshakeFuture = ctx.newPromise();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("websocket client connected!");
        this.handshake = this.websocket.createHandleShake();
        this.handshake.handshake(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("WebSocket Client disconnected!");
        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(this.websocket::connect, 1, TimeUnit.SECONDS);
        ctx.fireChannelInactive();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.ALL_IDLE) {
                //读写空闲
                this.websocket.send(MsgFactory.createPingMsg());
            }
        } else {
            log.info(evt.toString());
        }
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) {
        Channel ch = ctx.channel();
        if (!handshake.isHandshakeComplete()) {
            handshake.finishHandshake(ch, (FullHttpResponse) msg);
            System.out.println("WebSocket Client connected!");
            handshakeFuture.setSuccess();
            if (WebSocket.URL.contains("coinall")) {
                subOrUnSub(false);
            } else {
                subOrUnSub(false);
            }
            return;
        }

        if (msg instanceof FullHttpResponse) {
            FullHttpResponse response = (FullHttpResponse) msg;
            throw new IllegalStateException(
                    "Unexpected FullHttpResponse (getStatus=" + response.status() +
                            ", content=" + response.content().toString(CharsetUtil.UTF_8) + ')');
        }

        WebSocketFrame frame = (WebSocketFrame) msg;
        if (frame instanceof CloseWebSocketFrame) {
            CloseWebSocketFrame closeFrame = (CloseWebSocketFrame) frame;
            int closeCode = closeFrame.statusCode();
            System.out.println("Close code = " + closeCode);
        } else if (frame instanceof TextWebSocketFrame) {
            String txt = ((TextWebSocketFrame) msg).text();
            if (!txt.equals("pong")) {
                onMsg(txt);
                if (txt.contains("unsubscribe")) {
                    subOrUnSub(false);
                }
                if (txt.contains("askSz")) {
                    if (sub == false) {
                        sub = true;
                    }
                }
            }
        } else {
            System.out.println();
        }
    }

    public void onMsg(String txt) {

        //测试服务器返回的字节
        final String byteString = txt;

        //不进行解压
        final String s = byteString;
        //判断是否是深度接口
        if (s.contains("\"channel\":\"books\",") || s.contains("\"channel\":\"books-l2-tbt\",")) {
            //是深度接口
            if (s.contains("\"action\":\"update\",")) {//是后续的增量，则需要进行深度合并

                net.sf.json.JSONObject rst = net.sf.json.JSONObject.fromObject(s);
                net.sf.json.JSONObject arg = net.sf.json.JSONObject.fromObject(rst.get("arg"));
                net.sf.json.JSONArray dataArr = net.sf.json.JSONArray.fromObject(rst.get("data"));
                net.sf.json.JSONObject data = net.sf.json.JSONObject.fromObject(dataArr.get(0));
                Long ts = Long.valueOf(data.get("ts").toString());
                long now = System.currentTimeMillis();
                long latency = now - ts;
                String instrumentId = arg.get("instId").toString();
                String channelName = arg.get("channel").toString();
                log.info("channelName: {}, instrumentId: {}, latencyMs={}", channelName, instrumentId, latency);
                if (true) {
                    return;
                }

            }
        }

    }

    private void subOrUnSub(boolean unSub) {
        com.alibaba.fastjson.JSONObject obj = MsgFactory.subOrUnSub();
        this.websocket.send(obj);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        if (!handshakeFuture.isDone()) {
            handshakeFuture.setFailure(cause);
        }
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("event: {}", event);
    }

}
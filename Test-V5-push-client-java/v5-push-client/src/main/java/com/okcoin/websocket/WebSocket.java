package com.okcoin.websocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author okcoin
 */
@Slf4j
public class WebSocket implements WebsocketClient {

    public static final String URL = System.getProperty("url", "wss://wspri.okex.com:8443/ws/v5/public");
    public static final String CHANNEL_NAME = System.getProperty("channel", "books-l2-tbt#BTC-USDT,books50-l2-tbt#BTC-USDT-SWAP");



    private WebSocketClientHandler handler;
    private Bootstrap bootstrap = null;
    private Channel ch = null;
    private ConnectionListener connectionListener;
    private String host;
    private int port;
    private URI uri;


    public WebSocket() {
        this.handler = new WebSocketClientHandler(this);
    }

    @Override
    public void start() {
        this.connectionListener = new ConnectionListener();
        this.run();
    }

    @Override
    public void send(Object text) {
        String value = text.toString();
        WebSocketFrame frame = new TextWebSocketFrame(value);
        ch.writeAndFlush(frame);
    }

    @Override
    public void connect() {
        synchronized (bootstrap) {
            ChannelFuture connectFuture = bootstrap.connect(this.host, this.port);
            connectFuture.addListener(this.connectionListener);
            ch = connectFuture.channel();
        }
    }

    @Override
    public WebSocketClientHandshaker createHandleShake() {
        return WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, true, new DefaultHttpHeaders());
    }

    public void send(String msg) {
        WebSocketFrame frame = new TextWebSocketFrame(msg);
        ch.writeAndFlush(frame);
    }

    public void run() {
        try {
            uri = new URI(URL);
            String scheme = uri.getScheme() == null ? "ws" : uri.getScheme();
            host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
            port = uri.getPort() > 0 ? uri.getPort() : 80;

            if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
                System.err.println("only ws is support");
                return;
            }

            final boolean ssl = "wss".equalsIgnoreCase(scheme);
            final SslContext sslCtx;
            if (ssl) {
                sslCtx = SslContextBuilder.forClient()
                        .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            } else {
                sslCtx = null;
            }
            log.info("begin connect url={}", uri);
            EventLoopGroup group = new NioEventLoopGroup(1);
            try {
                bootstrap = new Bootstrap();
                bootstrap.group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) {
                                ChannelPipeline p = ch.pipeline();
                                if (sslCtx != null) {
                                    p.addLast(sslCtx.newHandler(ch.alloc(), host, port));
                                }
                                p.addLast(
                                        new HttpClientCodec(),
                                        new HttpObjectAggregator(8192),
                                        new IdleStateHandler(3, 0, 5, TimeUnit.SECONDS),
                                        WebSocketClientCompressionHandler.INSTANCE,
                                        handler);
                            }
                        });
                ch = bootstrap.connect(uri.getHost(), port).addListener(this.connectionListener).sync().channel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

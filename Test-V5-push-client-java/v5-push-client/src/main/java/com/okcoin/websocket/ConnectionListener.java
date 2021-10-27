package com.okcoin.websocket;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author okcoin
 */
@Slf4j
public class ConnectionListener implements ChannelFutureListener {
    @Override
    public void operationComplete(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            log.error("websocket disconnect,begin to reconnect...");
            channelFuture.channel().pipeline().fireChannelInactive();
        } else {
            log.info("websocket connect success");
        }
    }
}
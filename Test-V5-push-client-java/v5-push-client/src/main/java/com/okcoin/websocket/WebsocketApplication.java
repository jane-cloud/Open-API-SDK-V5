package com.okcoin.websocket;

/**
 * Created by junguo ma on 2017/7/11.
 * This is an example of a WebSocket client.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author okcoin
 */
public final class WebsocketApplication {


    public static void main(String[] args) throws InterruptedException {
        int clientNum = 1;
        if (args.length > 0) {
            clientNum = Integer.valueOf(args[0]);
        }
        CountDownLatch latch = new CountDownLatch(1);
        final int coreCount = 1;//Runtime.getRuntime().availableProcessors();
        final ExecutorService poolLoader = Executors.newFixedThreadPool(coreCount);
        int finalClientNum = clientNum;
        for (int idx = 0; idx < finalClientNum; idx++) {
            poolLoader.submit(() -> {
                WebSocket client = new WebSocket();
                client.run();
            });
            Thread.sleep(10);
        }
        latch.await();


    }
}

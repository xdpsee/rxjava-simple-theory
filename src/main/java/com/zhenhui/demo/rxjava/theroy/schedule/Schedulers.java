package com.zhenhui.demo.rxjava.theroy.schedule;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Schedulers {

    private static final BlockingQueue<Runnable> mainQueue = new LinkedBlockingQueue<>();
    private static final Scheduler ioScheduler = new Scheduler(Executors.newCachedThreadPool());
    private static final Scheduler mainScheduler = new Scheduler(mainQueue);

    public static Scheduler io() {
        return ioScheduler;
    }

    public static Scheduler mainThread() {
        return mainScheduler;
    }

    public static void runLoop() throws InterruptedException {
        while (true) {
            mainQueue.take().run();
        }
    }
}



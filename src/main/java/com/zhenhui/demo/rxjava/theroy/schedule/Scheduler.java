package com.zhenhui.demo.rxjava.theroy.schedule;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class Scheduler {

    private Executor executor;
    private BlockingQueue<Runnable> blockingQueue;

    public Scheduler(Executor executor) {
        this.executor = executor;
    }

    public Scheduler(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Worker createWorker() {
        return new Worker(executor, blockingQueue);
    }

    public static class Worker {
        final Executor executor;
        final BlockingQueue<Runnable> blockingQueue;

        public Worker(Executor executor, BlockingQueue<Runnable> blockingQueue) {
            this.executor = executor;
            this.blockingQueue = blockingQueue;
        }

        public void schedule(Action0 action) {
            if (executor != null) {
                executor.execute(action);
            } else if (blockingQueue != null) {
                blockingQueue.add(action);
            }
        }
    }
}

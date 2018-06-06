package com.zhenhui.demo.rxjava.theroy.schedule;

import java.util.concurrent.Executor;

public class Scheduler {

    final Executor executor;

    public Scheduler(Executor executor) {
        this.executor = executor;
    }

    public Worker createWorker() {
        return new Worker(executor);
    }

    public static class Worker {
        final Executor executor;

        public Worker(Executor executor) {
            this.executor = executor;
        }

        public void schedule(Action0 action) {
            executor.execute(action);
        }
    }
}

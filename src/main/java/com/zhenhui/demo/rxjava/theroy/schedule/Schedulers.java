package com.zhenhui.demo.rxjava.theroy.schedule;

import java.util.concurrent.Executors;

public class Schedulers {

    private static final Scheduler ioScheduler = new Scheduler(Executors.newCachedThreadPool());

    public static Scheduler io() {
        return ioScheduler;
    }

}

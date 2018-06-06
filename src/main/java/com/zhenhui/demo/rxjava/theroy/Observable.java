package com.zhenhui.demo.rxjava.theroy;

import com.zhenhui.demo.rxjava.theroy.schedule.Action0;
import com.zhenhui.demo.rxjava.theroy.schedule.Scheduler;

public class Observable<T> {

    final OnSubscribe<T> onSubscribe;

    public Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<T>(onSubscribe);
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        subscriber.onStart();
        onSubscribe.call(subscriber);
    }

    public <R> Observable<R> map(final Transformer<? super T, ? extends R> transformer) {
        return create(new OnSubscribe<R>() {
            public void call(final Subscriber<? super R> subscriber) {
                Observable.this.subscribe(new Subscriber<T>() {
                    public void onNext(T var) {
                        subscriber.onNext(transformer.call(var));
                    }

                    public void onComplete() {
                        subscriber.onComplete();
                    }

                    public void onError(Throwable t) {
                        subscriber.onError(t);
                    }
                });
            }
        });
    }

    public Observable<T> subscribeOn(Scheduler scheduler) {
        return Observable.create(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onStart();

                scheduler.createWorker().schedule(new Action0() {
                    @Override
                    public void run() {
                        Observable.this.onSubscribe.call(subscriber);
                    }
                });
            }
        });
    }
}





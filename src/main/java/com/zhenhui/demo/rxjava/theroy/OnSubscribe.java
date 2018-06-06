package com.zhenhui.demo.rxjava.theroy;

public interface OnSubscribe<T> {

    void call(Subscriber<? super T> subscriber);

}

package com.zhenhui.demo.rxjava.theroy;

public interface Observer<T> {

    void onNext(T var);

    void onComplete();

    void onError(Throwable t);

}

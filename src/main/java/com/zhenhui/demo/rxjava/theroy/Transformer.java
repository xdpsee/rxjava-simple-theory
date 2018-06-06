package com.zhenhui.demo.rxjava.theroy;

public interface Transformer<T, R> {

    R call(T from);

}


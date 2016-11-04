package com.xiuzhu.data.remote;


public interface SubscriberListener<T> {
    void onStart();

    void onCompleted();

    void onNext(T t);

    void onError(int code, String message);
}

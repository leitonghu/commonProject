package com.xiuzhu.data.remote;

import com.xiuzhu.data.bean.BaseBean;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

public class BaseSubscriber<T> extends Subscriber<BaseBean<T>> {

    private SubscriberListener mSubscriberListener;

    public BaseSubscriber(SubscriberListener subscriberListener) {
        this.mSubscriberListener = subscriberListener;
    }

    @Override
    public void onError(Throwable e) {

        if (e instanceof SocketTimeoutException) {
            if (mSubscriberListener != null) {
                mSubscriberListener.onError(ExceptionCode.NETERROR, "网络超时，请检查您的网络状态");
            }
        } else if (e instanceof ConnectException) {
            if (mSubscriberListener != null) {
                mSubscriberListener.onError(ExceptionCode.NETERROR, "网络中断，请检查您的网络状态");
            }
        } else {
            if (mSubscriberListener != null) {
                mSubscriberListener.onError(ExceptionCode.UNKONWERROR, e.getMessage());
            }
        }

    }

    @Override
    public void onStart() {
        if (mSubscriberListener != null) {
            mSubscriberListener.onStart();
        }
    }

    @Override
    public void onCompleted() {
        if (mSubscriberListener != null) {
            mSubscriberListener.onCompleted();
        }
    }

    @Override
    public void onNext(BaseBean<T> t) {

        int errorCode = t.getErrcode();
        if (errorCode == 0) {
            if (mSubscriberListener != null) {
                mSubscriberListener.onNext(t);
            }
        } else {
            if (mSubscriberListener != null) {
                mSubscriberListener.onError(t.getErrcode(), t.getErrmsg());
            }
        }

    }

    /**
     * 取消http请求
     */
    public void unSubscribe() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

}

package com.xiuzhu.data;

import com.sd.core.utils.encrypt.Base64;
import com.xiuzhu.data.remote.RetrofitServerClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by youdeyi on 2016/10/17.
 */

public class DataManager {

    private static DataManager instance;

    /**
     * DCL形式获取DataManager单例
     *
     * @return 单例对象
     */
    public static DataManager getInstance() {
        if (instance == null) {
            Class var0 = DataManager.class;
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager();
                }
            }
        }
        return instance;
    }

    protected DataManager() {
    }

    public Observable uploadFile(String filename, String type, String code) {
        Observable observable = RetrofitServerClient.getLoginApi().uploadFile(filename, code, type);
        return observable;
    }


    public Subscription covertVoiceFile(final String filename, Observer<String> observer) {

        Subscription subscription = rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String result = covert(filename);
                subscriber.onNext(result);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(observer);

        return subscription;

    }

    private String covert(String filename) {
        File fi = new File(filename);
        if (!fi.exists()) {
            return null;
        }
        byte[] data = null;
        try {
            InputStream is = new FileInputStream(fi);
            data = new byte[is.available()];
            is.read(data);
            is.close();
            String amrString = new String(Base64.encode(data));
            return amrString;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


}

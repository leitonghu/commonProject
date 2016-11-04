package com.xiuzhu.module.login;

import android.text.TextUtils;
import android.util.Log;

import com.sd.core.base.BasePresenter;
import com.xiuzhu.data.bean.LoginResultBean;
import com.xiuzhu.data.bean.UserInfoBean;
import com.xiuzhu.data.remote.BaseSubscriber;
import com.xiuzhu.data.remote.RetrofitServerClient;
import com.xiuzhu.data.remote.SubscriberListener;
import com.xiuzhu.utils.SignUtil;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by youdeyi on 2016/10/17.
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    private ILoginView mLoginView;
    private String sErrorMsg;

    public LoginPresenter(ILoginView view) {
        attachView(view);
    }

    @Override
    public void attachView(ILoginView mvpView) {
        this.mLoginView = mvpView;
    }

    @Override
    public void detachView() {
        mLoginView = null;
        unSubscribe();
    }

    @Override
    public void loginToServer(String username, String password, int mode) {

        //请求前
        mLoginView.showProgress(true);
        String type = SignUtil.getUserType();
        username = SignUtil.getUsername(username);
        password = SignUtil.getPassword(password);
        if (mode == 1) {
            login01(username, password, type);
        } else {
            login02(username, password, type);
        }

    }

    /**
     * demo1:如果需要嵌套的时候建议使用该demo方式，如登录情况，需要先获取token再获取userinfo
     *
     * @param username
     * @param password
     * @param type
     */
    private void login01(String username, String password, String type) {

        sErrorMsg = "";
        Subscription subscription = RetrofitServerClient.getLoginApi().login(username, password, type)
                .flatMap(new Func1<LoginResultBean, Observable<UserInfoBean>>() {
                    //调用login接口返回uid和token值后获取用户信息,非主线程，不能直接做UI更新
                    @Override
                    public Observable<UserInfoBean> call(LoginResultBean loginResultBean) {

                        Log.e("Login", "loginResult=" + loginResultBean.toString());
                        Log.e("Login", "loginResult.error=" + loginResultBean.getErrmsg());
                        if (loginResultBean == null) {
                            sErrorMsg = "result is null";
                            return null;
                        }
                        if (loginResultBean.getErrcode() == 0) {
                            return RetrofitServerClient.getUserInfoApi().getUserInfo(loginResultBean.getUid(), loginResultBean.getAccess_token());
                        } else {
                            sErrorMsg = loginResultBean.getErrmsg();
                            return null;
                        }

                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Action1<UserInfoBean>() {
                    @Override
                    public void call(UserInfoBean userInfo) {

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//在主线程中执行
                .subscribe(new Observer<UserInfoBean>() {
                    @Override
                    public void onNext(UserInfoBean user) {

                        if (user != null && user.getData() != null) {
                            //完成一次完整的登录请求
                            //将用户信息保存到本地

                            Log.e("Login", "onNext:user.data=" + user.getData().toString());
                        }
                    }

                    @Override
                    public void onCompleted() {
                        Log.e("Login", "onCompleted");
                        mLoginView.showProgress(false);
                        if (!TextUtils.isEmpty(sErrorMsg)) {
                            mLoginView.showErrorInfo(0, sErrorMsg, sErrorMsg);
                        } else {
                            mLoginView.loginSuc();
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        //请求失败
                        Log.e("Login", "onError:error=" + error.getMessage());
                        mLoginView.showProgress(false);
                        mLoginView.showErrorInfo(0, error.getMessage(), error.getMessage());
                    }
                });

        addSubscribe(subscription);
    }


    /**
     * demo2：不需要嵌套时建议使用该demo，已经封装好返回数据，只有errorcode=0时才成功
     *
     * @param username
     * @param password
     * @param type
     */
    void login02(String username, String password, String type) {
        //请求前
        mLoginView.showProgress(true);
        Observable observable = RetrofitServerClient.getLoginApi().login(username, password, type);
        toSubscribe(observable, new BaseSubscriber(new SubscriberListener<LoginResultBean>() {
            @Override
            public void onStart() {
                Log.e("retrofitTest", "onStart");
            }

            @Override
            public void onCompleted() {
                Log.e("retrofitTest", "onCompleted");
                mLoginView.showProgress(false);
            }

            @Override
            public void onNext(LoginResultBean data) {
                Log.e("retrofitTest", "data=" + data.toString());
                if (data.getErrcode() == 0) {
                    Log.e("retrofitTest", "get data success!");
                    mLoginView.showErrorInfo(0, data.getErrmsg(), "获取token成功");
                }
            }

            @Override
            public void onError(int code, String message) {
                //请求失败
                Log.e("retrofitTest", "onError:code=" + code + ";errorMsg=" + message);
                mLoginView.showProgress(false);
                mLoginView.showErrorInfo(0, message, message);
            }
        }));

    }

}

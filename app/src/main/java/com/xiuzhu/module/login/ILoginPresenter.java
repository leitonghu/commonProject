package com.xiuzhu.module.login;

import com.sd.core.base.Presenter;

/**
 * Created by youdeyi on 2016/10/17.
 */

public interface ILoginPresenter extends Presenter<ILoginView>{

    void detachView();
    /**
     * 登录
     * @param userName
     * @param password
     */
    public void loginToServer(String userName,String password, int mode);

}

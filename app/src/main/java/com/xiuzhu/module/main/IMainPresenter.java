package com.xiuzhu.module.main;

import com.sd.core.base.Presenter;

/**
 * Created by youdeyi on 2016/10/17.
 */

public interface IMainPresenter extends Presenter<IMainView> {

    void detachView();

    void startRecord();

    void stopRecord();

    void upload(String filename);


}

package com.xiuzhu.module.main;

import com.sd.core.base.MvpView;
import com.xiuzhu.data.bean.MsgBean;

/**
 * Created by youdeyi on 2016/11/2.
 */

public interface IMainView extends MvpView {

    void setRecordStatus();

    void releaseRecordStatus();

    void updateMsgList(MsgBean msgBean);

    void showMsg(String msg);


}

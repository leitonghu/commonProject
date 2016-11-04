package com.xiuzhu.module.main;

import android.os.CountDownTimer;

import com.sd.core.base.BasePresenter;
import com.sd.core.utils.NLog;
import com.xiuzhu.data.DataManager;
import com.xiuzhu.data.bean.MsgBean;
import com.xiuzhu.module.audio.MediaRecordFunc;

import rx.Observer;

/**
 * Created by youdeyi on 2016/10/17.
 */

public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    private IMainView mMainView;
    private String audioName;
    private long lStartTime;
    private CountDownTimer mDownTimer;
    private final int MAX_RECORD_LEN = 60000;


    public MainPresenter(IMainView view) {
        attachView(view);
    }

    @Override
    public void attachView(IMainView mvpView) {
        this.mMainView = mvpView;
    }

    @Override
    public void detachView() {
        mMainView = null;
        cancelCountTimer();
        unSubscribe();

    }

    /**
     * 开始录音
     */
    public void startRecord() {

        try {
            MediaRecordFunc recordFunc = MediaRecordFunc.getInstance();
            lStartTime = System.currentTimeMillis();
            int ret = recordFunc.startRecord();
            audioName = recordFunc.getAudioFilePath();
            if (ret == -1) {
                recordFunc.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cancelCountTimer();
        if (mDownTimer == null) {
            mDownTimer = new CountDownTimer(MAX_RECORD_LEN, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    stopRecord();
                    mMainView.showMsg("60s时间到");
                }
            }.start();
        }


    }

    private void cancelCountTimer() {
        if (mDownTimer != null) {
            mDownTimer.cancel();
            mDownTimer = null;
        }
    }

    @Override
    public void stopRecord() {
        cancelCountTimer();
        try {
            MediaRecordFunc mRecord = MediaRecordFunc.getInstance();
            mRecord.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        long endTime = System.currentTimeMillis();
        int useTime = (int) (endTime - lStartTime) / 1000;
        if (useTime < 1) {
            mMainView.showMsg("录音太短");
            return;
        }

        MsgBean bean = new MsgBean(audioName, useTime);
        mMainView.updateMsgList(bean);
        upload(audioName);

    }


    @Override
    public void upload(String filename) {
        DataManager.getInstance().covertVoiceFile(filename, coverObserver);
    }

    Observer<String> coverObserver = new Observer<String>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            mMainView.showMsg("转换失败");
        }

        @Override
        public void onNext(String data) {
            if (data != null) {
                NLog.e("covert", "data=" + data);
//                mMainView.showMsg("转换完成");
            } else {
                mMainView.showMsg("转换失败");
            }
        }
    };


}

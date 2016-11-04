package com.xiuzhu.module.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.xiuzhu.data.bean.MsgBean;
import com.xiuzhu.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements IMainView, View.OnTouchListener {

    @BindView(R.id.record_btn)
    Button mVoiceBnt;
    @BindView(R.id.main_msg_list)
    ListView mMsgList;

    private MainAdapter mListAdapter;

    private MainPresenter mMainPresenter;
    private List<MsgBean> msgBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainPresenter = new MainPresenter(this);
        mVoiceBnt.setOnTouchListener(this);
        mListAdapter = new MainAdapter(this, msgBeanList);
        mMsgList.setAdapter(mListAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMainPresenter != null) {
            mMainPresenter.detachView();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setRecordStatus();
                mMainPresenter.startRecord();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                releaseRecordStatus();
                mMainPresenter.stopRecord();
                break;
        }

        return false;
    }

    @Override
    public void setRecordStatus() {
        mVoiceBnt.setBackgroundColor(getResources().getColor(R.color.grey));
    }

    @Override
    public void releaseRecordStatus() {
        mVoiceBnt.setBackgroundColor(getResources().getColor(R.color.white));
    }

    @Override
    public void updateMsgList(MsgBean msgBean) {
        msgBeanList.add(msgBean);
        mListAdapter.update(msgBeanList);
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}

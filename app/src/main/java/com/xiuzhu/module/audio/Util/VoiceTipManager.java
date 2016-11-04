package com.xiuzhu.module.audio.Util;

import android.content.Context;
import android.media.MediaPlayer;

import com.xiuzhu.module.audio.AudioMediaPlayer;


/**
 * Created by yezhihua on 15/5/4.
 * <p/>
 */
public class VoiceTipManager implements MediaPlayer.OnCompletionListener{

    private Context mContext;
    private AudioMediaPlayer mPlayer;
    public boolean isPlayFinish = true;

    public VoiceTipManager(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        mPlayer = new AudioMediaPlayer(mContext);
        mPlayer.getMediaPlayer().setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        isPlayFinish = true;
    }

    public void voiceMsgSendSuccess(){
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void voiceMsgSendFail(){
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void newVoiceMsg(){
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void  newStoryMsg(){
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void lowPowerNotice(){
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void connectWifiFail() {
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void bandWifiFail(){
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

    public void connectWifiSuccess() {
        isPlayFinish = false;
        //mPlayer.playUrl("");
    }

}

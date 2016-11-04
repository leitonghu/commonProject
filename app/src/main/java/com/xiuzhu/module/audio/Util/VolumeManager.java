package com.xiuzhu.module.audio.Util;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

/**
 * Created by yezhihua on 15/6/5.
 */
public class VolumeManager {

    private Context mContext;

    public VolumeManager(Context context) {
        mContext = context;
    }

    public void setVolume(int percent){

        //音量控制,初始化定义
        AudioManager mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        //最大音量
        int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        Log.e("setVolume","maxVolume="+maxVolume);
        int volume = maxVolume * percent/100;

        if (volume > maxVolume){
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
        }else {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
        }

    }

}

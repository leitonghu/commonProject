package com.xiuzhu.module.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;

import com.sd.core.utils.NLog;


import java.io.IOException;

/**
 * Created by yezhihua on 15/4/26.
 * <p/>
 * 播放声音文件的类，可以设置音量
 */
public class AudioMediaPlayer implements OnPreparedListener {

    private MediaPlayer mediaPlayer; // 媒体播放器
    private Context mContext;

    public AudioMediaPlayer(Context context) {

        mContext = context;

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
            mediaPlayer.setOnPreparedListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public AudioMediaPlayer(){
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
            mediaPlayer.setOnPreparedListener(this);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AudioMediaPlayer",e.toString());
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * 播放网络/或者本地声音文件
     *
     * @param url url地址或者本地声音文件路径
     * @return 0:成功， －1:失败
     */
    public int playUrl(String url) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url); // 设置数据源
            mediaPlayer.prepare(); // prepare自动播放
            return 0;
        } catch (IllegalArgumentException e) {
            mediaPlayer.reset();
            NLog.e(e.toString());
        } catch (SecurityException e) {
            mediaPlayer.reset();
            NLog.e(e.toString());
        } catch (IllegalStateException e) {
            mediaPlayer.reset();
            NLog.e(e.toString());
        } catch (IOException e) {
            mediaPlayer.reset();
            NLog.e(e.toString());
        } catch (Exception e) {
            mediaPlayer.reset();
            NLog.e(e.toString());
        }

        return -1;
    }

    /**
     * 播放
     */
    public void play() {
        try {
            mediaPlayer.start();
        } catch (Exception e) {

        }
    }

    public void play_2() {
        try {
            mediaPlayer.setOnPreparedListener(preparedListener);
            mediaPlayer.prepareAsync();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    OnPreparedListener preparedListener = new OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {

            mediaPlayer.start();
        }
    };

    /**
     * 暂停
     */
    public void pause() {
        try {
            mediaPlayer.pause();
        } catch (Exception e) {
            NLog.e(e.toString());
        }
    }

    /**
     * 停止
     */
    public void stop() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception e) {
                NLog.e(e.toString());
            }
            release();
        }
    }

    public void release(){
        if (mediaPlayer != null){
            try{
                mediaPlayer.release();
                mediaPlayer = null;
            }catch (Exception e){
                NLog.e(e.toString());
            }
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

}

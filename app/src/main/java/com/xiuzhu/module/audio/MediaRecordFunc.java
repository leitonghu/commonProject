package com.xiuzhu.module.audio;

import android.media.MediaRecorder;

import com.xiuzhu.module.audio.Util.RecordFileUtil;

import java.io.File;

/**
 * Created by yezhihua on 15/5/11.
 * <p/>
 * 最新的录音类
 */
public class MediaRecordFunc {

    private boolean isRecord = false;

    private MediaRecorder mMediaRecorder;

    private String mAudioFilePath;

    private MediaRecordFunc() {

    }

    private static MediaRecordFunc mInstance;

    public synchronized static MediaRecordFunc getInstance() {
        if (mInstance == null) {
            mInstance = new MediaRecordFunc();
        }
        return mInstance;
    }

    public int startRecord() {
        //判断是否有外部存储设备sdcard

        if (isRecord) {
            return -1;
        }

        if (mMediaRecorder != null) {
            try {
                mMediaRecorder.release();
            } catch (Exception e) {
            }
            mMediaRecorder = null;
        }

        if (mMediaRecorder == null) {
            createMediaRecord();
        }

        try {
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            isRecord = true;
        } catch (Exception e) {

            try {
                mMediaRecorder.reset();
                release();
                createMediaRecord();
                mMediaRecorder.prepare();
                mMediaRecorder.start();
                isRecord = true;
            } catch (Exception e1) {
                e1.printStackTrace();
                return -1;
            }
        }

        return 0;
    }

    public int stopRecord() {
        return close();
    }

    public String getAudioFilePath() {
        return mAudioFilePath;
    }

    private void createMediaRecord() {

        mAudioFilePath = RecordFileUtil.getAMRFilePath();

        mMediaRecorder = new MediaRecorder();

        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        //mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);

        //mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        File file = new File(mAudioFilePath);
        if (file.exists()) {
            file.delete();
        }

        mMediaRecorder.setOutputFile(mAudioFilePath);

    }

    public int close() {
        if (mMediaRecorder != null) {
            isRecord = false;
            try {
                mMediaRecorder.stop();
            } catch (Exception e) {
                release();
                return -1;
            }
            release();
        }

        return 0;
    }

    public void release() {
        if (mMediaRecorder != null) {
            isRecord = false;
            try {
                mMediaRecorder.release();
                mMediaRecorder = null;
            } catch (Exception e) {
            }
        }
    }

    public MediaRecorder getMediaRecorder() {
        return mMediaRecorder;
    }

}

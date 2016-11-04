package com.xiuzhu.module.audio;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

/**
 * Created by yezhihua on 15/11/6.
 */
public class AudioRecordFunc {

    private static int FREQUENCY = 16000;  //44100,16000
    private static int CHANNEL = AudioFormat.CHANNEL_IN_MONO;
    private static int ENCODING = AudioFormat.ENCODING_PCM_16BIT;
    private int bufferSize;

    private AudioRecord audioRecord;


    private static AudioRecordFunc mInstance;

    private AudioRecordFunc() {

    }

    public synchronized static AudioRecordFunc getInstance() {
        if (mInstance == null)
            mInstance = new AudioRecordFunc();
        return mInstance;
    }

    public AudioRecord getAudioRecord() {

        if (audioRecord == null) {
            createAudioRecord();
        }

        return audioRecord;
    }

    public void stopRecord() {
        close();
    }


    private void close() {
        if (audioRecord != null) {
            audioRecord.stop();
            audioRecord.release();//释放资源
            audioRecord = null;
        }
    }


    private void createAudioRecord() {
        bufferSize = AudioRecord.getMinBufferSize(FREQUENCY, CHANNEL, ENCODING);
        audioRecord = new AudioRecord(
                MediaRecorder.AudioSource.MIC, FREQUENCY,
                CHANNEL, ENCODING, bufferSize);
    }

    public int getBufferSize(){
        return bufferSize;
    }


}

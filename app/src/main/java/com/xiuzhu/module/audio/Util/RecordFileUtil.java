package com.xiuzhu.module.audio.Util;

import android.os.Environment;

import com.xiuzhu.MyApp;

import java.io.File;


/**
 * Created by yezhihua on 15/5/11.
 * <p/>
 * 录音文件类
 * 文件路径为：/mnt/sdcard/robot/record/
 */
public class RecordFileUtil {

    private static String BASE_PATH = MyApp.BASE_DIR;

    public static boolean isSdcardExit() {

        if ((Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))) {
            //SD卡正常挂载
            return true;
        } else {
            return false;
        }
    }

    private static void createBaseDir() {
        File dir = new File(BASE_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    private static String getAMRFileDir() {
        String audioAMRDir = "";
        if (isSdcardExit()) {
            try {
                createBaseDir();
                audioAMRDir = MyApp.RECORD_FILE_DIR;
                File dir = new File(audioAMRDir);
                if (!dir.exists()) {
                    dir.mkdir();
                }

            } catch (Exception e) {

            }
        }
        return audioAMRDir;
    }

    public static String getAMRFilePath() {

        String audioAMRPath = "";
        if (isSdcardExit()) {
            String dir = getAMRFileDir();
            Long tsLong = System.currentTimeMillis() / 1000;
            String dateTime = tsLong.toString();
            audioAMRPath = dir + dateTime + ".amr";
        }
        return audioAMRPath;
    }

    public static String getFirstAMRFilePath(){

        String audioAMRPath = "";
        if (isSdcardExit()) {
            String dir = getAMRFileDir();
            audioAMRPath = dir + "test" + ".amr";
        }
        return audioAMRPath;

    }

    public static long getFileSize(String path) {

        File file = new File(path);
        if (!file.exists()) {
            return -1;
        }

        return file.length();
    }

}

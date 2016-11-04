package com.xiuzhu.data.bean;

/**
 * Created by youdeyi on 2016/10/24.
 */

public class MsgBean {

    private String filename;
    private int length;

    public MsgBean(String filename, int length) {
        setFilename(filename);
        setLength(length);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "filename=" + filename +
                ",length=" + length;
    }
}

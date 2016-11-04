package com.xiuzhu.data.bean;

import java.io.Serializable;

public class UserBaseBean<T> implements Serializable {
    /**
     * 服务响应状态码（OK：成功；其他值：错误码）
     */
    protected int errcode;

    /**
     * 服务响应消息
     */
    protected String errmsg;

    /**
     * 响应内容
     */

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

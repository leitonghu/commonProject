/**
 * @项目名称:友德医网络医院(Android个人端)
 * 
 * @(#)BaseBean.java Created on 2015-8-1
 * Copyright © 2015 深圳友德医科技有限公司  版权所有
 */
package com.xiuzhu.data.bean;

import java.io.Serializable;


/**
 * 所有Bean的父类
 * @author leitonghu
 * @version 1.0
 *
 */
public class BaseBean<T> implements Serializable {
	/**
	 * 服务响应状态码（OK：成功；其他值：错误码）
	 */
	private int errcode;
	
	/**
	 * 服务响应消息
	 */
	private String errmsg;
	
	/**
	 * 响应内容
	 */
	private T data;
	
	
	public BaseBean() {
	}

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


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	
}

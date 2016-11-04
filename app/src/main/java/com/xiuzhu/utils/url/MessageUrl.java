package com.xiuzhu.utils.url;

public interface MessageUrl {
	/**
	 * 查看通知
	 */
//	String findnotice = "index.php/notice/get_list";
	
	/**
	 * 查看通知
	 */
	String findnotice = "index.php/notice/get_dt_list";

	/**
	 * 投诉管理
	 */
	String complainmanager = "index.php/complaint/get_list";
	
	
	/**
	 * 投诉详细
	 */
	String complainminxi = "index.php/complaint/get_detail";

	/**
	 * 图文问诊列表
	 */
	String consultlist = "index.php/consult_topic/get_consult_list";

}

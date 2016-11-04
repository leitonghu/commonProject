package com.xiuzhu.utils.url;

public interface UserUrl {

    /**
     * 登录
     */
    String login = "index.php/user/login";
    /**
     * 获取基本资料
     */
    String get_patient_info = "index.php/Patient/get_patient_info";

    /**
     * 获取验证码
     */
    String send_sms = "index.php/user/get_mobile_vcode";

    /**
     * 短信登录
     */
    String sms_login = "index.php/user/login_by_mobile_vcode";

    /**
     * 设置新密码
     */
    String set_new_password = "index.php/user/set_pwd_by_mobile";

    /**
     * 退出登录
     */
    String quit_sys = "index.php/user/logout";

    /**
     * 更改密码
     */
    String change_password = "index.php/user/change_password";

    /**
     * 检验检查申请单
     */
    String USER_JIANCHADAN = "index.php/consult/get_apply_detail";
    /**
     * 处方单详情
     */
    String USER_CHUFANG_INFO = "index.php?/appcenter/get_prescription_info";

    /**
     * 更改手机
     */
    String change_phone = "index.php/user/change_mobile";

    /**
     * 获取用户基本信息
     */
    String get_user_info = "index.php/user/get_user_info";
    /**
     * 获取已咨询用户列表
     */
    String get_has_consult_list = "index.php/consult/get_consult_list";
    /**
     * 获取已咨询用户详情
     */
    String get_has_consult_detail = "index.php/consult/get_consult_finished_detail";
    /**
     * 用户反馈
     */
    String send_suggestion = "index.php/setting/feedback";
    /**
     * 程序升级
     */
    String app_update = "index.php/setting/check_version";
    /**
     * 用户值班表
     */
    String user_schedul = "index.php/user/get_user_scheduling";
    /**
     * 获取处方列表
     */
    String get_recipe_list = "index.php/recipe/get_recipe_list";
    /**
     * 获取西药处方详情
     */
    String get_western_recipe = "index.php/recipe/get_western_recipe";
    /**
     * 删除西药处方详情
     */
    String del_western_recipe = "index.php/recipe/del_western_recipe";
    /**
     * 获取草药处方详情
     */
    String get_herbs_recipe = "index.php/recipe/get_herbs_recipe";
    /**
     * 删除中药处方
     */
    String del_herbs_recipe = "index.php/recipe/del_herbs_recipe";

    /**
     * 网络医院介绍
     */
    String hospital_introduction = "about/introduction.html";
    /**
     * 网络医院协议
     */
    String hospital_service = "/about/service.html";

    /**
     * 获取咨询用户列表
     */
    String get_get_record_list = "index.php/consult_topic/get_record_list";
    /**
     * 获取图文问诊-问诊记录详细
     */
    String get_record_detail = "index.php/consult_topic/get_record_detail";

    /**
     * 获取药品库药品列表
     */
    String get_drug_lib_list = "index.php/drug/mylist";

    /**
     * 获取药品库分类
     */
    String get_categories = "index.php/drug/get_categories";

    /**
     * 选中某个药品分类  展示该分类下的药品数据
     */
    String get_drug_by_category = "index.php/drug/get_by_category";

    /**
     * 在药品列表中，点击 【加为常用药】
     */
    String set_cus_drug = "index.php/drug/addone";

    /**
     * 自定义药品，申请加入药品库
     */
    String add_custom_lib = "index.php/drug/apply_add";

    /**
     * 药品详情
     */
    String add_drug_detail = "index.php/drug/get_details";
    /**
     * 注册医生
     */
    String register_doctor = "index.php/user/register_doctor";
    /**
     * 验证医生是否登录
    */
    String new_validate_mobile_vcode = "index.php/user/new_validate_mobile_vcode";
	/**
	 * 设置医生信息
	 */
	String set_user_info="index.php/user/edit_doctor";
	/**
	 * 获取使用指南列表
	 */
	String get_user_guide_list="index.php/guide/get_list";
	/**
	 * 药品详情
	 */
	String delete_lib_drug = "index.php/drug/remove";
    /**
     * 服务条款
     */
    String service = "about/service.html";
}

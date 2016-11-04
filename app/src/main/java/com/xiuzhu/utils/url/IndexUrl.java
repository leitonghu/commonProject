package com.xiuzhu.utils.url;

public class IndexUrl {

	/**
	 * 获取问诊记录
	 */
	public static String get_record_list = "index.php/consult/get_record_list";
	/**
	 * 获取简单诊疗意见书
	 */
	public static String get_submission_summary = "index.php/consult/get_record_detail";
	/**
	 * 获取诊疗意见书详细
	 */
	public static String get_submission_detail = "index.php/consult/get_record_detail_all";
	/**
	 * 首页广告图
	 */
	public static String get_index_ad = "index.php/setting/get_index_ad";
	/**
	 * 获取处方列表
	 */
	public static String get_recipe_list= "index.php/recipe/get_recipe_list";

	/**
	 * 查询图片
	 */
	public static String check_image= "index.php/consult/get_consult_images";
	/**
	 * 获取中药药品详情
	 */
	public static String get_herbs_detail= "index.php/herbs_drug/get_drug_detail";
	/**
	 * 获取西药药品详情
	 */
	public static String get_western_detail= "index.php/western_drug/get_drug_detail";
	/**
	 * 获取西药药品列表
	 */
//	public static String get_western_drug_list= "index.php/western_drug/get_drug_list";
	public static String get_western_drug_list= "index.php/drug/get_drug_list";
	/**
	 * 获取西药药品分类
	 */
	public static String get_western_drug_category= "index.php/western_drug/get_drug_category";
	/**
	 * 通过分类获取西药药品列表
	 */
	public static String get_western_by_category= "index.php/western_drug/get_drug_list_by_category";
	/**
	 * 获取诊断列表
	 */
	public static String get_diagnose_list= "index.php/medical_record/get_diagnose_list";
	/**
	 * 获取检验检查项目
	 */
	public static String get_check_item = "index.php/medical_record/get_check_item";
	/**
	 * 填写病历本数据
	 */
	public static String update_medical_record = "index.php/medical_record/fill";
	/**
	 * 填写药物过敏史
	 */
	public static String fill_drug_allergy_history = "index.php/medical_record/fill_drug_allergy_history";
	/**
	 * 更新未开处方原因
	 */
	public static String update_without_recipe = "index.php/consult/update_without_recipe";
	/**
	 * 获取中药药品列表
	 */
	public static String get_herbs_list = "index.php/herbs_drug/get_drug_list";
	/**
	 * 生成西药处方
	 */
	public static String create_western_recipe = "index.php/recipe/create_western_recipe";
	/**
	 * 生成中药处方
	 */
	public static String create_herbs_recipe = "index.php/recipe/create_herbs_recipe";
	/**
	 * 获取热门搜索诊断列表
	 */
	public static String get_hot_diagnose_list = "index.php/medical_record/get_hot_diagnose_list";
	/**
	 * 删除西药处方
	 */
	public static String del_western_recipe = "index.php/recipe/del_western_recipe";
	/**
	 * 删除中药处方
	 */
	public static String del_herbs_recipe = "index.php/recipe/del_herbs_recipe";
	/**
	 * comm_image_add/更新健康指导
	 */
	public static String doctor_guide = "index.php/medical_record/doctor_guide";
	/**
	 * 获取患者列表
	 */
	public static String get_patient_list ="index.php/Patient/get_patient_list";
	/**
	 *设置医生服务费
	 */
	public static String set_service_money="index.php/doctor_income/set_doctor_fee";
	/**
	 *获取医生服务费
	 */
	public static String get_service_money="index.php/doctor_income/get_doctor_fee";
	/**
	 * 获取医生职称
	 */
	public static String user_job_title = "index.php/appcenter/get_job_title";
	/**
	 * 获取医生职称
	 */
	public static String get_area_list = "index.php?/Appdoctor/get_area_list";
	/**
	 * .医院列表
	 */
	public static String get_hospital = "index.php?/appdoctor/get_hospital";

	/**
	 * 获取科室列表
	 */
	public static String get_department = "index.php/Hospital/get_department";
	/**
	 *
	 获取医生收入咨询列表
	 */
	public static String get_topic_history = "index.php/doctor_income/get_topic_history";
	/**
	 *
	 获取医生收入,余额接口
	 */
	public static String get_doctor_money = "index.php/doctor_income/get_doctor_money";

}

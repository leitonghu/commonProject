/**
 * @项目名称:友德医网络医院(Android医生端)
 * @(#)LoginBean.java Created on 2015-9-15
 * Copyright © 2015 深圳友德医科技有限公司  版权所有
 */
package com.xiuzhu.data.bean;

import java.io.Serializable;

/**
 * The class <code>Class UserInfoBean.java</code>
 *
 * @author Tonghu Lei
 * @version 1.0
 */
public class UserInfoBean implements Serializable {

    /**
     * errcode : 0
     * errmsg :
     * data : {"name":"朱宁湖","sex":"1","images":"/FileUpload/doctor_1.jpg","certificate_no":"001","telephone":"91890000001","expert":"擅长产科急危重症抢救，高危妊娠，头位难产等方面的处理熟练掌握,妊娠胆汁淤积综合症、妊娠期糖尿病、妊高征、宫颈机能不全性流产、早产、胎儿宫内发育迟缓、前置胎盘等疾病。","hos_name":"广东省第二人民医院","dept_name":"神经内科","profession":"主任医师","isallteam":"0","signimg":"","certificate_img":"","ismembership":"0","isprivate":"0","isrefer":"0","refer_price":"0.0","isverify":"0","crid_code":"","dept_code":"0","imgverify":"0","mobile":"","qrcode":"http://testwechat.youdeyi.com/wechat/html/download/qrcode.html?doctor_id%3D15101301650056070%26name%3Dbingo2015"}
     */

    private int errcode;
    private String errmsg;
    /**
     * name : 朱宁湖
     * sex : 1
     * images : /FileUpload/doctor_1.jpg
     * certificate_no : 001
     * telephone : 91890000001
     * expert : 擅长产科急危重症抢救，高危妊娠，头位难产等方面的处理熟练掌握,妊娠胆汁淤积综合症、妊娠期糖尿病、妊高征、宫颈机能不全性流产、早产、胎儿宫内发育迟缓、前置胎盘等疾病。
     * hos_name : 广东省第二人民医院
     * dept_name : 神经内科
     * profession : 主任医师
     * isallteam : 0
     * signimg :
     * certificate_img :
     * ismembership : 0
     * isprivate : 0
     * isrefer : 0
     * refer_price : 0.0
     * isverify : 0
     * crid_code :
     * dept_code : 0
     * imgverify : 0
     * mobile :
     * qrcode : http://testwechat.youdeyi.com/wechat/html/download/qrcode.html?doctor_id%3D15101301650056070%26name%3Dbingo2015
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {

        private String doctor_name;
        private String user_name;
        private String sex;
        private String images;
        private String certificate_no;
        private String telephone;
        private String expert;
        private String hos_name;
        private String hos_code;
        private String dept_name;
        private String profession;
        private String profession_code;
        private String isallteam;
        private String signimg;
        private String certificate_img;
        private String certificate_img_one;
        private String ismembership;
        private String isprivate;
        private String isrefer;
        private String refer_price;
        private String isverify;  //是否为测试医生
        private String ismanager;  //是否为管理人员
        private String istest;    //是否为调试医生
        private String crid_code;
        private String dept_code;
        private String imgverify;
        private String mobile;
        private String qrcode;
        private String parent_dept_code;
        private String open_area;


        @Override
        public String toString() {
            return "doctor_name=" + doctor_name +
                    ",user_name=" + user_name +
                    ",sex=" + sex +
                    ",images=" + images +
                    ",certificate_no=" + certificate_no +
                    ",telephone=" + telephone +
                    ",expert=" + expert +
                    ",hos_name=" + hos_name +
                    ",dept_name=" + dept_name +
                    ",profession=" + profession;
        }

        public String getCertificate_img_one() {
            return certificate_img_one;
        }

        public void setCertificate_img_one(String certificate_img_one) {
            this.certificate_img_one = certificate_img_one;
        }

        public String getOpen_area() {
            return open_area;
        }

        public void setOpen_area(String open_area) {
            this.open_area = open_area;
        }

        public String getParent_dept_code() {
            return parent_dept_code;
        }

        public void setParent_dept_code(String parent_dept_code) {
            this.parent_dept_code = parent_dept_code;
        }

        public String getDoctor_name() {
            return doctor_name;
        }

        public void setDoctor_name(String name) {
            this.doctor_name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getCertificate_no() {
            return certificate_no;
        }

        public void setCertificate_no(String certificate_no) {
            this.certificate_no = certificate_no;
        }

        public String getProfession_code() {
            return profession_code;
        }

        public void setProfession_code(String profession_code) {
            this.profession_code = profession_code;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getExpert() {
            return expert;
        }

        public void setExpert(String expert) {
            this.expert = expert;
        }

        public String getHos_name() {
            return hos_name;
        }

        public void setHos_name(String hos_name) {
            this.hos_name = hos_name;
        }

        public String getDept_name() {
            return dept_name;
        }

        public void setDept_name(String dept_name) {
            this.dept_name = dept_name;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getIsallteam() {
            return isallteam;
        }

        public void setIsallteam(String isallteam) {
            this.isallteam = isallteam;
        }

        public String getSignimg() {
            return signimg;
        }

        public void setSignimg(String signimg) {
            this.signimg = signimg;
        }

        public String getCertificate_img() {
            return certificate_img;
        }

        public void setCertificate_img(String certificate_img) {
            this.certificate_img = certificate_img;
        }

        public String getIsmembership() {
            return ismembership;
        }

        public void setIsmembership(String ismembership) {
            this.ismembership = ismembership;
        }

        public String getIsprivate() {
            return isprivate;
        }

        public void setIsprivate(String isprivate) {
            this.isprivate = isprivate;
        }

        public String getIsrefer() {
            return isrefer;
        }

        public void setIsrefer(String isrefer) {
            this.isrefer = isrefer;
        }

        public String getRefer_price() {
            return refer_price;
        }

        public void setRefer_price(String refer_price) {
            this.refer_price = refer_price;
        }

        public String getIsverify() {
            return isverify;
        }

        public void setIsverify(String isverify) {
            this.isverify = isverify;
        }

        public String getCrid_code() {
            return crid_code;
        }

        public void setCrid_code(String crid_code) {
            this.crid_code = crid_code;
        }

        public String getDept_code() {
            return dept_code;
        }

        public void setDept_code(String dept_code) {
            this.dept_code = dept_code;
        }

        public String getImgverify() {
            return imgverify;
        }

        public void setImgverify(String imgverify) {
            this.imgverify = imgverify;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getHos_code() {
            return hos_code;
        }

        public void setHos_code(String hos_code) {
            this.hos_code = hos_code;
        }

        public String getIsmanager() {
            return ismanager;
        }

        public void setIsmanager(String ismanager) {
            this.ismanager = ismanager;
        }

        public String getIstest() {
            return istest;
        }

        public void setIstest(String istest) {
            this.istest = istest;
        }
    }
}

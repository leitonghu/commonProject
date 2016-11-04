package com.xiuzhu.data.remote;

import com.xiuzhu.data.bean.BaseBean;
import com.xiuzhu.data.bean.LoginResultBean;
import com.xiuzhu.data.bean.UserInfoBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitApi {


    /**
     * 登录请求
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/user/login")
    Observable<LoginResultBean> login(@Field("username") String username,
                                      @Field("password") String password,
                                      @Field("type") String type);


    /**
     * 获取用户信息
     *
     * @param uid
     * @param access_token
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/user/get_user_info")
    Observable<UserInfoBean> getUserInfo(@Field("uid") String uid,
                                         @Field("access_token") String access_token);


    /**
     * 获取问诊记录
     *
     * @param uid
     * @param access_token
     * @param page         页码-可选
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/consult/get_record_list")
    Observable<UserInfoBean> getRecordList(@Field("uid") String uid,
                                           @Field("access_token") String access_token,
                                           @Field("page") int page);


    /**
     * 诊疗处理意见书-简单
     *
     * @param uid
     * @param access_token
     * @param record_id
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/consult/get_record_detail")
    Observable<UserInfoBean> getRecordDetail(@Field("uid") String uid,
                                             @Field("access_token") String access_token,
                                             @Field("record_id") String record_id);

    /**
     * 诊疗处理意见书-详细
     *
     * @param uid
     * @param access_token
     * @param record_id
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/consult/get_record_detail_all")
    Observable<UserInfoBean> getRecordDetailAll(@Field("uid") String uid,
                                                @Field("access_token") String access_token,
                                                @Field("record_id") String record_id);


    /**
     * 查看通知
     *
     * @param uid
     * @param access_token
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/notice/get_list")
    Observable<UserInfoBean> getNoticeList(@Field("uid") String uid,
                                           @Field("access_token") String access_token,
                                           @Field("page") int page);


    /**
     * 检查版本更新
     *
     * @param uid
     * @param access_token
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/setting/check_version")
    Observable<UserInfoBean> checkVersion(@Field("uid") String uid,
                                          @Field("access_token") String access_token);


    @FormUrlEncoded
    @POST("Scripts/WebService.asmx/postImage")
    Observable<BaseBean> uploadFile(@Field("imgText") String filePath,
                                    @Field("code") String code,
                                    @Field("type") String type);


}

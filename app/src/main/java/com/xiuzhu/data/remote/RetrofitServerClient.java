// (c)2016 Flipboard Inc, All Rights Reserved.

package com.xiuzhu.data.remote;

import com.sd.core.common.PreferencesManager;
import com.sd.core.utils.CommonUtils;
import com.xiuzhu.MyApp;
import com.xiuzhu.utils.ServiceURL;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServerClient {
    private static RetrofitApi retrofitLoginApi, retrofitApi;
    private static RetrofitApi retrofitUserInfoApi;
    private static RetrofitApi retrofitUploadFileApi;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static String sPlatform = "2";
    private static String sProductId = "30005";
    private static String COMM_PARAMS_PLATFORM = "platform";
    private static String COMM_PARAMS_VERSION = "version";
    private static String COMM_PARAMS_MAC = "mac";
    private static String COMM_PARAMS_PRODUCT_ID = "product_id";


    private static OkHttpClient getOkHttpClient() {

        /*添加固定公共参数，和签名和时间戳*/
        HasSignParamsInterceptor interceptor = new HasSignParamsInterceptor.Builder()
                .addParam(COMM_PARAMS_PLATFORM, PreferencesManager.getInstance(MyApp.mInstance).getString(COMM_PARAMS_PLATFORM, sPlatform))
                .addParam(COMM_PARAMS_VERSION, CommonUtils.getVersionName(MyApp.mInstance))
                .addParam(COMM_PARAMS_MAC, CommonUtils.getMac(MyApp.mInstance))
                .addParam(COMM_PARAMS_PRODUCT_ID, sProductId)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        return okHttpClient;
    }

    public static RetrofitApi getLoginApi() {

        if (retrofitLoginApi == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(ServiceURL.getServiceURL())
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            retrofitLoginApi = retrofit.create(RetrofitApi.class);
        }
        return retrofitLoginApi;
    }

    public static RetrofitApi getUserInfoApi() {

        if (retrofitUserInfoApi == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(ServiceURL.DOCTOR_SERVICEURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            retrofitUserInfoApi = retrofit.create(RetrofitApi.class);
        }
        return retrofitUserInfoApi;
    }

    public static RetrofitApi getUploadFileApi() {

        if (retrofitUploadFileApi == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(ServiceURL.Net_SERVICEURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            retrofitUploadFileApi = retrofit.create(RetrofitApi.class);
        }

        return retrofitUploadFileApi;

    }

    public static RetrofitApi getCommonApi() {

        if (retrofitApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(ServiceURL.SERVICEURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            retrofitApi = retrofit.create(RetrofitApi.class);
        }

        return retrofitApi;
    }


}

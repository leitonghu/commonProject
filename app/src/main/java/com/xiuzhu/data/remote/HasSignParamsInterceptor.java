package com.xiuzhu.data.remote;

import android.text.TextUtils;

import com.sd.core.utils.NLog;
import com.sd.core.utils.StringUtils;
import com.xiuzhu.utils.SignUtil;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 带签名参数，可添加参数的拦截器
 * <p>
 * Created by youdeyi on 2016/10/24.
 */

public class HasSignParamsInterceptor implements Interceptor {

    Map<String, String> queryParamsMap = new HashMap<>();
    Map<String, String> paramsMap = new HashMap<>();
    Map<String, String> headerParamsMap = new HashMap<>();
    List<String> headerLinesList = new ArrayList<>();
    List<String> paramsList = new ArrayList<>();

    String time = System.currentTimeMillis() / 1000 + "";


    private HasSignParamsInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        // process header params inject
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (headerParamsMap.size() > 0) {
            Iterator iterator = headerParamsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                headerBuilder.add((String) entry.getKey(), (String) entry.getValue());

            }
        }

        if (headerLinesList.size() > 0) {
            for (String line : headerLinesList) {
                headerBuilder.add(line);
            }
            requestBuilder.headers(headerBuilder.build());
        }
        // process header params end


        // process queryParams inject whatever it's GET or POST
        if (queryParamsMap.size() > 0) {
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap);
        }

        // process post body inject
        if (paramsMap.size() > 0) {
            if (canInjectIntoBody(request)) {
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                    formBodyBuilder.add((String) entry.getKey(), (String) entry.getValue());
                    //这里获取到的是公共固定的参数
                    paramsList.add(entry.getKey().toString() + "=" + entry.getValue().toString());
                }

                RequestBody formBody = formBodyBuilder.build();
                //这里获取到的是可变的参数，例如username,password这些
                String postBodyString = bodyToString(request.body());

                //============获取sign开始==================
                String paramsListString = postBodyString;
                String[] tmpString = StringUtils.getSplitStringArray(paramsListString, "&");
                for (int i = 0; i < tmpString.length; i++) {

                    if (tmpString[i].indexOf("username") != -1) {
                        tmpString[i] = URLDecoder.decode(tmpString[i], "UTF-8");
                        tmpString[i] = tmpString[i].replace("\n", "");
                    }

                    if (tmpString[i].indexOf("password") != -1) {
                        tmpString[i] = URLDecoder.decode(tmpString[i], "UTF-8");
                        tmpString[i] = tmpString[i].replace("\n", "");
                    }

                    paramsList.add(tmpString[i]);
                }

                paramsList.add("time=" + time);//添加时间戳
                String sign = getSign(paramsList);
                paramsList.clear(); //获取完清空列表
                //============获取sign完毕==================

                postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody) + "&time=" + time + ((sign.length() > 0) ? "&sign=" : "") + sign;
                //postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);
                NLog.e("http", "postParamsString----->" + postBodyString);
                requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));
            }
        }

        request = requestBuilder.build();

        try {
            NLog.e("Request", request.toString());
        } catch (Exception e) {
            NLog.e("Request", e.getMessage());
        }

        return chain.proceed(request);
    }

    private boolean canInjectIntoBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }
        if (!TextUtils.equals(mediaType.subtype(), "x-www-form-urlencoded")) {
            return false;
        }
        return true;
    }

    // func to inject params into url
    private Request injectParamsIntoUrl(HttpUrl.Builder httpUrlBuilder, Request.Builder requestBuilder, Map<String, String> paramsMap) {
        if (paramsMap.size() > 0) {
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                httpUrlBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder.build();
        }

        return null;
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static class Builder {

        HasSignParamsInterceptor interceptor;

        public Builder() {
            interceptor = new HasSignParamsInterceptor();
        }

        public HasSignParamsInterceptor.Builder addParam(String key, String value) {
            interceptor.paramsMap.put(key, value);
            return this;
        }

        public HasSignParamsInterceptor.Builder addParamsMap(Map<String, String> paramsMap) {
            interceptor.paramsMap.putAll(paramsMap);
            return this;
        }

        public HasSignParamsInterceptor.Builder addHeaderParam(String key, String value) {
            interceptor.headerParamsMap.put(key, value);
            return this;
        }

        public HasSignParamsInterceptor.Builder addHeaderParamsMap(Map<String, String> headerParamsMap) {
            interceptor.headerParamsMap.putAll(headerParamsMap);
            return this;
        }

        public HasSignParamsInterceptor.Builder addHeaderLine(String headerLine) {
            int index = headerLine.indexOf(":");
            if (index == -1) {
                throw new IllegalArgumentException("Unexpected header: " + headerLine);
            }
            interceptor.headerLinesList.add(headerLine);
            return this;
        }

        public HasSignParamsInterceptor.Builder addHeaderLinesList(List<String> headerLinesList) {
            for (String headerLine : headerLinesList) {
                int index = headerLine.indexOf(":");
                if (index == -1) {
                    throw new IllegalArgumentException("Unexpected header: " + headerLine);
                }
                interceptor.headerLinesList.add(headerLine);
            }
            return this;
        }

        public HasSignParamsInterceptor.Builder addQueryParam(String key, String value) {
            interceptor.queryParamsMap.put(key, value);
            return this;
        }

        public HasSignParamsInterceptor.Builder addQueryParamsMap(Map<String, String> queryParamsMap) {
            interceptor.queryParamsMap.putAll(queryParamsMap);
            return this;
        }


        public HasSignParamsInterceptor build() {
            return interceptor;
        }

    }

    private String getSign(List<String> list) {
        return SignUtil.getDoctorSign(list);
    }
}

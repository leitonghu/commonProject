package com.xiuzhu.utils;

import android.util.Log;

import com.sd.core.utils.MD5Util;
import com.sd.core.utils.encrypt.AES256Cipher;
import com.sd.core.utils.encrypt.AESConfig;

import java.util.Collections;
import java.util.List;


public class SignUtil {

    private static String sUserType = "1";


    /**
     * 不帶key值的签名
     *
     * @param list
     * @return
     */
    private static String getSignWithNoKey(List<String> list) {
        String sign = "";
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).trim());
            if (i != list.size() - 1) {
                sb.append('&');
            }
        }

        Log.e("sign", "sb.toString()=" + sb.toString());

        sign = MD5Util.genAppSign(sb.toString());

        Log.e("sign", "sign=" + sign);

        return sign;
    }

    /**
     * 带key值的签名
     *
     * @param list
     * @return
     */
    private static String getSign(List<String> list) {

        String sign = "";
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).trim());
            sb.append('&');
        }
        sb.append("key=");
        sb.append(SignKey.about_accout_key);

        Log.e("sign", "sb.toString()=" + sb.toString());

        sign = MD5Util.genAppSign(sb.toString());

        Log.e("sign", "sign=" + sign);

        return sign;
    }

    public static String getUsername(String username) {
        try {
            username = AES256Cipher.AES_Encode(username, AESConfig.key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return username;
    }

    public static String getPassword(String password) {
        try {
            password = AES256Cipher.AES_Encode(password, AESConfig.key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return password;
    }

    public static String getUserType() {
        return sUserType;
    }

    public static String getDoctorSign(List<String> list) {
        return getSign(list);
    }

}

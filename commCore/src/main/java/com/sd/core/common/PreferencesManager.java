package com.sd.core.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * SharePreferences工具类
 */
public class PreferencesManager {

    public static final String PREF_NAME = "share_preferences";
    private static PreferencesManager instance;
    private SharedPreferences mSharedPreferences;

    private PreferencesManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance(Context context) {

        if (instance == null) {
            instance = new PreferencesManager(context);
        }
        return instance;
    }

    /**
     * @param key
     * @param bool
     */
    public void saveBoolean(String key, boolean bool) {
        mSharedPreferences.edit().putBoolean(key, bool).commit();
    }

    /**
     * @param key
     * @return
     */
    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, Boolean value) {
        return mSharedPreferences.getBoolean(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public void saveString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * @param key
     * @return
     */
    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    /**
     * @param key
     * @param value
     */
    public void saveInt(String key, Integer value) {
        mSharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * @param key
     * @return
     */
    public int getInt(String key) {

        return mSharedPreferences.getInt(key, 0);

    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public int getInt(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /**
     * @param key
     * @param value
     */
    public void saveLong(String key, Long value) {
        mSharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * @param key
     * @return
     */
    public Long getLong(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public Long getLong(String key, Long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    /**
     * @param key
     * @param value
     */
    public void saveFloat(String key, Long value) {
        mSharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * @param key
     * @return
     */
    public Float getFloat(String key) {
        return mSharedPreferences.getFloat(key, 0);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public Float getFloat(String key, int defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    @SuppressLint("NewApi")
    public Set getStringSet(String key, Set set) {
        return mSharedPreferences.getStringSet(key, set);
    }

    /**
     * @param key
     * @param set
     */
    @SuppressLint("NewApi")
    public void saveStringSet(String key, Set set) {
        mSharedPreferences.edit().putStringSet(key, set);
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

}

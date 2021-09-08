package com.example.silvertouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.util.Date;

public class SavedInfo {

    //public static final String PREFERENCES_NAME = "rebuild_preference";

    private static final String DEFAULT_STRING = "";

    private static final int DEFAULT_INT = 0;

    private static final boolean DEFAULT_BOOLEAN = false;


    //private  static SharedPreferences getPreferences(Context context){
    //    return context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
    //}


    /*

    Key , Value type, Value information


UserName String 유저의 이름
Waterd int 물을 준 횟수(성장도)
TotalMissionCompleted int 미션3개 전부 클리어된 횟수(물뿌리개와 동일...?!)
TodayMissionCompleted int 오늘 몇개 클리어 했는지
WateringCan int 물뿌리개 개수
Today String 오늘 날짜
Mission1, Mission2, Mission3 int 미션별 리스트 인덱스
isM1Completed, isM2Completed, isM3Completed boolean true or false 미션별 성공 여부

     */


//  String 값 저장하고 불러오는 메소드
    public static void setString(Context context, String key, String value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value).apply();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String stringValue = sp.getString(key, DEFAULT_STRING);
        return stringValue;
    }

//  Int 값 저장하고 불러오는 메소드
    public static void setInt(Context context, String key, int value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value).apply();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        int intValue = sp.getInt(key, DEFAULT_INT);
        return intValue;
    }


//  Boolean 값 저장하고 불러오는 메소드
    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value).apply();
    }
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        boolean booleanValue = sp.getBoolean(key, DEFAULT_BOOLEAN);
        return booleanValue;
    }
}



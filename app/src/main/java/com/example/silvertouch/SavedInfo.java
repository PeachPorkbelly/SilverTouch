package com.example.silvertouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.util.Date;

public class SavedInfo {

    //public static final String PREFERENCES_NAME = "rebuild_preference";

    private static final String TODAY_DEFAULT_VALUE = "";

    private static final int MISSION_DEFAULT_VALUE = 0;

    private static final boolean M_STATE_DEFAULT_VALUE = false;

    private static final int How_Many_Missions_Completed = 0;

    private static final String USERNAME_DEFAULT_VALUE = "";



    //private  static SharedPreferences getPreferences(Context context){
    //    return context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
    //}


    /*
    사용자 이름 받는 함수
     */

    public static void setUserName(Context context, String name){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("UserName",name).apply();
    }

    /*
    미션 몇개 완료되었는지 저장하는 함수
     */
    public static void setCompNum(Context context,int num){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("MissionCompNum",num).apply();
    }

    /*
    물뿌리개 저장
    */
    public static void setWateringCan(Context context, int num){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("WateringCan",num).apply();
    }


    /*
    날짜 저장하는 함수
     */
    public static void setDate(Context context,String date){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("DATE",date).apply();
    }

    /*
    미션 번호 저장하는 함수
     */
    public static void setMission(Context context,int mission1, int mission2, int mission3){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("MISSION1",mission1).apply();
        editor.putInt("MISSION2",mission2).apply();
        editor.putInt("MISSION3",mission3).apply();
    }

    /*
    미션이 성공했는지 아닌지 저장하는 함수
     */
    public static void setMissionState(Context context,String key, boolean state){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key,state).apply();
        /*
        key값 M1_STATE, M2_STATE, M3_STATE
         */

    }

    /*
    사용자 이름 불러오는 함수
     */
    public static String getUserName(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String name = sp.getString("UserName",USERNAME_DEFAULT_VALUE);
        return name;
    }

    /*
    저장된 날짜가 며칠인지 불러오는 함수
     */
    public static String getDate(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String date = sp.getString("DATE",TODAY_DEFAULT_VALUE);
        return date;
    }

    /*
    저장된 미션을 불러오는 함수
     */
    public static int getMission(Context context,String key){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        int mission = sp.getInt(key,MISSION_DEFAULT_VALUE);
        return mission;
        /*
        key MISSION1, MISSION2, MISSION3
         */
    }

    /*
    미션 상태를 불러오는 함수
     */
    public static boolean getMState(Context context,String key){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean M_state=sp.getBoolean(key,M_STATE_DEFAULT_VALUE);
        return M_state;
        /*
        key M1_STATE M2_STATE, M3_STATE
         */
    }

    /*
    하루 미션 몇개 끝냈는지 불러오는 함수
     */
    public static int getCompNum(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        int compNum = sp.getInt("MissionCompNum",How_Many_Missions_Completed);
        return compNum;
    }


    /*
    미션 총 몇개 끝냈는지 불러오는 함수
     */
    public static int getWateringCan(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        int totalCompNum = sp.getInt("WateringCan",0);
        return totalCompNum;
    }



}

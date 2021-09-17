package com.example.silvertouch;

import java.util.ArrayList;

public class MissionList {

    //각 미션 첫번쨰 화면 클래스를 담을 리스트
    ArrayList<Class> missionList = new ArrayList<>();
    ArrayList<String> missionTitle = new ArrayList<>();

    //미션이 추가될 때 마다 여기에 add 시켜주세요(클래스 이름과 미션 타이틀)
    public MissionList(){
        missionList.add(mission.hangjeong.M0_00.class);
        missionTitle.add("주민등록초본(개인확인용) 1부를 발급해주세요!");
        missionList.add(mission.mission_1.class);
        missionTitle.add("1번 미션");
        missionList.add(mission.mission_2.class);
        missionTitle.add("2번 미션");
    }





}





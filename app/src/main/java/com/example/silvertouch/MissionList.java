package com.example.silvertouch;

import java.util.ArrayList;

public class MissionList {

    //미션 통합 리스트
    public ArrayList<Class> missionList = new ArrayList<>();

    //미션 행정 리스트랑 타이틀
    public ArrayList<Class> missionListHJ = new ArrayList<>();
    public ArrayList<String> missionTitleHJ = new ArrayList<>();

    public ArrayList<Class> missionListHB = new ArrayList<>();
    public ArrayList<String> missionTitleHB = new ArrayList<>();

    //미션이 추가될 때 마다 여기에 add 시켜주세요(클래스 이름과 미션 타이틀)
    public MissionList(){
        missionList.add(mission.hangjeong.M0_00.class);
        missionListHJ.add(mission.hangjeong.M0_00.class);
        missionTitleHJ.add("주민등록초본(개인확인용) 1부를 발급해주세요!");

        missionList.add(mission.mission_2.class);
        missionListHJ.add(mission.mission_2.class);
        missionTitleHJ.add("2번 미션");

        missionList.add(mission.burger1.M0_00.class);
        missionListHB.add(mission.burger1.M0_00.class);
        missionTitleHB.add("새우버거 세트 1개를 주문해보세요");
    }
}





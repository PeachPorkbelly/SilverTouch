package com.example.silvertouch;

import java.util.ArrayList;

public class MissionList {

    //미션 통합 리스트
    public ArrayList<Class> missionList = new ArrayList<>();

    //미션 행정 리스트랑 타이틀
    public ArrayList<Class> missionListHJ = new ArrayList<>();
    public ArrayList<String> missionTitleHJ = new ArrayList<>();

    //미션 버거 리스트랑 타이틀
    public ArrayList<Class> missionListBG = new ArrayList<>();
    public ArrayList<String> missionTitleBG = new ArrayList<>();

    //미션 카페 리스트랑 타이틀
    public ArrayList<Class> missionListCF = new ArrayList<>();
    public ArrayList<String> missionTitleCF = new ArrayList<>();

    //미션이 추가될 때 마다 여기에 add 시켜주세요(클래스 이름과 미션 타이틀)
    public MissionList(){
        missionList.add(mission.hangjeong.M0_00.class);
        missionListHJ.add(mission.hangjeong.M0_01.class);
        missionTitleHJ.add("주민등록초본(개인확인용) 1부를 발급해주세요!");

        missionList.add(mission.burger.M1_Map.class);
        missionListBG.add(mission.burger.M1_00.class);
        missionTitleBG.add("아이스크림 1개를 주문해보세요");

        missionList.add(mission.burger.M0_Map.class);
        missionListBG.add(mission.burger.M0_00.class);
        missionTitleBG.add("새우버거 세트 1개를 주문해보세요");

        missionList.add(mission.burger.M2_Map.class);
        missionListBG.add(mission.burger.M2_00.class);
        missionTitleBG.add("커피 1개를 주문해보세요");

        missionList.add(mission.cafe.M0_00.class);
        missionListCF.add(mission.cafe.M0_00.class);
        missionTitleCF.add("따뜻한 카페라떼 한 잔을 마시고 싶어요");

    }
}





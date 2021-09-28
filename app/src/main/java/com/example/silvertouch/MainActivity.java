package com.example.silvertouch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import inssa_test.InsiderTestStart;
import card_maker.card_main;
import select_mission.SelectMission_00;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    SavedInfo si = new SavedInfo();
    MissionList missionList;
    Random random = new Random();

    /*
    SharedPreference에 저장된 날짜가 담길 변수
     */
    String today;
    // 유저 이름 저장 변수
    String userName;
    //random mission 배열
    int[] selectMissionNum = new int[3];
    //SharedPreference에 저장될 랜덤 미션 번호들
    int Mission1, Mission2, Mission3;
    //SharedPreference에 저장될 미션이 끝났는지 아닌지 기록할 번호들
    boolean ifMission1_completed, ifMission2_completed, ifMission3_completed;
    //몇개의 미션이 completed 되었는지
    int howManyMissionsCompleted;

    /*
    화면에 보이는 버튼들 변수 선언
     */
    //미션 성공/비성공 버튼과 View 들
    ImageView m1_completed, m2_completed, m3_completed;
    ImageButton m1_uncompleted, m2_uncompleted, m3_uncompleted;
    //그래프에 관한 .. 변수들
    ImageView empty_graph, graph1, graph2, graph3;
    //초기화 버튼
    Button reset;
    //미션선택 해서 플레이하는 버튼
    Button selectMission;
    //인싸테스트 버튼
    ImageButton insider_Button;
    //카드 만들기 버튼//
    ImageButton btn_card;
    // 디지털 농장 버튼
    ImageButton digital_farm;
    // 김수아, 김광희 테스트용
    TextView testView, text, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 김수아 김광희 테스트용
        testView = (TextView) findViewById(R.id.khtextView3);
        text = (TextView)findViewById(R.id.text);
        text2 = (TextView)findViewById(R.id.textView2);



        //미션 성공 실패 이미지와 버튼들
        m1_completed = (ImageView)findViewById(R.id.main_mission1_completed);
        m2_completed = (ImageView)findViewById(R.id.main_mission2_completed);
        m3_completed = (ImageView)findViewById(R.id.main_mission3_completed);
        m1_uncompleted = (ImageButton)findViewById(R.id.main_mission1_uncompleted);
        m2_uncompleted = (ImageButton)findViewById(R.id.main_mission2_uncompleted);
        m3_uncompleted = (ImageButton)findViewById(R.id.main_mission3_uncompleted);

        empty_graph = (ImageView)findViewById(R.id.main_emptyGraph);
        graph1 = (ImageView)findViewById(R.id.main_graph1);
        graph2 = (ImageView)findViewById(R.id.main_graph2);
        graph3 = (ImageView)findViewById(R.id.main_graph3);
        reset = (Button)findViewById(R.id.reset);
        digital_farm = (ImageButton) findViewById(R.id.digital_farm);
        insider_Button = (ImageButton) findViewById(R.id.inssatest);
        btn_card = (ImageButton)findViewById(R.id.cardmaking);

        selectMission = (Button)findViewById(R.id.selectMission);

        /*
        userName이 없으면 userName 받는 ACtivity 실행
         */
        checkUserName();


        /*
        저장되어있는 날짜를 불러와서 today에 저장한다
        */
        today = si.getString(getApplicationContext(),"Today");
        /*
        저장된 today가 null이면(앱을 처음 실행) 오늘 날짜를 DATE라는 키의 value로 저장한다 + 랜덤 넘버 3개 저장(중복 없이)
        저장된 today가 오늘의 날짜와 다르면(하루가 지남) 오늘 날짜를 DATE라는 키의 value로 업데이트 한다 + 랜덤 넘버 3개 저장
         */

        if (today=="" || !today.equals(getToday())){
            si.setString(getApplicationContext(),"Today",getToday());

            for(int i=0; i<3; i++){
                selectMissionNum[i] = random.nextInt(3);
                for(int j=0; j<i; j++){
                    if(selectMissionNum[i]==selectMissionNum[j]){
                        i--;
                    }
                }
            }

            si.setInt(getApplicationContext(),"Mission1", selectMissionNum[0]);
            si.setInt(getApplicationContext(), "Mission2", selectMissionNum[1]);
            si.setInt(getApplicationContext(), "Mission3", selectMissionNum[2]);

            //원래는 else if로 날짜가 어제와 다를때 실행하던 코드인데 안그래도 될 것 같은데.... 일단 확인 필요
            si.setInt(getApplicationContext(), "TodayMissionCompleted",0); //완료 미션 개수 0개로 초기화
            si.setBoolean(getApplicationContext(),"isM1Completed",false); //미션 완료 상태 초기화
            si.setBoolean(getApplicationContext(),"isM2Completed",false);
            si.setBoolean(getApplicationContext(),"isM3Completed",false);


        }

        //랜덤 미션 번호 불러오기
        Mission1 = si.getInt(getApplicationContext(),"Mission1");
        Mission2 = si.getInt(getApplicationContext(),"Mission2");
        Mission3 = si.getInt(getApplicationContext(),"Mission3");

        //랜덤 미션 완료 여부 체크
        ifMission1_completed = si.getBoolean(getApplicationContext(),"isM1Completed");
        ifMission2_completed = si.getBoolean(getApplicationContext(),"isM2Completed");
        ifMission3_completed = si.getBoolean(getApplicationContext(),"isM3Completed");

        //오늘 미션 몇개 끝났는지 불러옴 , 그래프 용
        howManyMissionsCompleted = si.getInt(getApplicationContext(),"TodayMissionCompleted");

        /*
        테스트용 텍스트
         */
        text.setText("오늘날짜"+si.getString(getApplicationContext(),"Today"));
        text2.setText("미션넘버"+Mission1+Mission2+Mission3+"미션성공여부"+ifMission1_completed+ifMission2_completed+ifMission3_completed);



        //미션 1,2,3 버튼 보여주기
        if (ifMission1_completed==false) {
            m1_completed.setVisibility(View.INVISIBLE);
            graph1.setVisibility(View.INVISIBLE);
        }
        else{
            m1_uncompleted.setVisibility(View.INVISIBLE);
            m1_completed.setVisibility(View.VISIBLE);
        }

        if (ifMission2_completed==false) {
            m2_completed.setVisibility(View.INVISIBLE);
            graph2.setVisibility(View.INVISIBLE);
        }
        else{
            m2_uncompleted.setVisibility(View.INVISIBLE);
            m2_completed.setVisibility(View.VISIBLE);
        }

        if (ifMission3_completed==false) {
            m3_completed.setVisibility(View.INVISIBLE);
            graph3.setVisibility(View.INVISIBLE);
        }
        else{
            m3_uncompleted.setVisibility(View.INVISIBLE);
            m3_completed.setVisibility(View.VISIBLE);
        }

        //그래프 보이기 안보이기 정해줌
        if (howManyMissionsCompleted==0) {
            graph1.setVisibility(View.INVISIBLE);
            graph2.setVisibility(View.INVISIBLE);
            graph3.setVisibility(View.INVISIBLE);
        }
        if(howManyMissionsCompleted==1) {
            graph1.setVisibility(View.VISIBLE);
            graph2.setVisibility(View.INVISIBLE);
            graph3.setVisibility(View.INVISIBLE);
        }
        if(howManyMissionsCompleted==2) {
            graph1.setVisibility(View.INVISIBLE);
            graph2.setVisibility(View.VISIBLE);
            graph3.setVisibility(View.INVISIBLE);
        }
        if(howManyMissionsCompleted==3){
            graph1.setVisibility(View.INVISIBLE);
            graph2.setVisibility(View.INVISIBLE);
            graph3.setVisibility(View.VISIBLE);
        }


        //리셋버튼
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<3; i++){
                    selectMissionNum[i] = random.nextInt(3);
                    for(int j=0; j<i; j++){
                        if(selectMissionNum[i]==selectMissionNum[j]){
                            i--;
                        }
                    }
                }
                si.setInt(getApplicationContext(),"Mission1", selectMissionNum[0]);
                si.setInt(getApplicationContext(), "Mission2", selectMissionNum[1]);
                si.setInt(getApplicationContext(), "Mission3", selectMissionNum[2]);
                si.setInt(getApplicationContext(), "TodayMissionCompleted",0); //완료 미션 개수 0개로 초기화
                si.setBoolean(getApplicationContext(),"isM1Completed",false); //미션 완료 상태 초기화
                si.setBoolean(getApplicationContext(),"isM2Completed",false);
                si.setBoolean(getApplicationContext(),"isM3Completed",false);
            }
        });

        /*test*/
        digital_farm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),mission.hangjeong.vector_test.class);
                startActivity(intent);
            }
        });

        /*
        카드보내기 버튼
         */
        btn_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),card_maker.card_main.class);
                startActivity(intent);
            }
        });


        //미션 버튼 눌러서 미션 시작!!
        m1_uncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"mission1",Toast.LENGTH_SHORT).show();
                MissionStart(Mission1,1);
            }
        });

        m2_uncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MissionStart(Mission2,2);
            }
        });

        m3_uncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MissionStart(Mission3,3);
            }
        });


        // 인싸테스트 버튼 ClickListener
        insider_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), InsiderTestStart.class);
                startActivity(intent);
            }
        });

        //미션리스트중에서 선택해서 미션 플레이 하는 버튼
        selectMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SelectMission_00.class);
                startActivity(intent);
            }
        });

    }//onCreate

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    /*
            현재 날짜 불러오는 getToday 함수 생성
            연도와 월 일 만 나오게 함
             */
    public String getToday(){
        Date today = new Date();
        SimpleDateFormat stringToday = new SimpleDateFormat("yyyy-MM-dd");
        return stringToday.format(today);
    }

    /*
    public void MissionStart(int missionNum, int missionOrder){

        if (missionNum==0){
            intent = new Intent(getApplicationContext(),mission.hangjeong.M0_00.class);
            intent.putExtra("missionOrder",missionOrder);
            startActivity(intent);
        }else if(missionNum==1){
            intent = new Intent(getApplicationContext(),mission.mission_1.class);
            intent.putExtra("missionOrder",missionOrder);
            startActivity(intent);
        }else if(missionNum==2){
            intent = new Intent(getApplicationContext(),mission.mission_2.class);
            intent.putExtra("missionOrder",missionOrder);
            startActivity(intent);
        }

    }
     */

    //미션을 시작하는 함수, 랜덤으로 생성된 missionNum(리스트 인덱스로 쓰일 것)과 몇번쨰 미션인지(missionOrder)를
    //받아야 함
    public void MissionStart(int missionNum, int missionOrder){
        missionList = new MissionList();
        intent = new Intent(getApplicationContext(),missionList.missionList.get(missionNum));
        intent.putExtra("missionOrder",missionOrder);
        startActivity(intent);
    }

    // userName 받아오기
    public void checkUserName(){
        userName = si.getString(getApplicationContext(),"UserName");

        if (userName == ""){
            /* userName이 없으면 Activity 실행 */
            startActivityForResult(new Intent(getApplicationContext(), GetUserName.class), 0);
        }

        testView.setText(userName);// 테스트용
    }

    // userName 받아오기 ActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0){
            if(resultCode == RESULT_OK){
                checkUserName();
            }
        }
    }
}
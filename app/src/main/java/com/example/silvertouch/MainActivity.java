package com.example.silvertouch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.example.silvertouch.SavedInfo;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    SavedInfo si = new SavedInfo();
    Random random = new Random();

    //SharedPreference에 저장된 날짜가 담길 변수
    String today;

    //random mission 배열
    int[] selectMissionNum = new int[3];

    //SharedPreference에 저장될 랜덤 미션 번호들
    int Mission1;
    int Mission2;
    int Mission3;

    //SharedPreference에 저장될 미션이 끝났는지 아닌지 기록할 번호들
    boolean ifMission1_completed;
    boolean ifMission2_completed;
    boolean ifMission3_completed;


    //몇개의 미션이 completed 되었는지
    int howManyMissionsCompleted;

    /*

    화면에 보이는 버튼들 변수 선언

     */

    //미션 성공/비성공 버튼과 View 들
    ImageView m1_completed;
    ImageView m2_completed;
    ImageView m3_completed;

    ImageButton m1_uncompleted;
    ImageButton m2_uncompleted;
    ImageButton m3_uncompleted;

    //그래프에 관한 .. 변수들
    ImageView empty_graph;
    ImageView graph1;
    ImageView graph2;
    ImageView graph3;

    //초기화 버튼
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

        변수 아이디랑 연결

         */
        TextView text = (TextView)findViewById(R.id.text);
        TextView text2 = (TextView)findViewById(R.id.textView2);

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
        graph3 = (ImageView)findViewById(R.id.main_graph3);;

        reset = (Button)findViewById(R.id.reset);

        /*
        저장되어있는 날짜를 불러와서 today에 저장한다
        */
        today = si.getDate(getApplicationContext());


        /*
        저장된 today가 null이면(앱을 처음 실행) 오늘 날짜를 DATE라는 키의 value로 저장한다 + 랜덤 넘버 3개 저장(중복 없이)
        저장된 today가 오늘의 날짜와 다르면(하루가 지남) 오늘 날짜를 DATE라는 키의 value로 업데이트 한다 + 랜덤 넘버 3개 저장
         */
        if (today==""){
            si.setDate(getApplicationContext(),getToday());

            for(int i=0; i<3; i++){
                selectMissionNum[i] = random.nextInt(3);
                for(int j=0; j<i; j++){
                    if(selectMissionNum[i]==selectMissionNum[j]){
                        i--;
                    }
                }
            }

            si.setMission(getApplicationContext(),selectMissionNum[0],selectMissionNum[1],selectMissionNum[2]);

        }else if(!today.equals(getToday())){
            si.setDate(getApplicationContext(),getToday());

            for(int i=0; i<3; i++){
                selectMissionNum[i] = random.nextInt(3);
                for(int j=0; j<i; j++){
                    if(selectMissionNum[i]==selectMissionNum[j]){
                        i--;
                    }
                }
            }

            si.setMission(getApplicationContext(),selectMissionNum[0],selectMissionNum[1],selectMissionNum[2]);

            /*
            이쪽에서 랜덤 미션 완료 여부와 몇개의 미션이 끝났는지 초기화 시켜줘야함
             */

            si.setCompNum(getApplicationContext(),0); //완료 미션 개수 0개로 초기화
            si.setMissionState(getApplicationContext(),"MISSION1",false); //미션 완료 상태 초기화
            si.setMissionState(getApplicationContext(),"MISSION2",false);
            si.setMissionState(getApplicationContext(),"MISSION3",false);

        }

        //랜덤 미션 번호 불러오기
        Mission1 = si.getMission(getApplicationContext(),"MISSION1");
        Mission2 = si.getMission(getApplicationContext(),"MISSION2");
        Mission3 = si.getMission(getApplicationContext(),"MISSION3");

        //랜덤 미션 완료 여부 체크
        ifMission1_completed = si.getMState(getApplicationContext(),"M1_STATE");
        ifMission2_completed = si.getMState(getApplicationContext(),"M2_STATE");
        ifMission3_completed = si.getMState(getApplicationContext(),"M3_STATE");

        //오늘 미션 몇개 끝났는지 불러옴 , 그래프 용
        howManyMissionsCompleted = si.getCompNum(getApplicationContext());

        /*
        지워
         */
        text.setText("오늘날짜"+si.getDate(getApplicationContext()));
        text2.setText("미션넘버"+Mission1+Mission2+Mission3+"미션성공여부"+ifMission1_completed+ifMission2_completed+ifMission3_completed);


        /* 꽃피우기
        if (howManyMissionsCompleted==3){
            //미션 3번 깨면 1씩 올라가는 파일 저장해야됨
            if 그 번호가 1~5면
                실행할 코드
        }

         */


        //미션 1,2,3 버튼 보여주기
        if (ifMission1_completed==false) {
            m1_completed.setVisibility(View.INVISIBLE);
            graph1.setVisibility(View.INVISIBLE);
        }
        else{
            m1_uncompleted.setVisibility(View.INVISIBLE);
            m1_completed.setVisibility(View.VISIBLE);
            //howManyMissionsCompleted = howManyMissionsCompleted+1;
            //si.setCompNum(getApplicationContext(),howManyMissionsCompleted);
        }

        if (ifMission2_completed==false) {
            m2_completed.setVisibility(View.INVISIBLE);
            graph2.setVisibility(View.INVISIBLE);
        }
        else{
            m2_uncompleted.setVisibility(View.INVISIBLE);
            m2_completed.setVisibility(View.VISIBLE);
            //howManyMissionsCompleted = howManyMissionsCompleted+1;
            //si.setCompNum(getApplicationContext(),howManyMissionsCompleted);
        }

        if (ifMission3_completed==false) {
            m3_completed.setVisibility(View.INVISIBLE);
            graph3.setVisibility(View.INVISIBLE);
        }
        else{
            m3_uncompleted.setVisibility(View.INVISIBLE);
            m3_completed.setVisibility(View.VISIBLE);
            //howManyMissionsCompleted = howManyMissionsCompleted+1;
            //si.setCompNum(getApplicationContext(),howManyMissionsCompleted);
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
                si.setMission(getApplicationContext(),selectMissionNum[0],selectMissionNum[1],selectMissionNum[2]);
                si.setMissionState(getApplicationContext(),"M1_STATE",false);
                si.setMissionState(getApplicationContext(),"M2_STATE",false);
                si.setMissionState(getApplicationContext(),"M3_STATE",false);
                si.setCompNum(getApplicationContext(),0);
            }
        });



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
    }

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


    public void MissionStart(int missionNum, int missionOrder){

        if (missionNum==0){
            intent = new Intent(getApplicationContext(),mission_0.m0_00.class);
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

}
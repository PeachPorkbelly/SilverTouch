package mission.hangjeong;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import mission.MissionMethods;

import static mission.hangjeong.M0_00.M0;


public class M0_02 extends AppCompatActivity {

    MissionMethods missionMethods = new MissionMethods();
    ImageView m1, m2, m3; //미션 순서 나타내는 이미지들
    ImageView waiting_page; //서버에 접속중 기다리는 이미지
    ImageButton chobon, deungbon, exit, hint; //등본은 나중에 추가해야함
    ImageButton previous, home; //이전페이지와 처음페이지로 가는 버튼들
    Intent i;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mission_hangjeong_m0_02);

        /*
        변수들 아이디와 연결해주는 부분
         */
        m1 = (ImageView)findViewById(R.id.m0_02_mission_order_1);
        m2 = (ImageView)findViewById(R.id.m0_02_mission_order_2);
        m3 = (ImageView)findViewById(R.id.m0_02_mission_order_3);
        waiting_page = (ImageView)findViewById(R.id.m0_02_waiting);
        chobon = (ImageButton)findViewById(R.id.m0_02_chobon);
        exit = (ImageButton)findViewById(R.id.m0_02_exit);
        hint = (ImageButton)findViewById(R.id.m0_02_hint);
        previous = (ImageButton)findViewById(R.id.m0_02_previous);
        home = (ImageButton)findViewById(R.id.m0_02_home);

        /*
        몇번째 미션인지 알려줌
         */
        missionMethods.set_missionOrder(M0,m1,m2,m3);
        waiting_page.setVisibility(View.INVISIBLE);

        /*
        주민등록(초본)버튼
         */
        chobon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waiting_page.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        i = new Intent(getApplicationContext(), M0_03.class);
                        startActivity(i);
                    }
                },1000);
            }
        });


        /*
        힌트버튼, 나중에 다이얼로그 받아서 함수로 따로 빼두기
         */
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"힌트입니다",Toast.LENGTH_SHORT).show();
            }
        });

        /*
        전페이지와 처음페이지로 돌아감, 종료
         */
        missionMethods.goto_thisClass(previous,M0_01.class,this);
        missionMethods.goto_thisClass(home,M0_00.class,this);
        missionMethods.set_Exit(exit,this);



    }
}

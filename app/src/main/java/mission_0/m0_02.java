package mission_0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import static mission_0.m0_00.M0;


public class m0_02 extends AppCompatActivity {

    m0_01 m0_01 = new m0_01(); //set_missionOrder 불러오려고
    ImageView m1, m2, m3; //미션 순서 나타내는 이미지들
    ImageButton chobon, deungbon, exit, hint; //등본은 나중에 추가해야함
    Intent i;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0_02);

        /*
        변수들 아이디와 연결해주는 부분
         */
        m1 = (ImageView)findViewById(R.id.m0_02_mission_order_1);
        m2 = (ImageView)findViewById(R.id.m0_02_mission_order_2);
        m3 = (ImageView)findViewById(R.id.m0_02_mission_order_3);


        /*
        몇번째 미션인지 알려줌
         */
        m0_01.set_missionOrder(M0,m1,m2,m3);

        /*
        주민등록(초본)버튼
         */
        chobon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        /*
        종료버튼
         */
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
                startActivity(i);
            }
        });

        /*
        힌트버튼
         */
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"힌트입니다",Toast.LENGTH_SHORT).show();
            }
        });


    }
}

package mission.burger;

import static mission.burger.M0_Map.M0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

import mission.MissionMethods;

public class M2_06 extends AppCompatActivity {
    ImageButton pay, cancel,exit;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m206);


        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m2_06_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m2_06_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m2_06_mission_order_3);



        exit=(ImageButton) findViewById(R.id.bg2_x6);
        pay=(ImageButton) findViewById(R.id.pay);
        cancel=(ImageButton) findViewById(R.id.cancel);


        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);
        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.pay:
                        i=getIntent();
                        String data2=i.getStringExtra("data2");

                        if (data2.equals("1")){
                            i = new Intent(getApplicationContext(), M2_07.class);
                            startActivity(i);
                            overridePendingTransition(0, 0); //애니메이션 없애기
                            break;
                        }
                        if (data2.equals("2")){
                            i = new Intent(getApplicationContext(), M1_cash.class);
                            startActivity(i);
                            overridePendingTransition(0, 0); //애니메이션 없애기
                            break;
                        }
                        if (data2.equals("3")) {
                            i = new Intent(getApplicationContext(), M1_mobile.class);
                            startActivity(i);
                            overridePendingTransition(0, 0); //애니메이션 없애기
                            break;
                        }
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), M2_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        pay.setOnClickListener(cl);
        cancel.setOnClickListener(cl);

    }
    /*
뒤로가기 버튼 눌렀을 때
*/
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class); //합칠 때 수정필요
        startActivity(i);
        super.onBackPressed();
    }
}
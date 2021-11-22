package mission.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

import mission.MissionMethods;
import static mission.burger.M0_Map.M0;

public class M0_07 extends AppCompatActivity {

    ImageButton po, chi, che, oni, cok, spr, ok, can, cancel,exit;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m007);


        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m0_07_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m0_07_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m0_07_mission_order_3);



        exit=(ImageButton) findViewById(R.id.bg0_x7);
        po=(ImageButton) findViewById(R.id.potato);
        chi=(ImageButton) findViewById(R.id.chicken);
        che=(ImageButton) findViewById(R.id.cheesestick);
        oni=(ImageButton) findViewById(R.id.onion);
        cok=(ImageButton) findViewById(R.id.coke);
        spr=(ImageButton) findViewById(R.id.sprite);
        ok=(ImageButton) findViewById(R.id.ok);
        can=(ImageButton) findViewById(R.id.cancel2);
        cancel=(ImageButton)findViewById(R.id.cancel);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ok:
                        i = new Intent(getApplicationContext(), mission.burger.M0_08.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel2:
                        i = new Intent(getApplicationContext(), mission.burger.M0_06.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger.M0_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.potato:
                        po.setSelected(true);
                        che.setSelected(false);
                        chi.setSelected(false);
                        oni.setSelected(false);
                        break;
                    case R.id.chicken:
                        po.setSelected(false);
                        che.setSelected(false);
                        chi.setSelected(true);
                        oni.setSelected(false);
                        break;
                    case R.id.cheesestick:
                        po.setSelected(false);
                        che.setSelected(true);
                        chi.setSelected(false);
                        oni.setSelected(false);
                        break;
                    case R.id.onion:
                        po.setSelected(false);
                        che.setSelected(false);
                        chi.setSelected(false);
                        oni.setSelected(true);
                        break;
                    case R.id.coke:
                        cok.setSelected(true);
                        spr.setSelected(false);
                        break;
                    case R.id.sprite:
                        cok.setSelected(false);
                        spr.setSelected(true);
                        break;

                }
            }
        };
        ok.setOnClickListener(cl);
        can.setOnClickListener(cl);
        cancel.setOnClickListener(cl);
        po.setOnClickListener(cl);
        chi.setOnClickListener(cl);
        che.setOnClickListener(cl);
        oni.setOnClickListener(cl);
        cok.setOnClickListener(cl);
        spr.setOnClickListener(cl);
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
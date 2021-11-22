package mission.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

import mission.MissionMethods;
import static mission.burger.M0_Map.M0;

public class M1_04 extends AppCompatActivity {
    ImageButton rec, ham, dri, cancel, exit, ice;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m104);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m1_04_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m1_04_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m1_04_mission_order_3);

        exit=(ImageButton) findViewById(R.id.bg1_x4);
        rec=(ImageButton) findViewById(R.id.recomm);
        ham=(ImageButton) findViewById(R.id.hamburger);
        dri=(ImageButton) findViewById(R.id.drink);
        cancel=(ImageButton)findViewById(R.id.cancel);
        ice=(ImageButton)findViewById(R.id.icecream);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.recomm:
                        i = new Intent(getApplicationContext(), mission.burger.M1_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.hamburger:
                        i = new Intent(getApplicationContext(), mission.burger.M1_03.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.drink:
                        i = new Intent(getApplicationContext(), mission.burger.M1_05.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger.M1_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.icecream:
                        i=getIntent();
                        String data=i.getStringExtra("data");
                        i = new Intent(getApplicationContext(), mission.burger.M1_06.class);
                        i.putExtra("data",data);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        rec.setOnClickListener(cl);
        ham.setOnClickListener(cl);
        dri.setOnClickListener(cl);
        cancel.setOnClickListener(cl);
        ice.setOnClickListener(cl);
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
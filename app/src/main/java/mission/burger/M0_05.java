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

public class M0_05 extends AppCompatActivity {

    ImageButton rec, ham, des, cancel, exit;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m005);


        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m0_05_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m0_05_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m0_05_mission_order_3);



        exit=(ImageButton) findViewById(R.id.bg0_x5);
        rec=(ImageButton) findViewById(R.id.recomm);
        ham=(ImageButton) findViewById(R.id.hamburger);
        des=(ImageButton) findViewById(R.id.desert);
        cancel=(ImageButton)findViewById(R.id.cancel);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.recomm:
                        i = new Intent(getApplicationContext(), mission.burger.M0_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.hamburger:
                        i = new Intent(getApplicationContext(), mission.burger.M0_03.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.desert:
                        i = new Intent(getApplicationContext(), mission.burger.M0_04.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger.M0_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        rec.setOnClickListener(cl);
        ham.setOnClickListener(cl);
        des.setOnClickListener(cl);
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
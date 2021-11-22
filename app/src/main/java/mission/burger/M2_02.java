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


public class M2_02 extends AppCompatActivity {

    MissionMethods missionMethods = new MissionMethods();
    Intent i;
    ImageButton ham, des, dri, cancel, exit;
    View.OnClickListener cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m202);


        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m2_02_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m2_02_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m2_02_mission_order_3);



        exit=(ImageButton) findViewById(R.id.bg2_x2);
        ham=(ImageButton) findViewById(R.id.hamburger);
        des=(ImageButton) findViewById(R.id.desert);
        dri=(ImageButton) findViewById(R.id.drink);
        cancel=(ImageButton)findViewById(R.id.cancel);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);


        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.hamburger:
                        i=getIntent();
                        String data2=i.getStringExtra("data2");
                        i = new Intent(getApplicationContext(), M2_03.class);
                        i.putExtra("data2",data2);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.desert:
                        i=getIntent();
                        data2=i.getStringExtra("data2");
                        i = new Intent(getApplicationContext(), M2_04.class);
                        i.putExtra("data2",data2);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.drink:
                        i=getIntent();
                        data2=i.getStringExtra("data2");
                        i = new Intent(getApplicationContext(), M2_05.class);
                        i.putExtra("data2",data2);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), M2_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        ham.setOnClickListener(cl);
        des.setOnClickListener(cl);
        dri.setOnClickListener(cl);
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
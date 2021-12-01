package mission.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

import mission.MissionMethods;
import static mission.burger.M0_Map.M0;

public class M0_10 extends AppCompatActivity {
    ImageButton im,exit;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();
    SavedInfo si = new SavedInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m010);


        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m0_10_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m0_10_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m0_10_mission_order_3);



        exit=(ImageButton) findViewById(R.id.bg0_x10);
        im=(ImageButton)findViewById(R.id.imageButton);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);
        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageButton:
                        i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기

                        //미션 몇개 끝났는지 불러옴
                        int howManyMissionsCompleted = si.getInt(getApplicationContext(),"TodayMissionCompleted");
                        howManyMissionsCompleted = howManyMissionsCompleted+1;
                        si.setInt(getApplicationContext(),"TodayMissionCompleted",howManyMissionsCompleted);

                        //int missionOrder = getIntent().getIntExtra("missionOrder",0);
                        //Toast.makeText(getApplicationContext(),missionOrder+"dd",Toast.LENGTH_SHORT).show();
                        if (M0==1)
                            si.setBoolean(getApplicationContext(),"isM1Completed",true);
                        if(M0==2)
                            si.setBoolean(getApplicationContext(),"isM2Completed",true);
                        if(M0==3)
                            si.setBoolean(getApplicationContext(),"isM3Completed",true);
                        break;

                }
            }
        };
        im.setOnClickListener(cl);
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
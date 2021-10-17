package mission.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

import mission.MissionMethods;
import static mission.burger.M1_Map.M0;

public class M1_08 extends AppCompatActivity {
    ImageButton im,exit;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m108);


        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m1_08_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m1_08_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m1_08_mission_order_3);



        exit=(ImageButton) findViewById(R.id.bg1_x8);
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

                        // 미션 성공 횟수 추가
                        //미션 몇개 끝났는지 불러옴
                        SavedInfo si = new SavedInfo();
                        int howManyMissionsCompleted = si.getInt(getApplicationContext(),"TodayMissionCompleted");
                        howManyMissionsCompleted = howManyMissionsCompleted+1;
                        si.setInt(getApplicationContext(),"TodayMissionCompleted",howManyMissionsCompleted);

                        int missionOrder = M0;
                        Toast.makeText(getApplicationContext(),missionOrder+"dd",Toast.LENGTH_SHORT).show();
                        if (missionOrder==1)
                            si.setBoolean(getApplicationContext(),"isM1Completed",true);
                        if(missionOrder==2)
                            si.setBoolean(getApplicationContext(),"isM2Completed",true);
                        if(missionOrder==3)
                            si.setBoolean(getApplicationContext(),"isM3Completed",true);


//                        i = new Intent(getApplicationContext(), mission.burger.M1_00.class);
                        i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);

                        overridePendingTransition(0, 0); //애니메이션 없애기
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
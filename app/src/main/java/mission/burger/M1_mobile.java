package mission.burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;
import static mission.burger.M0_Map.M0;

public class M1_mobile extends AppCompatActivity {

    Button b;
    View.OnClickListener cl;
    Intent i;
    SavedInfo si = new SavedInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_mobile);

        b=(Button) findViewById(R.id.button2);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기

                        //미션 몇개 끝났는지 불러옴
                        int howManyMissionsCompleted = si.getInt(getApplicationContext(),"TodayMissionCompleted");
                        howManyMissionsCompleted = howManyMissionsCompleted+1;
                        si.setInt(getApplicationContext(),"TodayMissionCompleted",howManyMissionsCompleted);

                        int missionOrder = getIntent().getIntExtra("missionOrder",0);
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
        b.setOnClickListener(cl);
    }
}
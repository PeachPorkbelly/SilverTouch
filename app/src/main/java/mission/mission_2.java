package mission;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

public class mission_2 extends AppCompatActivity {


    SavedInfo si = new SavedInfo();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.missions_2);

        Button finish = (Button)findViewById(R.id.mission2);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //미션 몇개 끝났는지 불러옴
                int howManyMissionsCompleted = si.getInt(getApplicationContext(),"TodayMissionCompleted");
                howManyMissionsCompleted = howManyMissionsCompleted+1;
                si.setInt(getApplicationContext(),"TodayMissionCompleted",howManyMissionsCompleted);

                int missionOrder = getIntent().getIntExtra("missionOrder",0);

                if (missionOrder==1)
                    si.setBoolean(getApplicationContext(),"isM1Completed",true);
                if(missionOrder==2)
                    si.setBoolean(getApplicationContext(),"isM2Completed",true);
                if(missionOrder==3)
                    si.setBoolean(getApplicationContext(),"isM3Completed",true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
        startActivity(intent);
    }
}


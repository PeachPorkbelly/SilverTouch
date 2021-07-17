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

public class mission_1 extends AppCompatActivity {


    SavedInfo si = new SavedInfo();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.missions_1);

        Button finish = (Button)findViewById(R.id.mission1);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int howManyMissionsCompleted = si.getCompNum(getApplicationContext());
                howManyMissionsCompleted = howManyMissionsCompleted+1;
                si.setCompNum(getApplicationContext(),howManyMissionsCompleted);

                int missionOrder = getIntent().getIntExtra("missionOrder",0);

                Toast.makeText(getApplicationContext(),missionOrder+"dd",Toast.LENGTH_SHORT).show();

                if (missionOrder==1)
                    si.setMissionState(getApplicationContext(),"M1_STATE",true);
                if(missionOrder==2)
                    si.setMissionState(getApplicationContext(),"M2_STATE",true);
                if(missionOrder==3)
                    si.setMissionState(getApplicationContext(),"M3_STATE",true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
        startActivity(intent);
    }
}

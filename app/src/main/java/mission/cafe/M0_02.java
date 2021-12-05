package mission.cafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import static mission.cafe.M0_00.M0;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

import mission.MissionMethods;

public class M0_02 extends AppCompatActivity {

    ImageView m1, m2, m3;
    MissionMethods missionMethods = new MissionMethods();
    ImageButton exit, hint, card, bus, qr, cancle;
    View.OnClickListener cl;
    Intent intent;
    SavedInfo si = new SavedInfo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mcafe_02);

        /*
        미션 순서에 대한 정보를 담은 이미지 뷰
         */
        m1 = (ImageView)findViewById(R.id.mcafe_02_mo1);
        m2 = (ImageView)findViewById(R.id.mcafe_02_mo2);
        m3 = (ImageView)findViewById(R.id.mcafe_02_mo3);
        missionMethods.set_missionOrder(M0,m1,m2,m3);

        exit = (ImageButton) findViewById(R.id.mcafe_02_exit);
        hint = (ImageButton) findViewById(R.id.mcafe_02_hint);

        card = (ImageButton) findViewById(R.id.mcafe_02_card);
        bus = (ImageButton) findViewById(R.id.mcafe_02_public);
        qr = (ImageButton) findViewById(R.id.mcafe_02_qr);

        cancle = (ImageButton) findViewById(R.id.mcafe_02_cancle);


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageResource(R.drawable.mcafe_02_end);

                Toast toast = Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
                toast.setView(iv);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                 */



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

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }, 500); //딜레이 타임 조절


            }
        };

        card.setOnClickListener(cl);
        bus.setOnClickListener(cl);
        qr.setOnClickListener(cl);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), M0_01.class);
                startActivity(intent);
            }
        });

        //exit
        missionMethods.set_Exit(exit,this);




    }
}

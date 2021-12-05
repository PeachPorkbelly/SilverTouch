package mission.cinema;

import static mission.cinema.Theater_map.M0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

import mission.MissionMethods;

public class Theater_pay_select_2 extends AppCompatActivity {

    ImageView select_view1,select_view2,select_view3,select_view1_1,select_view2_2,select_view3_3;
    ImageButton exit,hint,cinema_pay_select_paybtn2,pay_select2_fr_btn;
    ImageButton btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24;
    Intent intent;
    MissionMethods missionMethods = new MissionMethods();
    Toast toast;
    View.OnClickListener cl;
    FrameLayout fr2;
    SavedInfo si = new SavedInfo();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_pay_select_2);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.pay_select_title2_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.pay_select_title2_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.pay_select_title2_3);

        select_view1 = (ImageView) findViewById(R.id.select_view1);
        select_view2 = (ImageView) findViewById(R.id.select_view2);
        select_view3 = (ImageView) findViewById(R.id.select_view3);
        select_view1_1 = (ImageView) findViewById(R.id.select_view1_1);
        select_view2_2 = (ImageView) findViewById(R.id.select_view2_2);
        select_view3_3 = (ImageView) findViewById(R.id.select_view3_3);

        fr2 = (FrameLayout)findViewById(R.id.pay_select2_frlayout);

        exit = (ImageButton)findViewById(R.id.pay_select2_exit);
        hint = (ImageButton)findViewById(R.id.pay_select2_hint);

        cinema_pay_select_paybtn2 =(ImageButton)findViewById(R.id.cinema_pay_select_paybtn2);
        pay_select2_fr_btn = (ImageButton)findViewById(R.id.pay_select2_fr_btn);

        btn13 = (ImageButton) findViewById(R.id.cinema_pay_select_btn13);
        btn14 = (ImageButton) findViewById(R.id.cinema_pay_select_btn14);
        btn15 = (ImageButton) findViewById(R.id.cinema_pay_select_btn15);
        btn16 = (ImageButton) findViewById(R.id.cinema_pay_select_btn16);
        btn17 = (ImageButton) findViewById(R.id.cinema_pay_select_btn17);
        btn18 = (ImageButton) findViewById(R.id.cinema_pay_select_btn18);
        btn19 = (ImageButton) findViewById(R.id.cinema_pay_select_btn19);
        btn20 = (ImageButton) findViewById(R.id.cinema_pay_select_btn20);
        btn21 = (ImageButton) findViewById(R.id.cinema_pay_select_btn21);
        btn22 = (ImageButton) findViewById(R.id.cinema_pay_select_btn22);
        btn23 = (ImageButton) findViewById(R.id.cinema_pay_select_btn23);
        btn24 = (ImageButton) findViewById(R.id.cinema_pay_select_btn24);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cinema_pay_select_paybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr2.setVisibility(FrameLayout.VISIBLE);
                select_view1.setVisibility(ImageView.INVISIBLE);
                select_view2.setVisibility(ImageView.INVISIBLE);
                select_view3.setVisibility(ImageView.INVISIBLE);
                select_view1_1.setVisibility(ImageView.VISIBLE);
                select_view2_2.setVisibility(ImageView.VISIBLE);
                select_view3_3.setVisibility(ImageView.VISIBLE);
            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"결제하기 버튼을 눌러주세요.",Toast.LENGTH_SHORT).show();
            }
        };

        pay_select2_fr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);

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

                startActivity(intent);
            }
        });


        btn13.setOnClickListener(cl);
        btn14.setOnClickListener(cl);
        btn15.setOnClickListener(cl);
        btn16.setOnClickListener(cl);
        btn17.setOnClickListener(cl);
        btn18.setOnClickListener(cl);
        btn19.setOnClickListener(cl);
        btn20.setOnClickListener(cl);
        btn21.setOnClickListener(cl);
        btn22.setOnClickListener(cl);
        btn23.setOnClickListener(cl);
        btn24.setOnClickListener(cl);

    }

}

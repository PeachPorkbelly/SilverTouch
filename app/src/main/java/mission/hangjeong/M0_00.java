package mission.hangjeong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import mission.MissionMethods;

public class M0_00 extends AppCompatActivity {

    public static int M0;
    ImageButton hangjeong,burger,theater,hospital,ktx;
    Intent intent;
    ImageButton exit;
    MissionMethods missionMethods = new MissionMethods();
    View.OnClickListener cl;
    Toast toast;

    /*
    주민등록 초본 떼는 프로그램
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mission_hangjeong_m0_00);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.missionOrder_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.missionOrder_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.missionOrder_3);


        hangjeong = (ImageButton)findViewById(R.id.m0_00_hangjeong);
        burger = (ImageButton)findViewById(R.id.m0_00_burger);
        theater = (ImageButton)findViewById(R.id.m0_00_theater);
        hospital = (ImageButton)findViewById(R.id.m0_00_hospital);
        ktx = (ImageButton)findViewById(R.id.m0_00_ktx);

        exit = (ImageButton)findViewById(R.id.m0_00_exit);
        int missionOrder = getIntent().getIntExtra("missionOrder",0);

        M0 = missionOrder;

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        hangjeong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), M0_01.class);
                startActivity(intent);
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"주민등록 초본은 행정복지센터에서 발급받으실 수 있습니다",Toast.LENGTH_SHORT).show();
            }
        };

        burger.setOnClickListener(cl);
        theater.setOnClickListener(cl);
        ktx.setOnClickListener(cl);
        hospital.setOnClickListener(cl);




    }
}

package mission.burger;

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

public class M1_Map extends AppCompatActivity {

    public static int M0;
    ImageButton hangjeong,burger,theater,hospital,ktx;
    Intent intent;
    ImageButton exit;
    MissionMethods missionMethods = new MissionMethods();
    View.OnClickListener cl;
    Toast toast;

    /*
    아이스크림 하나 시키는 미션 시작
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_m1_map);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m1_map_mo1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m1_map_mo2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m1_map_mo3);


        hangjeong = (ImageButton)findViewById(R.id.bg_m1_hangjeong);
        burger = (ImageButton)findViewById(R.id.bg_m1_burger);
        theater = (ImageButton)findViewById(R.id.bg_m1_theater);
        hospital = (ImageButton)findViewById(R.id.bg_m1_hospital);
        ktx = (ImageButton)findViewById(R.id.bg_m1_ktx);

        exit = (ImageButton)findViewById(R.id.bg_map_x0_exit);
        int missionOrder = getIntent().getIntExtra("missionOrder",0);

        M0 = missionOrder;

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), M1_00.class);
                startActivity(intent);
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"주민등록 초본은 행정복지센터에서 발급받으실 수 있습니다",Toast.LENGTH_SHORT).show();
            }
        };

        hangjeong.setOnClickListener(cl);
        theater.setOnClickListener(cl);
        ktx.setOnClickListener(cl);
        hospital.setOnClickListener(cl);




    }
}

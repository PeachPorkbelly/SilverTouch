package mission.cafe;

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
    ImageButton hangjeong,burger,theater,hospital,cafe;
    Intent intent;
    ImageButton exit;
    MissionMethods missionMethods = new MissionMethods();
    View.OnClickListener cl;
    Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m_cafe_map);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.m_cafe_map_mo1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.m_cafe_map_mo2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.m_cafe_map_mo3);


        hangjeong = (ImageButton)findViewById(R.id.cafe_m0_hangjeong);
        burger = (ImageButton)findViewById(R.id.cafe_m0_burger);
        theater = (ImageButton)findViewById(R.id.cafe_m0_theater);
        hospital = (ImageButton)findViewById(R.id.cafe_m0_hospital);
        cafe = (ImageButton)findViewById(R.id.cafe_m0_ktx);

        exit = (ImageButton)findViewById(R.id.cafe_m0_exit);

        int missionOrder = getIntent().getIntExtra("missionOrder",0);

        M0 = missionOrder;

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), M0_01.class);
                startActivity(intent);
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"카페라떼는 카페에서 시킬 수 있습니다.",Toast.LENGTH_SHORT).show();
            }
        };

        burger.setOnClickListener(cl);
        theater.setOnClickListener(cl);
        hangjeong.setOnClickListener(cl);
        hospital.setOnClickListener(cl);


    }
}

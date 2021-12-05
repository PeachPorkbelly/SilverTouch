package mission.cinema;

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

public class Theater_map extends AppCompatActivity {
    public static int M0;
    ImageButton hangjeong,burger,theater,hospital,ktx;
    Intent intent;
    ImageButton exit;
    MissionMethods missionMethods = new MissionMethods();
    View.OnClickListener cl;
    Toast toast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.theater_map);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.cm_mtitle_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.cm_mtitle_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.cm_mtitle_3);

        hangjeong = (ImageButton)findViewById(R.id.cinema_map_hangjeong);
        burger = (ImageButton)findViewById(R.id.cinema_map_burger);
        theater = (ImageButton)findViewById(R.id.cinema_map_theater);
        hospital = (ImageButton)findViewById(R.id.cinema_map_hospital);
        ktx = (ImageButton)findViewById(R.id.cinema_map_ktx);

        exit = (ImageButton)findViewById(R.id.cinema_map_exit);
        int missionOrder = getIntent().getIntExtra("missionOrder",0);

        M0 = missionOrder;

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        theater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_main.class);
                startActivity(intent);
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"예매는 영화관에서 가능합니다.",Toast.LENGTH_SHORT).show();
            }
        };

        hangjeong.setOnClickListener(cl);
        burger.setOnClickListener(cl);
        ktx.setOnClickListener(cl);
        hospital.setOnClickListener(cl);




    }
}

package select_mission;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

public class SelectMission_00 extends AppCompatActivity {

    //이미지 버튼들
    ImageButton hangjeong, theater, burger, hospital, ktx, exit, cafe;
    Intent intent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_mission_00);

        hangjeong = (ImageButton)findViewById(R.id.select_mission_hangjeong);
        theater = (ImageButton)findViewById(R.id.select_mission_theater);
        burger = (ImageButton)findViewById(R.id.select_mission_burger);
        hospital = (ImageButton)findViewById(R.id.select_mission_hospital);
        cafe = (ImageButton)findViewById(R.id.select_mission_cafe);
        exit = (ImageButton)findViewById(R.id.select_mission_00_exit);


        //인텐트로 넘길 때 어떤걸 선택했는지 갖고 넘기자!!
        hangjeong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),SelectMission_main.class);
                intent.putExtra("selectedPlace","hangjeong");
                startActivity(intent);

            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),SelectMission_main.class);
                intent.putExtra("selectedPlace","burger");
                startActivity(intent);
            }
        });

        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),SelectMission_main.class);
                intent.putExtra("selectedPlace","cafe");
                startActivity(intent);
            }
        });



        //닫기
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

package school;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import select_mission.SelectMission_main;

public class SchoolDesk extends AppCompatActivity {

    ImageButton kioskeng, iteng, dailyeng, exit;
    Intent intent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.school_desk);

        //변수들을 버튼과 연결합니다
        kioskeng = (ImageButton)findViewById(R.id.school_kioskeng);
        iteng = (ImageButton)findViewById(R.id.school_iteng);
        dailyeng = (ImageButton)findViewById(R.id.school_dailyeng);
        exit = (ImageButton)findViewById(R.id.school_desk_exit);


        //버튼을 누르면 실행할 일들
        kioskeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SchoolMain.class);
                intent.putExtra("selectedBook","kiosk");
                startActivity(intent);
            }
        });

        iteng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SchoolMain.class);
                intent.putExtra("selectedBook","it");
                startActivity(intent);
            }
        });

        dailyeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SchoolMain.class);
                intent.putExtra("selectedBook","daily");
                startActivity(intent);
            }
        });

        //종료 누르면 메인화면으로
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), com.example.silvertouch.MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

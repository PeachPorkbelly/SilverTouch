package mission.cinema;

import static mission.cinema.Theater_map.M0;

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

public class Theater_main extends AppCompatActivity {

    ImageButton cm_ticketbuy, cm_time,cm_ticket,exit;
    Intent intent;
    MissionMethods missionMethods = new MissionMethods();
    View.OnClickListener cl;
    Toast toast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.theater_main);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.cm_main_title_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.cm_main_title_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.cm_main_title_3);

        exit = (ImageButton)findViewById(R.id.cm_main_exit);
        cm_ticketbuy = (ImageButton)findViewById(R.id.cm_ticketbuy);
        cm_ticket = (ImageButton)findViewById(R.id.cm_ticket);
        cm_time = (ImageButton)findViewById(R.id.cm_time);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cm_ticketbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_tickebuy.class);
                startActivity(intent);
            }
        });


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"준비중 입니다.", Toast.LENGTH_SHORT).show();
            }
        };
        cm_ticket.setOnClickListener(cl);
        cm_time.setOnClickListener(cl);
    }
}

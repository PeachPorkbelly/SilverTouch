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

import com.example.silvertouch.R;

import mission.MissionMethods;

public class Theater_tickebuy extends AppCompatActivity {

    ImageButton cm_btn_1,cm_btn_2,cm_btn_3,cm_btn_4,cm_btn_5,exit,hint,cinema_seat_select;
    ImageButton a_btn_0,a_btn_00,a_btn_1,a_btn_01,a_btn_2,a_btn_02,b_btn_0,b_btn_00,b_btn_1,b_btn_01,b_btn_2,b_btn_02,c_btn_0,c_btn_00,c_btn_1,c_btn_01,c_btn_2,c_btn_02,d_btn_0,d_btn_00,d_btn_1,d_btn_01,d_btn_2,d_btn_02;
    Intent intent;
    MissionMethods missionMethods = new MissionMethods();
    Toast toast;
    View.OnClickListener cl;
    FrameLayout buy_view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_ticketbuy);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.cm_buy_title_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.cm_buy_title_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.cm_buy_title_3);

        buy_view = (FrameLayout)findViewById(R.id.viewbuy);

        exit = (ImageButton)findViewById(R.id.cinema_buy_exit);
        hint = (ImageButton)findViewById(R.id.cinema_buy_hint);

        cinema_seat_select = (ImageButton)findViewById(R.id.cinema_seat_select);
        cm_btn_1 = (ImageButton)findViewById(R.id.cm_btn_1);
        cm_btn_2 = (ImageButton)findViewById(R.id.cm_btn_2);
        cm_btn_3 = (ImageButton)findViewById(R.id.cm_btn_3);
        cm_btn_4 = (ImageButton)findViewById(R.id.cm_btn_4);
        cm_btn_5 = (ImageButton)findViewById(R.id.cm_btn_5);

        a_btn_0 = (ImageButton)findViewById(R.id.a_btn_0);
        a_btn_00 = (ImageButton)findViewById(R.id.a_btn_00);
        a_btn_1 = (ImageButton)findViewById(R.id.a_btn_1);
        a_btn_01 = (ImageButton)findViewById(R.id.a_btn_01);
        a_btn_2 = (ImageButton)findViewById(R.id.a_btn_2);
        a_btn_02 = (ImageButton)findViewById(R.id.a_btn_02);

        b_btn_0 = (ImageButton)findViewById(R.id.b_btn_0);
        b_btn_00 = (ImageButton)findViewById(R.id.b_btn_00);
        b_btn_1 = (ImageButton)findViewById(R.id.b_btn_1);
        b_btn_01 = (ImageButton)findViewById(R.id.b_btn_01);
        b_btn_2 = (ImageButton)findViewById(R.id.b_btn_2);
        b_btn_02 = (ImageButton)findViewById(R.id.b_btn_02);

        c_btn_0 = (ImageButton)findViewById(R.id.c_btn_0);
        c_btn_00 = (ImageButton)findViewById(R.id.c_btn_00);
        c_btn_1 = (ImageButton)findViewById(R.id.c_btn_1);
        c_btn_01 = (ImageButton)findViewById(R.id.c_btn_01);
        c_btn_2 = (ImageButton)findViewById(R.id.c_btn_2);
        c_btn_02 = (ImageButton)findViewById(R.id.c_btn_02);

        d_btn_0 = (ImageButton)findViewById(R.id.d_btn_0);
        d_btn_00 = (ImageButton)findViewById(R.id.d_btn_00);
        d_btn_1 = (ImageButton)findViewById(R.id.d_btn_1);
        d_btn_01 = (ImageButton)findViewById(R.id.d_btn_01);
        d_btn_2 = (ImageButton)findViewById(R.id.d_btn_2);
        d_btn_02 = (ImageButton)findViewById(R.id.d_btn_02);



        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"토끼의 여행을 선택해 주세요.",Toast.LENGTH_SHORT).show();
            }
        };

        cm_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy_view.setVisibility(FrameLayout.VISIBLE);
            }
        });

        a_btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a_btn_00.setVisibility(ImageButton.VISIBLE);
                a_btn_01.setVisibility(ImageButton.INVISIBLE);
                a_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        a_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a_btn_00.setVisibility(ImageButton.INVISIBLE);
                a_btn_01.setVisibility(ImageButton.VISIBLE);
                a_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        a_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a_btn_00.setVisibility(ImageButton.INVISIBLE);
                a_btn_01.setVisibility(ImageButton.INVISIBLE);
                a_btn_02.setVisibility(ImageButton.VISIBLE);
            }
        });

        b_btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_btn_00.setVisibility(ImageButton.VISIBLE);
                b_btn_01.setVisibility(ImageButton.INVISIBLE);
                b_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        b_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a_btn_00.setVisibility(ImageButton.INVISIBLE);
                a_btn_01.setVisibility(ImageButton.VISIBLE);
                a_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        b_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_btn_00.setVisibility(ImageButton.INVISIBLE);
                b_btn_01.setVisibility(ImageButton.INVISIBLE);
                b_btn_02.setVisibility(ImageButton.VISIBLE);
            }
        });

        c_btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c_btn_00.setVisibility(ImageButton.VISIBLE);
                c_btn_01.setVisibility(ImageButton.INVISIBLE);
                c_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        c_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c_btn_00.setVisibility(ImageButton.INVISIBLE);
                c_btn_01.setVisibility(ImageButton.VISIBLE);
                c_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        c_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c_btn_00.setVisibility(ImageButton.INVISIBLE);
                c_btn_01.setVisibility(ImageButton.INVISIBLE);
                c_btn_02.setVisibility(ImageButton.VISIBLE);
            }
        });

        d_btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_btn_00.setVisibility(ImageButton.VISIBLE);
                d_btn_01.setVisibility(ImageButton.INVISIBLE);
                d_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        d_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_btn_00.setVisibility(ImageButton.INVISIBLE);
                d_btn_01.setVisibility(ImageButton.VISIBLE);
                d_btn_02.setVisibility(ImageButton.INVISIBLE);
            }
        });

        d_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_btn_00.setVisibility(ImageButton.INVISIBLE);
                d_btn_01.setVisibility(ImageButton.INVISIBLE);
                d_btn_02.setVisibility(ImageButton.VISIBLE);
            }
        });

        cinema_seat_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_select.class);
                startActivity(intent);
            }
        });





        cm_btn_1.setOnClickListener(cl);
        cm_btn_2.setOnClickListener(cl);
        cm_btn_3.setOnClickListener(cl);
        cm_btn_5.setOnClickListener(cl);

    }

}

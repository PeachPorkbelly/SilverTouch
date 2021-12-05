package mission.cafe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import static mission.cafe.M0_00.M0;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silvertouch.R;

import mission.MissionMethods;

public class M0_01 extends AppCompatActivity {

    ImageButton exit, hint;
    ImageButton d1,d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15;
    ImageButton pay, cancle;
    TextView menu, price;
    ImageView m1, m2, m3;
    MissionMethods missionMethods = new MissionMethods();
    View.OnClickListener cl;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mcafe_01);


        exit = (ImageButton) findViewById(R.id.mcafe_exit);
        hint = (ImageButton) findViewById(R.id.mcafe_hint);

        d1 = (ImageButton) findViewById(R.id.kioskcafe1);
        d2 = (ImageButton) findViewById(R.id.kioskcafe2);
        d3 = (ImageButton) findViewById(R.id.kioskcafe3);
        d4 = (ImageButton) findViewById(R.id.kioskcafe4);
        d5 = (ImageButton) findViewById(R.id.kioskcafe5);
        d6 = (ImageButton) findViewById(R.id.kioskcafe6);
        d7 = (ImageButton) findViewById(R.id.kioskcafe7);
        d8 = (ImageButton) findViewById(R.id.kioskcafe8);
        d9 = (ImageButton) findViewById(R.id.kioskcafe9);
        d10 = (ImageButton) findViewById(R.id.kioskcafe10);
        d11 = (ImageButton) findViewById(R.id.kioskcafe11);
        d12 = (ImageButton) findViewById(R.id.kioskcafe12);
        d13 = (ImageButton) findViewById(R.id.kioskcafe13);
        d14 = (ImageButton) findViewById(R.id.kioskcafe14);
        d15 = (ImageButton) findViewById(R.id.kioskcafe15);

        pay = (ImageButton) findViewById(R.id.m_cafe_pay);
        cancle = (ImageButton) findViewById(R.id.m_cafe_cancle);

        menu = (TextView) findViewById(R.id.mcafe_selectedDrink);
        price = (TextView) findViewById(R.id.mcafe_price);


        /*
        미션 순서에 대한 정보를 담은 이미지 뷰
         */
        m1 = (ImageView)findViewById(R.id.mcafe_mo1);
        m2 = (ImageView)findViewById(R.id.mcafe_mo2);
        m3 = (ImageView)findViewById(R.id.mcafe_mo3);
        missionMethods.set_missionOrder(mission.cafe.M0_00.M0,m1,m2,m3);


        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.setText("HOT 카페라떼");
                price.setText("1900");
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.setText("");
                price.setText("");
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), M0_02.class);
                startActivity(intent);

            }
        });

        /*
        버튼 누르면 할 일들들
         */
        //exit
        missionMethods.set_Exit(exit,this);

        cl = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageResource(R.drawable.mcafe_m0_help);

                Toast toast = Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
                toast.setView(iv);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        };

        d1.setOnClickListener(cl);
        d3.setOnClickListener(cl);
        d4.setOnClickListener(cl);
        d5.setOnClickListener(cl);
        d6.setOnClickListener(cl);
        d7.setOnClickListener(cl);
        d8.setOnClickListener(cl);
        d9.setOnClickListener(cl);
        d10.setOnClickListener(cl);
        d11.setOnClickListener(cl);
        d12.setOnClickListener(cl);
        d13.setOnClickListener(cl);
        d14.setOnClickListener(cl);
        d15.setOnClickListener(cl);


    }
}

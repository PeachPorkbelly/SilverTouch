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

public class Theater_pay_select extends AppCompatActivity {

    ImageView   pay_select_view1,pay_select_view2,pay_select_view3,pay_select_view1_1,pay_select_view1_2,pay_select_view1_3;
    ImageButton exit,hint,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,cinema_pay_select_paybtn1,pay_select_fr_btn,cinema_pay_select_chbtn;
    Intent intent;
    MissionMethods missionMethods = new MissionMethods();
    Toast toast;
    View.OnClickListener cl;
    FrameLayout fr;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_pay_select);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.pay_select_title_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.pay_select_title_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.pay_select_title_3);

        exit = (ImageButton)findViewById(R.id.pay_select_exit);
        hint = (ImageButton)findViewById(R.id.pay_select_hint);

        cinema_pay_select_paybtn1 = (ImageButton)findViewById(R.id.cinema_pay_select_btn1) ;
        pay_select_fr_btn = (ImageButton)findViewById(R.id.pay_select_fr_btn);

        cinema_pay_select_chbtn = (ImageButton)findViewById(R.id.cinema_pay_select_chbtn);

        btn1 = (ImageButton) findViewById(R.id.cinema_pay_select_btn1);
        btn2 = (ImageButton) findViewById(R.id.cinema_pay_select_btn2);
        btn3 = (ImageButton) findViewById(R.id.cinema_pay_select_btn3);
        btn4 = (ImageButton) findViewById(R.id.cinema_pay_select_btn4);
        btn5 = (ImageButton) findViewById(R.id.cinema_pay_select_btn5);
        btn6 = (ImageButton) findViewById(R.id.cinema_pay_select_btn6);
        btn7 = (ImageButton) findViewById(R.id.cinema_pay_select_btn7);
        btn8 = (ImageButton) findViewById(R.id.cinema_pay_select_btn8);
        btn9 = (ImageButton) findViewById(R.id.cinema_pay_select_btn9);
        btn10 = (ImageButton) findViewById(R.id.cinema_pay_select_btn10);
        btn11 = (ImageButton) findViewById(R.id.cinema_pay_select_btn11);
        btn12 = (ImageButton) findViewById(R.id.cinema_pay_select_btn12);

        fr = (FrameLayout) findViewById(R.id.pay_select_frlayout);

        pay_select_view1 = (ImageView) findViewById(R.id.pay_select_view1);
        pay_select_view2 = (ImageView) findViewById(R.id.pay_select_view2);
        pay_select_view3 = (ImageView) findViewById(R.id.pay_select_view3);
        pay_select_view1_1 = (ImageView) findViewById(R.id.pay_select_view1_1);
        pay_select_view1_2 = (ImageView) findViewById(R.id.pay_select_view1_2);
        pay_select_view1_3 = (ImageView) findViewById(R.id.pay_select_view1_3);


        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cinema_pay_select_paybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr.setVisibility(FrameLayout.VISIBLE);
                pay_select_view1.setVisibility(ImageView.INVISIBLE);
                pay_select_view2.setVisibility(ImageView.INVISIBLE);
                pay_select_view3.setVisibility(ImageView.INVISIBLE);
                pay_select_view1_1.setVisibility(ImageView.VISIBLE);
                pay_select_view1_2.setVisibility(ImageView.VISIBLE);
                pay_select_view1_3.setVisibility(ImageView.VISIBLE);
            }
        });

        cinema_pay_select_chbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_pay_select_2.class);
                startActivity(intent);
            }
        });





        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"다른할인 또는 결제하기를 선책해 주세요.",Toast.LENGTH_SHORT).show();
            }
        };
        btn1.setOnClickListener(cl);
        btn2.setOnClickListener(cl);
        btn3.setOnClickListener(cl);
        btn4.setOnClickListener(cl);
        btn5.setOnClickListener(cl);
        btn6.setOnClickListener(cl);
        btn7.setOnClickListener(cl);
        btn8.setOnClickListener(cl);
        btn9.setOnClickListener(cl);
        btn10.setOnClickListener(cl);
        btn11.setOnClickListener(cl);
        btn12.setOnClickListener(cl);


    }

}

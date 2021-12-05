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

public class Theater_select extends AppCompatActivity {
    ImageButton exit,hint,pay_btn;
    ImageView a1,a2,a3,a4,a5,a6,a7,b1,b2,b3,b4,b5,b6,b7;
    ImageView c1,c2,c3,c4,c5,c6,c7,d1,d2,d3,d4,d5,d6,d7;
    ImageView e1,e2,e3,e4,e5,e6,e7,f1,f2,f3,f4,f5,f6,f7,g1,g2,g3,g4,g5,g6,g7;

    ImageView a1a,a2a,a3a,a4a,a5a,a6a,a7a,b1a,b2a,b3a,b4a,b5a,b6a,b7a;
    ImageView c1a,c2a,c3a,c4a,c5a,c6a,c7a,d1a,d2a,d3a,d4a,d5a,d6a,d7a;
    ImageView e1a,e2a,e3a,e4a,e5a,e6a,e7a,f1a,f2a,f3a,f4a,f5a,f6a,f7a,g1a,g2a,g3a,g4a,g5a,g6a,g7a;

    Intent intent;
    MissionMethods missionMethods = new MissionMethods();
    Toast toast;
    View.OnClickListener cl;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_select);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.cm_select_title_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.cm_select_title_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.cm_select_title_3);

        exit = (ImageButton)findViewById(R.id.cinema_select_exit);
        hint = (ImageButton)findViewById(R.id.cinema_select_hint);
        pay_btn = (ImageButton)findViewById(R.id.pay_btn);

        a1 = (ImageView)findViewById(R.id.set_btn_A1);
        a2 = (ImageView)findViewById(R.id.set_btn_A2);
        a3 = (ImageView)findViewById(R.id.set_btn_A3);
        a4 = (ImageView)findViewById(R.id.set_btn_A4);
        a5 = (ImageView)findViewById(R.id.set_btn_A5);
        a6 = (ImageView)findViewById(R.id.set_btn_A6);
        a7 = (ImageView)findViewById(R.id.set_btn_A7);

        b1 = (ImageView)findViewById(R.id.set_btn_B1);
        b2 = (ImageView)findViewById(R.id.set_btn_B2);
        b3 = (ImageView)findViewById(R.id.set_btn_B3);
        b4 = (ImageView)findViewById(R.id.set_btn_B4);
        b5 = (ImageView)findViewById(R.id.set_btn_B5);
        b6 = (ImageView)findViewById(R.id.set_btn_B6);
        b7 = (ImageView)findViewById(R.id.set_btn_B7);

        c1 = (ImageView)findViewById(R.id.set_btn_C1);
        c2 = (ImageView)findViewById(R.id.set_btn_C2);
        c3 = (ImageView)findViewById(R.id.set_btn_C3);
        c4 = (ImageView)findViewById(R.id.set_btn_C4);
        c5 = (ImageView)findViewById(R.id.set_btn_C5);
        c6 = (ImageView)findViewById(R.id.set_btn_C6);
        c7 = (ImageView)findViewById(R.id.set_btn_C7);

        d1 = (ImageView)findViewById(R.id.set_btn_D1);
        d2 = (ImageView)findViewById(R.id.set_btn_D2);
        d3 = (ImageView)findViewById(R.id.set_btn_D3);
        d4 = (ImageView)findViewById(R.id.set_btn_D4);
        d5 = (ImageView)findViewById(R.id.set_btn_D5);
        d6 = (ImageView)findViewById(R.id.set_btn_D6);
        d7 = (ImageView)findViewById(R.id.set_btn_D7);

        e1 = (ImageView)findViewById(R.id.set_btn_E1);
        e2 = (ImageView)findViewById(R.id.set_btn_E2);
        e3 = (ImageView)findViewById(R.id.set_btn_E3);
        e4 = (ImageView)findViewById(R.id.set_btn_E4);
        e5 = (ImageView)findViewById(R.id.set_btn_E5);
        e6 = (ImageView)findViewById(R.id.set_btn_E6);
        e7 = (ImageView)findViewById(R.id.set_btn_E7);

        f1 = (ImageView)findViewById(R.id.set_btn_F1);
        f2 = (ImageView)findViewById(R.id.set_btn_F2);
        f3 = (ImageView)findViewById(R.id.set_btn_F3);
        f4 = (ImageView)findViewById(R.id.set_btn_F4);
        f5 = (ImageView)findViewById(R.id.set_btn_F5);
        f6 = (ImageView)findViewById(R.id.set_btn_F6);
        f7 = (ImageView)findViewById(R.id.set_btn_F7);

        g1 = (ImageView)findViewById(R.id.set_btn_G1);
        g2 = (ImageView)findViewById(R.id.set_btn_G2);
        g3 = (ImageView)findViewById(R.id.set_btn_G3);
        g4 = (ImageView)findViewById(R.id.set_btn_G4);
        g5 = (ImageView)findViewById(R.id.set_btn_G5);
        g6 = (ImageView)findViewById(R.id.set_btn_G6);
        g7 = (ImageView)findViewById(R.id.set_btn_G7);

        a1a = (ImageView)findViewById(R.id.set_btn_A1c);
        a2a = (ImageView)findViewById(R.id.set_btn_A2c);
        a3a = (ImageView)findViewById(R.id.set_btn_A3c);
        a4a = (ImageView)findViewById(R.id.set_btn_A4c);
        a5a = (ImageView)findViewById(R.id.set_btn_A5c);
        a6a = (ImageView)findViewById(R.id.set_btn_A6c);
        a7a = (ImageView)findViewById(R.id.set_btn_A7c);

        b1a = (ImageView)findViewById(R.id.set_btn_B1c);
        b2a = (ImageView)findViewById(R.id.set_btn_B2c);
        b3a = (ImageView)findViewById(R.id.set_btn_B3c);
        b4a = (ImageView)findViewById(R.id.set_btn_B4c);
        b5a = (ImageView)findViewById(R.id.set_btn_B5c);
        b6a = (ImageView)findViewById(R.id.set_btn_B6c);
        b7a = (ImageView)findViewById(R.id.set_btn_B7c);

        c1a = (ImageView)findViewById(R.id.set_btn_C1c);
        c2a = (ImageView)findViewById(R.id.set_btn_C2c);
        c3a = (ImageView)findViewById(R.id.set_btn_C3c);
        c4a = (ImageView)findViewById(R.id.set_btn_C4c);
        c5a = (ImageView)findViewById(R.id.set_btn_C5c);
        c6a = (ImageView)findViewById(R.id.set_btn_C6c);
        c7a = (ImageView)findViewById(R.id.set_btn_C7c);

        d1a = (ImageView)findViewById(R.id.set_btn_D1c);
        d2a = (ImageView)findViewById(R.id.set_btn_D2c);
        d3a = (ImageView)findViewById(R.id.set_btn_D3c);
        d4a = (ImageView)findViewById(R.id.set_btn_D4c);
        d5a = (ImageView)findViewById(R.id.set_btn_D5c);
        d6a = (ImageView)findViewById(R.id.set_btn_D6c);
        d7a = (ImageView)findViewById(R.id.set_btn_D7c);

        e1a = (ImageView)findViewById(R.id.set_btn_E1c);
        e2a = (ImageView)findViewById(R.id.set_btn_E2c);
        e3a = (ImageView)findViewById(R.id.set_btn_E3c);
        e4a = (ImageView)findViewById(R.id.set_btn_E4c);
        e5a = (ImageView)findViewById(R.id.set_btn_E5c);
        e6a = (ImageView)findViewById(R.id.set_btn_E6c);
        e7a = (ImageView)findViewById(R.id.set_btn_E7c);

        f1a = (ImageView)findViewById(R.id.set_btn_F1c);
        f2a = (ImageView)findViewById(R.id.set_btn_F2c);
        f3a = (ImageView)findViewById(R.id.set_btn_F3c);
        f4a = (ImageView)findViewById(R.id.set_btn_F4c);
        f5a = (ImageView)findViewById(R.id.set_btn_F5c);
        f6a = (ImageView)findViewById(R.id.set_btn_F6c);
        f7a = (ImageView)findViewById(R.id.set_btn_F7c);

        g1a = (ImageView)findViewById(R.id.set_btn_G1c);
        g2a = (ImageView)findViewById(R.id.set_btn_G2c);
        g3a = (ImageView)findViewById(R.id.set_btn_G3c);
        g4a = (ImageView)findViewById(R.id.set_btn_G4c);
        g5a = (ImageView)findViewById(R.id.set_btn_G5c);
        g6a = (ImageView)findViewById(R.id.set_btn_G6c);
        g7a = (ImageView)findViewById(R.id.set_btn_G7c);


        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g1a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g2a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g3a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g4a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g5a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g6a.setVisibility(ImageButton.VISIBLE);
            }
        });

        g7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g7a.setVisibility(ImageButton.VISIBLE);
            }
        });

        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_pay.class);
                startActivity(intent);
            }
        });


    }

}

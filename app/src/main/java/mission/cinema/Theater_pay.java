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

public class Theater_pay extends AppCompatActivity {

    ImageButton exit,hint,pay_btn_card,pay_btn_kakao,pay_btn_payco,pay_btn_ez;
    ImageButton pay_btn_cp,pay_btn_dc;
    Intent intent;
    MissionMethods missionMethods = new MissionMethods();
    Toast toast;
    View.OnClickListener cl;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_pay);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.cm_pay_title_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.cm_pay_title_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.cm_pay_title_3);

        exit = (ImageButton)findViewById(R.id.cinema_pay_exit);
        hint = (ImageButton)findViewById(R.id.cinema_pay_hint);

        pay_btn_card = (ImageButton)findViewById(R.id.pay_btn_card);
        pay_btn_kakao = (ImageButton)findViewById(R.id.pay_btn_kakao);
        pay_btn_payco = (ImageButton)findViewById(R.id.pay_btn_payco);
        pay_btn_ez = (ImageButton)findViewById(R.id.pay_btn_ez);

        pay_btn_cp = (ImageButton)findViewById(R.id.pay_btn_cp);
        pay_btn_dc = (ImageButton)findViewById(R.id.pay_btn_dc);


        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(getApplicationContext(),"할인 수단을 먼저 선택해주세요.",Toast.LENGTH_SHORT).show();
            }
        };

        pay_btn_cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_pay_select.class);
                startActivity(intent);
            }
        });

        pay_btn_dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Theater_pay_select.class);
                startActivity(intent);
            }
        });

        pay_btn_kakao.setOnClickListener(cl);
        pay_btn_card.setOnClickListener(cl);
        pay_btn_ez.setOnClickListener(cl);
        pay_btn_payco.setOnClickListener(cl);

    }

}

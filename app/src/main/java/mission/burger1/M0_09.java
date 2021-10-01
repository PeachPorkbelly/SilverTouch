package mission.burger1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

public class M0_09 extends AppCompatActivity {
    ImageButton more, cancel, ca, mo, lp, tm;
    View.OnClickListener cl;
    Intent i;
    int count1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m009);




        cancel=(ImageButton)findViewById(R.id.cancel);
        more=(ImageButton)findViewById(R.id.more);
        ca=(ImageButton)findViewById(R.id.card2);
        mo=(ImageButton)findViewById(R.id.mobile);
        lp=(ImageButton)findViewById(R.id.lpay);
        tm=(ImageButton)findViewById(R.id.tmoney);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.more:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.card2:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_10.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.mobile:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_10.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.lpay:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_10.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.tmoney:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_10.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        more.setOnClickListener(cl);
        cancel.setOnClickListener(cl);
        ca.setOnClickListener(cl);
        mo.setOnClickListener(cl);
        lp.setOnClickListener(cl);
        tm.setOnClickListener(cl);
    }
    /*
뒤로가기 버튼 눌렀을 때
*/
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class); //합칠 때 수정필요
        startActivity(i);
        super.onBackPressed();
    }
}
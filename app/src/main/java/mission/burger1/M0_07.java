package mission.burger1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

public class M0_07 extends AppCompatActivity {

    ImageButton po, chi, che, oni, cok, spr, ok, can, cancel;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m007);


        po=(ImageButton) findViewById(R.id.potato);
        chi=(ImageButton) findViewById(R.id.chicken);
        che=(ImageButton) findViewById(R.id.cheesestick);
        oni=(ImageButton) findViewById(R.id.onion);
        cok=(ImageButton) findViewById(R.id.coke);
        spr=(ImageButton) findViewById(R.id.sprite);
        ok=(ImageButton) findViewById(R.id.ok);
        can=(ImageButton) findViewById(R.id.cancel2);
        cancel=(ImageButton)findViewById(R.id.cancel);


        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ok:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_08.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel2:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_06.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        ok.setOnClickListener(cl);
        can.setOnClickListener(cl);
        cancel.setOnClickListener(cl);
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
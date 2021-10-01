package mission.burger1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

public class M0_01 extends AppCompatActivity {

    Intent i;
    ImageButton card, cash, di;
    View.OnClickListener cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m001);



        di=(ImageButton) findViewById(R.id.digital);
        card=(ImageButton) findViewById(R.id.card);
        cash=(ImageButton) findViewById(R.id.cash);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.card:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cash:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.digital:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                }
            }
        };
        di.setOnClickListener(cl);
        card.setOnClickListener(cl);
        cash.setOnClickListener(cl);
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
package mission.burger1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

public class M0_10 extends AppCompatActivity {
    ImageButton im;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m010);


        im=(ImageButton)findViewById(R.id.imageButton);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageButton:
                        i = new Intent(getApplicationContext(), mission.burger1.M0_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        im.setOnClickListener(cl);
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
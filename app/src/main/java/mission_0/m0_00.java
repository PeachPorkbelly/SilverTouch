package mission_0;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import mission.MissionMethods;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

public class m0_00 extends AppCompatActivity {

    public static int M0;
    ImageButton hangjeong;
    Intent intent;
    ImageButton exit;
    MissionMethods missionMethods = new MissionMethods();

    /*
    주민등록 초본 떼는 프로그램
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0_00);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.missionOrder_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.missionOrder_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.missionOrder_3);
        hangjeong = (ImageButton)findViewById(R.id.m0_00_hangjeong);
        exit = (ImageButton)findViewById(R.id.m0_00_exit);
        int missionOrder = getIntent().getIntExtra("missionOrder",0);

        M0 = missionOrder;

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        hangjeong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(),m0_01.class);
                startActivity(intent);
            }
        });

    }
}

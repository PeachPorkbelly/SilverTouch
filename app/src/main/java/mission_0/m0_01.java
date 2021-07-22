package mission_0;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import static mission_0.m0_00.M0;

public class m0_01 extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0_01);


        /*
        버튼들
         */
        ImageButton jumin = (ImageButton)findViewById(R.id.m0_01_jumin);
        ImageButton hint = (ImageButton)findViewById(R.id.m0_01_hint);


        /*
        미션 순서에 대한 정보를 담은 이미지 뷰
         */
        ImageView m1 = (ImageView)findViewById(R.id.m0_01_mission_order_1);
        ImageView m2 = (ImageView)findViewById(R.id.m0_01_mission_order_2);
        ImageView m3 = (ImageView)findViewById(R.id.m0_01_mission_order_3);


        /*
        몇번째 미션인지 표시
         */
        if (M0==1){
            m1.setVisibility(View.VISIBLE);
            m2.setVisibility(View.INVISIBLE);
            m3.setVisibility(View.INVISIBLE);
        }else if (M0==2){
            m1.setVisibility(View.INVISIBLE);
            m2.setVisibility(View.VISIBLE);
            m3.setVisibility(View.INVISIBLE);
        }else if (M0==3){
            m1.setVisibility(View.INVISIBLE);
            m2.setVisibility(View.INVISIBLE);
            m3.setVisibility(View.VISIBLE);
        }


        /*
        버튼 누르면 할 일들들
         */

    }
}

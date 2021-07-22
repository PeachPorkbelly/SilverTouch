package mission_0;

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

import static mission_0.m0_00.M0;

public class m0_01 extends AppCompatActivity {

    Intent i;
    FrameLayout fl;
    ImageView initialize;
    ImageView connecting;
    ImageView ld_off_1;
    ImageView ld_off_2;
    ImageView ld_off_3;

    ImageView ld_on_1;
    ImageView ld_on_2;
    ImageView ld_on_3;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.m0_01);

        /*
        반투명 레이아웃
         */
        fl = (FrameLayout)findViewById(R.id.m0_01_transparent_layout);

        /*
        로딩 이미지 파일들
         */
        initialize = (ImageView)findViewById(R.id.m0_00_initialize);
        connecting = (ImageView)findViewById(R.id.m0_00_connecting);

        ld_off_1 = (ImageView)findViewById(R.id.m0_00_loading_off1);
        ld_off_2 = (ImageView)findViewById(R.id.m0_00_loading_off2);
        ld_off_3 = (ImageView)findViewById(R.id.m0_00_loading_off3);

        ld_on_1 = (ImageView)findViewById(R.id.m0_00_loading_on1);
        ld_on_2 = (ImageView)findViewById(R.id.m0_00_loading_on2);
        ld_on_3 = (ImageView)findViewById(R.id.m0_00_loading_on3);

        /*
        버튼들
         */
        ImageButton jumin = (ImageButton)findViewById(R.id.m0_01_jumin);
        ImageButton hint = (ImageButton)findViewById(R.id.m0_01_hint);
        ImageButton exit = (ImageButton)findViewById(R.id.m0_01_exit);


        /*
        미션 순서에 대한 정보를 담은 이미지 뷰
         */
        ImageView m1 = (ImageView)findViewById(R.id.m0_01_mission_order_1);
        ImageView m2 = (ImageView)findViewById(R.id.m0_01_mission_order_2);
        ImageView m3 = (ImageView)findViewById(R.id.m0_01_mission_order_3);


        /*
       실행할 코드들
       */

        set_initialPage();

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

        //exit
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
                startActivity(i);
            }
        });

        //hint
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"힌트입니다",Toast.LENGTH_SHORT).show();
            }
        });

        //jumin
        jumin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl.setVisibility(View.VISIBLE);
            }
        });

    }


    /*
    jumin 버튼이 눌리기 전에 보여지면 안되는 이미지들 모두 Invisible 시키는 함수
     */
    public void set_initialPage(){
        /*
        VIsible/Invisible
         */
        fl.setVisibility(View.INVISIBLE);
        initialize.setVisibility(View.INVISIBLE);
        connecting.setVisibility(View.INVISIBLE);
        ld_off_1.setVisibility(View.INVISIBLE);
        ld_off_2.setVisibility(View.INVISIBLE);
        ld_off_3.setVisibility(View.INVISIBLE);
        ld_on_1.setVisibility(View.INVISIBLE);
        ld_on_2.setVisibility(View.INVISIBLE);
        ld_on_3.setVisibility(View.INVISIBLE);

    }
}

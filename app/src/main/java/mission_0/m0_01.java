package mission_0;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;
import mission.MissionMethods;

import static mission_0.m0_00.M0;

public class m0_01 extends AppCompatActivity {

    Intent i;
    FrameLayout fl;

    ImageView initialize, connecting;
    ImageView ld_off_1,ld_off_2,ld_off_3;
    ImageView ld_on_1,ld_on_2,ld_on_3;
    ImageView m1, m2, m3;

    ImageButton jumin, exit, hint;

    MissionMethods missionMethods = new MissionMethods();

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
        jumin = (ImageButton)findViewById(R.id.m0_01_jumin);
        hint = (ImageButton)findViewById(R.id.m0_01_hint);
        exit = (ImageButton)findViewById(R.id.m0_01_exit);


        /*
        미션 순서에 대한 정보를 담은 이미지 뷰
         */
        m1 = (ImageView)findViewById(R.id.m0_01_mission_order_1);
        m2 = (ImageView)findViewById(R.id.m0_01_mission_order_2);
        m3 = (ImageView)findViewById(R.id.m0_01_mission_order_3);


        /*
       초기화면
       */
        set_initialPage();
        missionMethods.set_missionOrder(M0,m1,m2,m3);



        /*
        버튼 누르면 할 일들들
         */
        //exit
        missionMethods.set_Exit(exit,this);


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
                initialize.setVisibility(View.VISIBLE);

                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        i = new Intent(getApplicationContext(),m0_02.class);
                        startActivity(i);
                    }
                },2000);

                //ld_on_1.setVisibility(View.VISIBLE);




                /*

                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        connecting.setVisibility(View.VISIBLE);
                        ld_off_1.setVisibility(View.VISIBLE);
                        ld_off_2.setVisibility(View.VISIBLE);
                        ld_off_3.setVisibility(View.VISIBLE);
                    }
                },500);

                Handler handler1 = new Handler();

                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ld_on_1.setVisibility(View.VISIBLE);
                    }
                },500);

                try {
                    handler1.wait((long) 5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Handler handler2 = new Handler();

                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ld_on_2.setVisibility(View.VISIBLE);
                    }
                },500);

                Handler handler3 = new Handler();

                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ld_on_3.setVisibility(View.VISIBLE);
                    }
                },500);

                 */




                /*
                Timer timer0 = new Timer();
                Timer timer1 = new Timer();

                TimerTask timerTask0 = new TimerTask() {
                    @Override
                    public void run() {
                        connecting.setVisibility(View.VISIBLE);
                        ld_off_1.setVisibility(View.VISIBLE);
                        ld_off_2.setVisibility(View.VISIBLE);
                        ld_off_3.setVisibility(View.VISIBLE);
                    }
                };

                timer0.schedule(timerTask0,500);

                TimerTask timerTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        ld_on_1.setVisibility(View.VISIBLE);
                    }
                };
                timer1.schedule(timerTask1,500);

                 */



            } //onClick
        }); //setOnClickListener

    }//onCreate




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

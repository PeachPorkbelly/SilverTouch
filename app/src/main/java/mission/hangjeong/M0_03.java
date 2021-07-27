package mission.hangjeong;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import mission.MissionMethods;
import static mission.hangjeong.M0_00.M0;

public class M0_03 extends AppCompatActivity {

    MissionMethods missionMethods = new MissionMethods();

    /*
    이미지 버튼 변수
     */

    //숫자패드
    ImageButton btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_edit, btn_del;
    //뒤로가기, 홈, 힌트, 입력 완료 버튼
    ImageButton btn_ok, btn_previous, btn_home, btn_hint, btn_exit;

    //몇번째 미션인지
    ImageView m1,m2,m3;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission_hangjeong_m0_03);

        //숫자패드
        btn_0 = (ImageButton)findViewById(R.id.m0_03_btn_0);
        btn_1 = (ImageButton)findViewById(R.id.m0_03_btn_1);
        btn_2 = (ImageButton)findViewById(R.id.m0_03_btn_2);
        btn_3 = (ImageButton)findViewById(R.id.m0_03_btn_3);
        btn_4 = (ImageButton)findViewById(R.id.m0_03_btn_4);
        btn_5 = (ImageButton)findViewById(R.id.m0_03_btn_5);
        btn_6 = (ImageButton)findViewById(R.id.m0_03_btn_6);
        btn_7 = (ImageButton)findViewById(R.id.m0_03_btn_7);
        btn_8 = (ImageButton)findViewById(R.id.m0_03_btn_8);
        btn_9 = (ImageButton)findViewById(R.id.m0_03_btn_9);
        btn_edit = (ImageButton)findViewById(R.id.m0_03_btn_edit);
        btn_del = (ImageButton)findViewById(R.id.m0_03_btn_del);

        //입력완료, 이전으로, 홈으로, 힌트 버튼
        btn_ok = (ImageButton)findViewById(R.id.m0_03_btn_ok);
        btn_previous = (ImageButton)findViewById(R.id.m0_03_previous);
        btn_home = (ImageButton)findViewById(R.id.m0_03_home);
        btn_hint = (ImageButton)findViewById(R.id.m0_03_hint);
        btn_exit = (ImageButton)findViewById(R.id.m0_03_exit);

        //몇번째 미션인지
        m1 = (ImageView)findViewById(R.id.m0_03_mission_order_1);
        m2 = (ImageView)findViewById(R.id.m0_03_mission_order_2);
        m3 = (ImageView)findViewById(R.id.m0_03_mission_order_3);

        /*
        실행할 코드
         */

        //몇번째 미션인지 띄우기
        missionMethods.set_missionOrder(M0,m1,m2,m3);
        //홈으로,메인으로,뒤로
        missionMethods.set_Exit(btn_exit,this);
        missionMethods.goto_thisClass(btn_home,M0_00.class,this);
        missionMethods.goto_thisClass(btn_previous,M0_02.class,this);



    }
}

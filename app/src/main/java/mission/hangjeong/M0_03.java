package mission.hangjeong;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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
    //확인버튼을 눌러주세요, 선택 손가락
    ImageView ok_msg, finger;
    View.OnClickListener cl;

    TextView text_front_jumin, text_back_jumin;
    String front_jumin, back_jumin;

    // 숫자 패드 누르면 실행 되는 함수
    public void numberBtnClicked(int input_number){

        if (front_jumin.length() < 6){  // 주민번호 앞 자리가 6자리 미만인 경우

            front_jumin += input_number;
            text_front_jumin.setText(front_jumin);

        } else if (back_jumin.length() < 7){    // 주민번호 앞 자리가 6자리 다 차있고, 뒷 자리가 7자리 미만인 경우

            back_jumin += input_number;
            text_back_jumin.setText(back_jumin);

        } else if ((front_jumin.length() + back_jumin.length()) == 13) {
            /* 주민번호 13자리 다 찼을 경우 */

        } else{
            /* 알 수 없는 곳? */

        }

    }
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

        //확인을 눌러주세요, 손가락
        ok_msg = (ImageView)findViewById(R.id.m0_03_ok_msg);
        finger = (ImageView)findViewById(R.id.m0_03_finger);

        text_front_jumin = (TextView) findViewById(R.id.m0_03_front_jumin);
        text_back_jumin = (TextView) findViewById(R.id.m0_03_back_jumin);

        /*
        실행할 코드 - 주민번호 13자리 다 입력시 확인, 확인버튼을 눌러주세요/ 확인 버튼 visible
        13자리 입력 전에 확인 버튼이 눌렸을 때 팝업 토스트 메세지
        13자리 입력 후 확인 버튼이 눌렸을 때 -> 로딩화면(0.5초) imageView visible  -> M0_04.class 로 넘어감
        정정/삭제 버튼 기능 구현 - 정정(btn_edit) 1자리 지움, 삭제(btn_del) 전체 지움
        % String에서 마지막꺼 제거 str.substring(0, str.length()-1);

        2021-07-29 01:13 김광희 -> 주민번호 버튼 입력기능 추가 완료
         */

        // 정정 버튼 기능
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                front_jumin = text_front_jumin.getText().toString();
                back_jumin = text_back_jumin.getText().toString();

                // 앞 주민에만 입력되었을 경우
                if (front_jumin.length() <= 6 && back_jumin.length() == 0){
                    front_jumin = front_jumin.substring(0, front_jumin.length()-1);
                    text_front_jumin.setText(front_jumin);

                } else if(back_jumin.length() >= 1){    // 앞 주민은 6자리,  뒷 주민은 1자리 이상
                    back_jumin = back_jumin.substring(0, back_jumin.length()-1);
                    text_back_jumin.setText(back_jumin);
                }
            }
        });

        // 삭제 버튼 기능
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                front_jumin = "";
                back_jumin = "";

                text_front_jumin.setText(front_jumin);
                text_back_jumin.setText(back_jumin);
            }
        });

        // 숫자 버튼 기능
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                front_jumin = text_front_jumin.getText().toString();
                back_jumin = text_back_jumin.getText().toString();

                switch (v.getId()){
                    case R.id.m0_03_btn_0:
                        numberBtnClicked(0);
                        break;

                    case R.id.m0_03_btn_1:
                        numberBtnClicked(1);
                        break;

                    case R.id.m0_03_btn_2:
                        numberBtnClicked(2);
                        break;

                    case R.id.m0_03_btn_3:
                        numberBtnClicked(3);
                        break;

                    case R.id.m0_03_btn_4:
                        numberBtnClicked(4);
                        break;

                    case R.id.m0_03_btn_5:
                        numberBtnClicked(5);
                        break;

                    case R.id.m0_03_btn_6:
                        numberBtnClicked(6);
                        break;

                    case R.id.m0_03_btn_7:
                        numberBtnClicked(7);
                        break;

                    case R.id.m0_03_btn_8:
                        numberBtnClicked(8);
                        break;

                    case R.id.m0_03_btn_9:
                        numberBtnClicked(9);
                        break;

                }
            }
        };

        btn_0.setOnClickListener(cl);
        btn_1.setOnClickListener(cl);
        btn_2.setOnClickListener(cl);
        btn_3.setOnClickListener(cl);
        btn_4.setOnClickListener(cl);
        btn_5.setOnClickListener(cl);
        btn_6.setOnClickListener(cl);
        btn_7.setOnClickListener(cl);
        btn_8.setOnClickListener(cl);
        btn_9.setOnClickListener(cl);


        //몇번째 미션인지 띄우기
        missionMethods.set_missionOrder(M0,m1,m2,m3);
        //홈으로,메인으로,뒤로
        missionMethods.set_Exit(btn_exit,this);
        missionMethods.goto_thisClass(btn_home,M0_01.class,this);
        missionMethods.goto_thisClass(btn_previous,M0_02.class,this);

        //finger와 ok_msg invisible
        finger.setVisibility(View.INVISIBLE); ok_msg.setVisibility(View.INVISIBLE);



    }
}

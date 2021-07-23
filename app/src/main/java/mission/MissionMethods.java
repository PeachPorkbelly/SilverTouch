package mission;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MissionMethods {

    /*
    미션 공통 메소드들
     */

    //몇번 미션이 나와야 하는지 알려줌
    public void set_missionOrder(int missionOrder, ImageView m1, ImageView m2, ImageView m3) {
        if (missionOrder == 1) {
            m1.setVisibility(View.VISIBLE);
            m2.setVisibility(View.INVISIBLE);
            m3.setVisibility(View.INVISIBLE);
        } else if (missionOrder == 2) {
            m1.setVisibility(View.INVISIBLE);
            m2.setVisibility(View.VISIBLE);
            m3.setVisibility(View.INVISIBLE);
        } else if (missionOrder == 3) {
            m1.setVisibility(View.INVISIBLE);
            m2.setVisibility(View.INVISIBLE);
            m3.setVisibility(View.VISIBLE);
        }
    }

    //종료 버튼
    public void set_Exit(ImageButton exit, Context context){
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,com.example.silvertouch.MainActivity.class);
                context.startActivity(intent);
            }
        });
    }


    /*
    *******************
    *******************
    * 미션 0의 함수들
    *******************
    *******************
     */

    //뒤로가기
    public void M0_gotoPrevious(ImageButton previous, Class targetClass, Context context){
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,targetClass);
                context.startActivity(intent);
            }
        });
    }
    //처음 화면으로
    public void M0_gotoFirstPage(ImageButton home, Class targetClass, Context context){
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,targetClass);
                context.startActivity(intent);
            }
        });
    }

}//main

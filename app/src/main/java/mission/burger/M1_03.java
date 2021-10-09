package mission.burger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

import mission.MissionMethods;
import static mission.burger.M0_Map.M0;

public class M1_03 extends AppCompatActivity {

    ImageButton rec, des,dri,cancel,exit;
    View.OnClickListener cl;
    Intent i;
    MissionMethods missionMethods = new MissionMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m103);

        ImageView missionOrder1 = (ImageView)findViewById(R.id.bg_m1_03_mission_order_1);
        ImageView missionOrder2 = (ImageView)findViewById(R.id.bg_m1_03_mission_order_2);
        ImageView missionOrder3 = (ImageView)findViewById(R.id.bg_m1_03_mission_order_3);


        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2); //2개까지 caching

        burger1.MainPagerAdapter adapter = new burger1.MainPagerAdapter(getSupportFragmentManager(), 1);

        BurgerFragment0_1 fragment1 = new BurgerFragment0_1();
        adapter.addItem(fragment1);

        mission.burger.BurgerFragment1_2 fragment2 = new mission.burger.BurgerFragment1_2();
        adapter.addItem(fragment2);

        pager.setAdapter(adapter);

        rec=(ImageButton) findViewById(R.id.recomm);
        des=(ImageButton) findViewById(R.id.desert);
        dri=(ImageButton) findViewById(R.id.drink);
        cancel=(ImageButton)findViewById(R.id.cancel);
        exit=(ImageButton) findViewById(R.id.bg1_x3);

        //몇번째 미션인지
        missionMethods.set_missionOrder(M0,missionOrder1,missionOrder2,missionOrder3);
        //종료버튼
        missionMethods.set_Exit(exit,this);

        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.recomm:
                        i = new Intent(getApplicationContext(), mission.burger.M1_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.desert:
                        i = new Intent(getApplicationContext(), mission.burger.M1_04.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.drink:
                        i = new Intent(getApplicationContext(), mission.burger.M1_05.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger.M1_00.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;

                }
            }
        };
        rec.setOnClickListener(cl);
        des.setOnClickListener(cl);
        dri.setOnClickListener(cl);
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
package mission.burger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

public class M0_03 extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    ImageButton rec, des,dri,cancel;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m003);

        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2); //2개까지 caching

        burger1.MainPagerAdapter adapter = new burger1.MainPagerAdapter(getSupportFragmentManager(), 1);

        BurgerFragment0_1 fragment1 = new BurgerFragment0_1();
        adapter.addItem(fragment1);

        mission.burger.BurgerFragment0_2 fragment2 = new mission.burger.BurgerFragment0_2();
        adapter.addItem(fragment2);

        pager.setAdapter(adapter);

        rec=(ImageButton) findViewById(R.id.recomm);
        des=(ImageButton) findViewById(R.id.desert);
        dri=(ImageButton) findViewById(R.id.drink);
        cancel=(ImageButton)findViewById(R.id.cancel);


        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.recomm:
                        i = new Intent(getApplicationContext(), mission.burger.M0_02.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.desert:
                        i = new Intent(getApplicationContext(), mission.burger.M0_04.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.drink:
                        i = new Intent(getApplicationContext(), mission.burger.M0_05.class);
                        startActivity(i);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                        break;
                    case R.id.cancel:
                        i = new Intent(getApplicationContext(), mission.burger.M0_00.class);
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
package mission.burger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;

public class M0_08 extends AppCompatActivity {
    ImageButton pay, cancel;
    View.OnClickListener cl;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m008);



        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2); //2개까지 caching

        burger1.MainPagerAdapter adapter = new burger1.MainPagerAdapter(getSupportFragmentManager(), 1);

        BurgerFragment0_1 fragment1 = new BurgerFragment0_1();
        adapter.addItem(fragment1);

        mission.burger.BurgerFragment0_2 fragment2 = new mission.burger.BurgerFragment0_2();
        adapter.addItem(fragment2);

        pager.setAdapter(adapter);

        pay=(ImageButton) findViewById(R.id.pay);
        cancel=(ImageButton) findViewById(R.id.cancel);


        cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.pay:
                        i = new Intent(getApplicationContext(), mission.burger.M0_09.class);
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
        pay.setOnClickListener(cl);
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
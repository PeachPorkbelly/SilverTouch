package card;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.silvertouch.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class Card00 extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private int current;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_00);

        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        ImageView btn_next = findViewById(R.id.btn_next);
        ImageView btn_pre = findViewById(R.id.btn_pre);
        TabLayout mTabLayout = findViewById(R.id.mTabLayout);
        ImageButton exit = findViewById(R.id.card_00_exit);

        // 상단 슬라이드 이미지
        //카드 이미지들을 리스트에 넣어서 다시 넣기 => 이미지뷰 리턴타입 int
        List<Card00_sliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new Card00_sliderItem(R.drawable.card0));
        sliderItems.add(new Card00_sliderItem(R.drawable.card1));
        sliderItems.add(new Card00_sliderItem(R.drawable.mission_bg_card2));
        sliderItems.add(new Card00_sliderItem(R.drawable.card3));
        sliderItems.add(new Card00_sliderItem(R.drawable.card4));
        sliderItems.add(new Card00_sliderItem(R.drawable.card5));
        sliderItems.add(new Card00_sliderItem(R.drawable.card6));
        sliderItems.add(new Card00_sliderItem(R.drawable.card7));
        sliderItems.add(new Card00_sliderItem(R.drawable.card8));
        sliderItems.add(new Card00_sliderItem(R.drawable.card9));


        // 하단 미리보기 이미지
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card0));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card1));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.mission_bg_card2));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card3));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card4));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card5));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card6));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card7));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card8));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card9));

//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));

        //미리보기 페이지 포함 총 3개의 화면을 보여줌
        viewPager2.setAdapter(new Card00_sliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setCurrentItem(Integer.MAX_VALUE / 2, false); //무한페이지 처럼 보이거 하기 위해서 시작을 처음이 아닌 중간에서 시작
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        //viewpager 좌우 프리뷰
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        // 다음 이미지 보기 버튼
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = viewPager2.getCurrentItem();
                if (current == 0) {
                    viewPager2.setCurrentItem(1, true);
                } else {
                    viewPager2.setCurrentItem(current + 1, true);
                }
            }
        });

        // 이전 이미지 보기 버튼
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = viewPager2.getCurrentItem();
                if (current == 0) {
                    viewPager2.setCurrentItem(current, true);
                } else {
                    viewPager2.setCurrentItem(current - 1, true);
                }
            }
        });


        /*
           tabLayout 클릭시 뷰페이저 설정

         */

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // tab이 선택되었을 때
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
                startActivity(intent);
            }
        });

    }
    //나중에 함수로 빼기기
   public void addPictures(){

    }
}

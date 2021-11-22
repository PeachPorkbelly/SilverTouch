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
        ImageButton exit = findViewById(R.id.card_00_exit);

        ImageButton btnSelect = findViewById(R.id.card_00_btn_select);

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

        // 나가기 이미지 보기 버튼
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
                startActivity(intent);
            }
        });

        // 선택 이미지 보기 버튼
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Card01.class);
                // 선택한 배경화면 Card01로 전달
                intent.putExtra("bg", sliderItems.get(viewPager2.getCurrentItem() % 10).getImage());
                startActivity(intent);
                
                finish(); // 액티비티 종료
            }
        });

    }
    //나중에 함수로 빼기기
   public void addPictures(){

    }
}

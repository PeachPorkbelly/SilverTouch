package card;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.silvertouch.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class Card01 extends AppCompatActivity {

    // 전역변수 선언부

    /// ViewPager 관련
    private ViewPager2 viewPager2;
    private Card01_ViewPagerAdapter viewPagerAdapter;

    // View 관련
//    private ImageView decoView; // 왜 필요한가?
    private RelativeLayout editLayout;
    Button btnSave;
    Button btnBack;

    // 기타
    ArrayList<Integer> decoItems; // 데코 아이템 리스트
    Intent intent; // Intent

    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_01);

        // 기타 객체 초기화
        decoItems = new ArrayList<>();

        // View 연결
        viewPager2 = findViewById(R.id.card_01_decoItemViewPager);
        editLayout = findViewById(R.id.card_01_editLayout);
        btnSave = findViewById(R.id.card_01_btn_save);
        btnBack = findViewById(R.id.card_01_btn_back);

        // Card00에서 선택한 이미지 배경으로 설정
        intent = getIntent();
        int bg = intent.getExtras().getInt("bg");
        Drawable drawbleBg = getResources().getDrawable(bg);
        editLayout.setBackground(drawbleBg);
        // ----


        // deco item 추가 부분 추후에 수정~
        for(int i = 0; i<32; i++){
            decoItems.add(R.drawable.card_deco_01);
            decoItems.add(R.drawable.card_deco_02);
            decoItems.add(R.drawable.card_deco_03);
            decoItems.add(R.drawable.card_deco_04);
            decoItems.add(R.drawable.card_deco_05);
        }
        // ----

        // ViewPager2 Setting 관련
        viewPagerAdapter = new Card01_ViewPagerAdapter(decoItems);
        viewPagerAdapter.setOnItemClickListener(index -> {
            int rid = decoItems.get(index);
            ImageView deco = new ImageView(this);
            deco.setImageResource(rid);

            /// 이미지 뷰 이동 및 확대 축소 관련
            deco.setOnTouchListener(new Card01_TouchListener());
            editLayout.addView(deco);
        });

        viewPager2.setAdapter(viewPagerAdapter);
        // ----


        // Button ClickListener 연결
        /// 뒤로가기 버튼
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Card00.class);
                startActivity(intent);
                finish();
            }
        });

        /// 이미지 저장 버튼
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharingImage();
            }
        });
        // ----
    }

    // share Image
    public void sharingImage(){
        // 이미지 저장 후 공유하는 메소드입니다
        Context context = getApplicationContext();

        // view -> bitmap start
        editLayout.setDrawingCacheEnabled(true);
        editLayout.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(editLayout.getDrawingCache());
        // view -> bitmap end

        String saveFileName = "share.png";

        try{
            // 이미지 저장
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), saveFileName);
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();

            // uri 저장
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);

            // 이미지 공유
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(shareIntent, "이미지 공유하기"));

        } catch (Exception e){
            Log.d("Save", e.getMessage());
        }
    }
    // ----
}

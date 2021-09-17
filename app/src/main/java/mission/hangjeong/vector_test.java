package mission.hangjeong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class vector_test extends AppCompatActivity {


    //새싹,꽃 기본위치
    ImageView defaultPlace_01,defaultPlace_02,defaultPlace_03,defaultPlace_04,defaultPlace_05,defaultPlace_06,defaultPlace_07,defaultPlace_08,defaultPlace_09,defaultPlace_10;

    //꽃 자라날 위치를 담은 리스트
    ArrayList<ImageView> defaultPlace = new ArrayList<>();

    //물뿌리개 버튼
    ImageButton btn_wateringCan;

    //초기화, 물뿌리개 수 up
    Button btn_init, btn_wateringCanUp;

    //wateringCan 개수 보여줄 text
    TextView wateringCanNum;

    //wateringCan 개수
    int wateringCan;

    //wateringCan이 눌린 총 횟수
    int wateredCount;

    // defaultPlace Index때 쓸 변수
    int defaultPlaceStartCount, defaultPlaceEndCount;

    SavedInfo si = new SavedInfo();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mygarden);

        //꽃 기본 위치
        defaultPlace_01 = (ImageView)findViewById(R.id.mygarden_defaultPlace_01);
        defaultPlace_02 = (ImageView)findViewById(R.id.mygarden_defaultPlace_02);
        defaultPlace_03 = (ImageView)findViewById(R.id.mygarden_defaultPlace_03);
        defaultPlace_04 = (ImageView)findViewById(R.id.mygarden_defaultPlace_04);
        defaultPlace_05 = (ImageView)findViewById(R.id.mygarden_defaultPlace_05);
        defaultPlace_06 = (ImageView)findViewById(R.id.mygarden_defaultPlace_06);
        defaultPlace_07 = (ImageView)findViewById(R.id.mygarden_defaultPlace_07);
        defaultPlace_08 = (ImageView)findViewById(R.id.mygarden_defaultPlace_08);
        defaultPlace_09 = (ImageView)findViewById(R.id.mygarden_defaultPlace_09);
        defaultPlace_10 = (ImageView)findViewById(R.id.mygarden_defaultPlace_10);

        //물뿌리개 버튼
        btn_wateringCan = (ImageButton)findViewById(R.id.mygarden_wateringCan);

        //초기화. 물뿌리개 수 up
        btn_init = (Button)findViewById(R.id.mygarden_init);
        btn_wateringCanUp = (Button)findViewById(R.id.mygarden_countUp);

        //물뿌리개 수 보여주는 text
        wateringCanNum = (TextView)findViewById(R.id.mygarden_wateringCanNum);

        /*

1. 인싸테스트가 끝나면 물뿌리개 저장
2. 물뿌리개 개수를 받아서 띄움
3. 물뿌리개를 누르면 물뿌리개 개수 -1개 해서 새로 저장
4. 성장도를 받음
5. 성장도에 따라 보이는 이미지가 다름

1. 물뿌리개 누른 개수가 10 이하일때 -> 이미지 디폴트 위치 0~9까지 새싹으로 바꿈
2. 물뿌리개 누른 개수가 11 이상일 때 -> 물뿌리개 개수 -11 위치는 꽃으로 바꿈
3. 물뿌리개를 눌렀을 때
	- 물뿌리개 누른 개수가 9 이하일 때 -> 물뿌리개 누른 개수 위치 새싹으로 바꿈+wateredCount+1 파일저장
	- 물뿌리개 누른 개수가 10이상일 때 -> 물뿌리개 누른 개수 위치 꽃으로 바꾸고+wateredCount+1 파일저장

         */

        /*
        1. wateringCan의 수를 불러온다
         */
        wateringCan = si.getInt(getApplicationContext(),"WatringCan");



        /*
        2. wateringCan의 개수를 TextView에 띄운다 (옆에 물뿌리개 총 몇번 눌렸는지도)
         */
        wateringCanNum.setText("물뿌리개 수"+wateringCan+"성장도"+wateredCount);

        /*
        3.리스트에 위치 정해주기 -> 리스트에 추가
         */
        addDefaultLocation();

        // 꽃 배치 설정
        setFlower();

        // 물뿌리개 버튼 클릭 시 물뿌리개 보유 개수 -1, 물뿌리개 눌린 횟수 +1. 꽃 다시 보여주기
        btn_wateringCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wateringCan -= 1;
                wateredCount += 1;
                si.setInt(getApplicationContext(), "WateringCan",wateringCan);
                si.setInt(getApplicationContext(), "Watered",wateredCount);
                setFlower();
            }
        });



    }//onCreate End---

    public void addDefaultLocation(){
        defaultPlace.add(defaultPlace_01);
        defaultPlace.add(defaultPlace_02);
        defaultPlace.add(defaultPlace_03);
        defaultPlace.add(defaultPlace_04);
        defaultPlace.add(defaultPlace_05);
        defaultPlace.add(defaultPlace_06);
        defaultPlace.add(defaultPlace_07);
        defaultPlace.add(defaultPlace_08);
        defaultPlace.add(defaultPlace_09);
        defaultPlace.add(defaultPlace_10);
    }

    // 꽃 배치해주는 함수
    public void setFlower(){
        wateredCount = si.getInt(getApplicationContext(),"Watered");

        // 꽃 배치 인덱스 설정
        if (wateredCount >= 10){
            defaultPlaceStartCount = wateredCount - 10;
            defaultPlaceEndCount = 10;
        }
        else{
            defaultPlaceStartCount = 0;
            defaultPlaceEndCount = wateredCount;
        }

        if (defaultPlaceStartCount != 0){
            for (int i = 0; i<defaultPlaceStartCount; i++){
                defaultPlace.get(i).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.main_farm_flower));//꽃 모양으로 바꿈
            }
        }
        for(int i=defaultPlaceStartCount; i<defaultPlaceEndCount; i++) {
            defaultPlace.get(i).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.main_farm_flower));//새싹모양 설정
        }
    }


}

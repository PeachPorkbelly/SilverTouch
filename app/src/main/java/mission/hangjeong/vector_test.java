package mission.hangjeong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;



/*********************
1. SavedInfo()를 통해 현재 물뿌리개와 성장도를 받아옵니다.
2. 성장도에 따라 보이는 이미지가 다름
3. 물뿌리개를 누르면 물뿌리개 개수 -1개 해서 새로 저장

1. 물뿌리개 누른 개수가 10 이하일때 -> 이미지 디폴트 위치 0~9까지 새싹으로 바꿈
2. 물뿌리개 누른 개수가 11 이상일 때 -> 물뿌리개 개수 -11 위치는 꽃으로 바꿈
3. 물뿌리개를 눌렀을 때
	- 물뿌리개 누른 개수가 9 이하일 때 -> 물뿌리개 누른 개수 위치 새싹으로 바꿈+wateredCount+1 파일저장
	- 물뿌리개 누른 개수가 10이상일 때 -> 물뿌리개 누른 개수 위치 꽃으로 바꾸고+wateredCount+1 파일저장
*********************/

public class vector_test extends AppCompatActivity {

    /*** 여기서부터 선언부입니다. ***/
    // 꽃의 이미지 뷰 이미지 패스를 탐색하기 위한 사전 선언문
    // 꽃 자라날 위치를 담은 리스트
    ArrayList<ImageView> defaultPlace = new ArrayList<>();
    //꽃 위치 ImageView의 id값을 int 배열로 저장하여 차후 사용. 이후 확장성이 좋습니다.
    int getDefaultPlace[] = {
            R.id.mygarden_defaultPlace_01,
            R.id.mygarden_defaultPlace_02,
            R.id.mygarden_defaultPlace_03,
            R.id.mygarden_defaultPlace_04,
            R.id.mygarden_defaultPlace_05,
            R.id.mygarden_defaultPlace_06,
            R.id.mygarden_defaultPlace_07,
            R.id.mygarden_defaultPlace_08,
            R.id.mygarden_defaultPlace_09,
            R.id.mygarden_defaultPlace_10
            // 뷰가 차후 늘어나거나 줄어들 경우, 여기서 배열 숫자만 조절하면 자연스럽게 수정되어 연결됩니다.
    };

    //물뿌리개 숫자에 관한 변수명
    //wateringCan 개수, wateringCan이 눌린 총 횟수
    int wateringCan, wateredCount;
    //초기화, 물뿌리개 수 up에 관한 버튼
    Button btn_init, btn_wateringCanUp;
    //물뿌리개 버튼
    ImageButton btn_wateringCan;
    //wateringCan 개수 보여줄 TextView
    TextView wateringCanNum;

    //SavedInfo를 si에 할당합니다.
    SavedInfo si = new SavedInfo();

    /*** 최초 실행시 실행되는 실행문. ***/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mygarden);

        //변수에 View를 연결시키는 코드
        //물뿌리개 버튼
        btn_wateringCan = (ImageButton)findViewById(R.id.mygarden_wateringCan);
        //초기화. 물뿌리개 수 up 버튼
        btn_init = (Button)findViewById(R.id.mygarden_init);
        btn_wateringCanUp = (Button)findViewById(R.id.mygarden_countUp);
        //물뿌리개 수 보여주는 TextView
        wateringCanNum = (TextView)findViewById(R.id.mygarden_wateringCanNum);
        //Array에 int형으로 저장된 ViewId를 ImageView로 연결하여 저장합니다.
        for(int i = 0; i < getDefaultPlace.length; i++){
            defaultPlace.add((ImageView) findViewById(getDefaultPlace[i]));
        }

        // 화면 초기화
        garden_refresh();

        // 버튼에 대한 구현
        // 물뿌리개 버튼 클릭 시 물뿌리개 보유 개수 -1, 물뿌리개 눌린 횟수 +1. 꽃 다시 보여주기
        btn_wateringCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wateringCan >= 1){
                    wateringCan -= 1;
                    wateredCount += 1;
                    save_setter();
                } else{
                    logs("물뿌리개 부족");
                }
                garden_refresh();
            }
        });
        // 초기화 버튼
        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                wateringCan = 0;
                wateredCount = 0;
                save_setter();
                garden_refresh();
            }
        });
        // 물뿌리개 추가 버튼
        btn_wateringCanUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                wateringCan++;
                save_setter();
                garden_refresh();
            }

        });



    }//onCreate End---

    /*** 각 함수에 관한 구현입니다. ***/

    // refresh가 필요한 경우 실행합니다.
    public void garden_refresh(){ // garden 내에서 refresh가 필요한 모든 동작을 여기서 처리합니다.
        wateringCan = si.getInt(getApplicationContext(),"WateringCan");
        wateredCount = si.getInt(getApplicationContext(),"Watered");
        // 물뿌리개 숫자 및 성장도 리프레시
        wateringCanNum.setText("물뿌리개 수"+wateringCan+"성장도"+wateredCount);

        setFlower();
    }

    // 수치가 변하는 경우, 이 함수를 호출하여 변한 값을 저장하도록 합니다.
    public void save_setter(){
        si.setInt(getApplicationContext(), "WateringCan",wateringCan);
        si.setInt(getApplicationContext(), "Watered",wateredCount);
    }


    // 꽃 배치해주는 함수
    // 이부분 나중에 수정해야 합니다.
    public void setFlower(){
        // defaultPlace Index때 쓸 변수
        int defaultPlaceStartCount, defaultPlaceEndCount;


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



    /*** 편의성을 위한 옵션 ***/
    // 로그 출력을 위한 함수
    public void logs(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        System.out.println(s);
    }
}

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

import org.w3c.dom.Text;

import static com.example.silvertouch.SavedInfo.getWateringCan;
import static com.example.silvertouch.SavedInfo.setWateringCan;
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
        꽃
         */

        /*
        1. wateringCan의 수를 불러온다
         */
        wateringCan = getWateringCan(getApplicationContext());

        /*
        2. wateringCan의 개수를 TextView에 띄운다 (옆에 물뿌리개 총 몇번 눌렸는지도)
         */
        wateringCanNum.setText("물뿌리개 수"+wateringCan+"성장도"+wateredCount);

        /*
        3.리스트에 위치 정해주기
         */
        adddefaultLocation();

        int b=3; //물뿌리개 클릭된 수

        for(int i=0; i<b; i++) {
            defaultPlace.get(i).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.main_farm_flower));
        }






    }//onCreate

    public void adddefaultLocation(){
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


}

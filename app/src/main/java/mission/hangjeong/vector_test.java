package mission.hangjeong;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.MainActivity;
import com.example.silvertouch.R;
import com.example.silvertouch.SavedInfo;
import java.util.ArrayList;
import java.util.Random;


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
    //꽃 위치 ImageView의 id값을 int 배열로 저장하여 차후 사용. 이후 확장성이 좋습니다.
    int[] getDefaultPlace = {
            R.id.mygarden_defaultPlace_00,
            R.id.mygarden_defaultPlace_01,
            R.id.mygarden_defaultPlace_02,
            R.id.mygarden_defaultPlace_03,
            R.id.mygarden_defaultPlace_04,
            R.id.mygarden_defaultPlace_05,
            R.id.mygarden_defaultPlace_06,
            R.id.mygarden_defaultPlace_07,
            R.id.mygarden_defaultPlace_08,
            R.id.mygarden_defaultPlace_09
            // 뷰가 차후 늘어나거나 줄어들 경우, 여기서 배열 숫자만 조절하면 자연스럽게 수정되어 연결됩니다.
    };
    int[][] flowerImageTable = {
            {
                    R.drawable.transparent_flower,
                    R.drawable.main_farm_seed_0000,
                    R.drawable.main_farm_flower,
                    R.drawable.main_farm_flower_0000
            },
            {
                    R.drawable.transparent_flower,
                    R.drawable.main_farm_seed_0001,
                    R.drawable.main_farm_flower,
                    R.drawable.main_farm_flower_0001
            },
            {
                    R.drawable.transparent_flower,
                    R.drawable.main_farm_seed_0002,
                    R.drawable.main_farm_flower,
                    R.drawable.main_farm_flower_0002
            },
            {
                    R.drawable.transparent_flower,
                    R.drawable.main_farm_seed_0003,
                    R.drawable.main_farm_flower,
                    R.drawable.main_farm_flower_0003
            }
    };
    String[] flowerNameTable = {
            "씨앗 이름 1",
            "씨앗 이름 2",
            "씨앗 이름 3",
            "씨앗 이름 4"
    };
    ImageButton[] btn_seeds = new ImageButton[4];

    // 꽃 자라날 위치를 담은 리스트
    ArrayList<flower> flowers = new ArrayList<>();
    //초기화, 물뿌리개 수 up에 관한 버튼
    Button btn_init, btn_wateringCanUp;
    //물뿌리개 버튼
    ImageButton btn_wateringCan;
    //wateringCan 개수 보여줄 TextView
    TextView wateringCanNum;


    //물뿌리개 숫자에 관한 변수명
    //wateringCan 개수, wateringCan이 눌린 총 횟수
    // 꽃밭 수
    int maxFlower;
    // 씨앗 종류
    int maxSeed;

    static UserInfo userInfo;
    //SavedInfo 를 si에 할당합니다.
    class UserInfo {
        int wateringCan;
        SavedInfo si = new SavedInfo();
        Context context;
        UserInfo(Context context){
            this.context = context;
            this.wateringCan = SavedInfo.getInt(this.context, "WateringCan");
        }

        public int getWateringCan() {
            return SavedInfo.getInt(this.context, "WateringCan");
        }

        public int popWateringCan() {
            if (this.wateringCan >= 1){
                setWateringCan(this.wateringCan - 1);
                return 1;
            }else{
                return 0;
            }
        }

        public void setWateringCan(int wateringCan) {
            this.wateringCan = wateringCan;
            SavedInfo.setInt(this.context, "WateringCan", this.wateringCan);
        }

        public int getGrowth(int place){
            return SavedInfo.getInt(this.context, "flower_growth_" + place);
        }

        public void setGrowth(int place, int growth){
            SavedInfo.setInt(this.context, "flower_growth_" + place, growth);
        }

        public int getKind(int place){
            return SavedInfo.getInt(this.context, "flower_kind_" + place);
        }

        public void setKind(int place, int kind){
            SavedInfo.setInt(this.context, "flower_kind_" + place, kind);
        }

        public int getSeed(int kind){
            return SavedInfo.getInt(this.context, "flower_seed_" + kind);
        }

        public int popSeed(int kind){
            if(getSeed(kind) >= 1){
                setSeed(kind, getSeed(kind) - 1);
                return 1;
            }else {
                return 0;
            }
        }

        public void setSeed(int kind, int many){
            SavedInfo.setInt(this.context, "flower_seed_" + kind, many);
        }

        // test
        public void addAll(){
            setWateringCan(getWateringCan() + 1);
            for (int i = 0; i < maxSeed; i++){
                setSeed(i, getSeed(i) + 1);
            }
        }
        public void clearnUp(){
            setWateringCan(0);
            for (int i = 0; i < maxSeed; i++){
                setSeed(i, 0);
            }
        }
    }

    class flower{
        private ImageView iv;
        private int place;
        private int growth = 0;
        private int kind = 0;
        flower(int place, int kind, int growth){    // 생성자
            this.place = place;
            this.iv = (ImageView)findViewById(getDefaultPlace[place]);
            this.growth = growth;
            this.kind = kind;
            if(this.growth >= 1){
                this.iv.setImageResource(flowerImageTable[this.kind][this.growth]);
            }
//            this.iv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(getGrowth() == 0){
//                        logs("성장도 0의 클릭 이벤트");
//                        AlertDialog.Builder dlg = new AlertDialog.Builder(vector_test.this);
//                        dlg.setTitle("씨앗 선택");
//                        String[] dlgSeeds = new String[flowerNameTable.length];
//                        for(int i = 0; i < flowerNameTable.length; i++){
//                            dlgSeeds[i] = flowerNameTable[i] + " : " + userInfo.getSeed(i) + "개";
//                        }
//                        dlg.setItems(dlgSeeds, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                if(userInfo.popSeed(which) == 1){
//                                    setKind(which);
//                                    setGrowth(1);
//                                }else{
//                                    logs("해당 씨앗이 없습니다.");
//                                }
//                            }
//                        });
//                        dlg.show();
//                    }
//                    else if (getGrowth() >= 1){
//                        logs("성장도 " + getGrowth() + "의 클릭 이벤트");
//                        if (getGrowth() <= 2){;
//                            if(userInfo.popWateringCan() == 1)
//                                setGrowth(getGrowth() + 1);
//                        }
//                    }
//                    else if(getGrowth() == 3){
//                        logs("성장도 3의 클릭 이벤트");
//                    }
//                    wateringCanNum.setText("물뿌리개 : " + userInfo.getWateringCan());
//                }
//            });
        }
        public int getKind() {
            return kind;
        }
        public void setKind(int kind) {
            this.kind = kind;
            userInfo.setKind(this.place, kind);
        }
        public int getGrowth() {
            return growth;
        }
        public void setGrowth(int growth) {
            this.growth = growth;
            userInfo.setGrowth(this.place, growth);
            changeImage(flowerImageTable[this.kind][this.growth]);
        }
        public void addGrowth(){
            setGrowth(getGrowth() + 1);
        }
        public int getPlace() {
            return place;
        }
        public UserInfo getUserInfo() {
            return userInfo;
        }
        // 특정 ImageView를 res로 이미지 변환하는 애니메이션
        private void changeImage(final int res){
            // 페이드 애니메이션
            Animation fadeOut = AnimationUtils.loadAnimation(vector_test.this, R.anim.image_fade_out);
            Animation fadeIn = AnimationUtils.loadAnimation(vector_test.this, R.anim.image_fade_in);

            // 페이드 아웃 애니메이션을 시작합니다.
            this.iv.startAnimation(fadeOut);

            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    //페이드 아웃 애니메이션이 끝나면 페이드 인 애니메이션을 시작합니다.
                    iv.setImageResource(res);
                    iv.startAnimation(fadeIn);
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    /*** 최초 실행시 실행되는 실행문. ***/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygarden);

        maxFlower = getDefaultPlace.length;
        maxSeed = flowerImageTable.length;
        userInfo = new UserInfo(vector_test.this);

        //변수에 View를 연결시키는 코드
        //초기화. 물뿌리개 수 up 버튼
        btn_init = (Button)findViewById(R.id.mygarden_init);
        btn_wateringCanUp = (Button)findViewById(R.id.mygarden_countUp);
        //물뿌리개 수 보여주는 TextView
        wateringCanNum = (TextView)findViewById(R.id.mygarden_wateringCanNum);
        btn_wateringCan = (ImageButton)findViewById(R.id.mygarden_wateringCan);

        wateringCanNum.setText("물뿌리개 : " + userInfo.getWateringCan());
        btn_seeds[0] = (ImageButton)findViewById(R.id.seed_0);
        btn_seeds[1] = (ImageButton)findViewById(R.id.seed_1);
        btn_seeds[2] = (ImageButton)findViewById(R.id.seed_2);
        btn_seeds[3] = (ImageButton)findViewById(R.id.seed_3);
        //Array 에 int 형으로 저장된 ViewId를 ImageView 로 연결하여 저장합니다.
        for(int i = 0; i < getDefaultPlace.length; i++){
            flowers.add(new flower(i, userInfo.getKind(i), userInfo.getGrowth(i)));
        }

        // 버튼에 대한 구현
        // 초기화 버튼
        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                userInfo.clearnUp();
                for(flower f: flowers){
                    f.setGrowth(0);
                    f.setKind(0);
                }
                wateringCanNum.setText("물뿌리개 : " + userInfo.getWateringCan());
            }
        });
        // 물뿌리개 및 씨앗들 추가 버튼
        btn_wateringCanUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                userInfo.addAll();
                wateringCanNum.setText("물뿌리개 : " + userInfo.getWateringCan());
            }
        });
        btn_wateringCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInfo.getWateringCan() >= 1){
                    ArrayList<flower> target= new ArrayList<>();
                    Random random = new Random();
                    for(flower f:flowers){
                        int g = f.getGrowth();
                        if(g >= 1 && g < 3){
                            target.add(f);
                        }
                    }
                    int l = target.size();
                    if (l >= 1){
                        flower f = target.get(random.nextInt(l));
                        f.setGrowth(f.getGrowth() + userInfo.popWateringCan());
                    }
                    wateringCanNum.setText("물뿌리개 : " + userInfo.getWateringCan());
                }
            }
        });
        View.OnClickListener seed_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ch;
                switch (v.getId()){
                    case R.id.seed_0:
                        ch = 0;
                        break;
                    case R.id.seed_1:
                        ch = 1;
                        break;
                    case R.id.seed_2:
                        ch = 2;
                        break;
                    case R.id.seed_3:
                        ch = 3;
                        break;
                    default:
                        ch = -1;
                        break;
                }
                if(userInfo.getSeed(ch) >= 1){
                    ArrayList<flower> target= new ArrayList<>();
                    Random random = new Random();
                    for(flower f:flowers){
                        if(f.getGrowth() == 0){
                            target.add(f);
                        }
                    }
                    int l = target.size();
                    if (l >= 1){
                        flower f = target.get(random.nextInt(l));
                        f.setKind(ch);
                        f.setGrowth(userInfo.popSeed(ch));
                    }
                }
            }
        };
        for(ImageButton b:btn_seeds){
            b.setOnClickListener(seed_listener);
        };



    }//onCreate End---

    /*** 각 함수에 관한 구현입니다. ***/

    // 수치가 변하는 경우, 이 함수를 호출하여 변한 값을 저장하도록 합니다.
    public void save_setter(){
//        si.setInt(getApplicationContext(), "WateringCan",wateringCan);
//        si.setInt(getApplicationContext(), "Watered",wateredCount);
    }


    // 꽃 배치해주는 함수
    // 이부분 나중에 수정해야 합니다.
    public void setFlower(){
        // defaultPlace Index때 쓸 변수
        int defaultPlaceStartCount, defaultPlaceEndCount;

//        wateredCount = si.getInt(getApplicationContext(),"Watered");
//
//        // 현재 wateredCount에 따라 애니메이션 여부가 결정됩니다.
//        // 마지막 watered에만 애니메이션이 출력되며, 나머지는 ImageDrawable만 변경됩니다.
//        for (int i = 0; i < maxFlower; i++){
//            if(wateredCount >= maxFlower + i + 2) {
//                defaultPlace.get(i).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.main_farm_flower_0000));//꽃 모양으로 바꿈
//            }else if(wateredCount == maxFlower + i + 1){
//                changeImage(defaultPlace.get(i), R.drawable.main_farm_flower_0000);
//            }else if (wateredCount >= i + 2){
//                defaultPlace.get(i).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.main_farm_flower));//새싹모양 설정
//            }else if (wateredCount == i + 1){
//                changeImage(defaultPlace.get(i), R.drawable.main_farm_flower);
//            }else{
//                defaultPlace.get(i).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.transparent_flower));//새싹모양 설정
//            }
//        }
    }

    /*** 편의성을 위한 옵션 ***/
    // 로그 출력을 위한 함수
    public void logs(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        System.out.println(s);
    }
}

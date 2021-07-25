package inssa_test;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.silvertouch.R;

import java.util.ArrayList;
import java.util.Random;

public class InsiderTestStart extends FragmentActivity {// AppCompatActivity --> FragmentActivity 로 바꿈
    // API 28이상이라면 Activity나 AppCompatActivity에서는 fragment를 사용할 수 없다

    // 변수 생성 부분 ------------
    public static ArrayList<InsiderQuestion> insiderQuestionList = new ArrayList<InsiderQuestion>();            // 문제들 리스트, 추후에 랜덤으로 문제 배열 설정
    public static ArrayList<InsiderQuestion> insiderQuestionAllList = new ArrayList<InsiderQuestion>();         // 모든 문제들 리스트
    public static InsiderQuestion nowQuestion;                                                    // 현재 문제 저장 변수
    public static int questionIndex, answerCount, wrongCount;                                     // questionIndex --> 몇번째 문제인지 저장하는 변수(0 부터 시작), answerCount --> 맞춘 정답 갯수, wrongCount --> 오답 갯수
    Random random = new Random();

    public static InsiderTestChoice2 insiderTestChoice2;
    public static InsiderTestChoice4 insiderTestChoice4;
    public static InsiderTestEnd insiderTestEnd;

    // --------------------- 변수 생성 끝

    // 인싸테스트 문제 클래스
    public class InsiderQuestion {

        // questionStr --> 문제
        // choice1~4 --> 보기
        // answer --> 정답
        // 생성자 단에서 데이터 넣고, 문제 불러올때 getter 메소드 사용

        public static final int MODE_CHOICE_4 = 0;
        public static final int MODE_CHOICE_2 = 1;

        private String questionStr;
        private Drawable choice1, choice2, choice3, choice4;
        private int answer;
        private int mode;


        // Insider question 생성자 (4지선다)
        public InsiderQuestion(String questionStr, Drawable choice1, Drawable choice2, Drawable choice3, Drawable choice4, int answer){
            this.questionStr = questionStr;
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = choice3;
            this.choice4 = choice4;
            this.answer = answer;
            this.mode = MODE_CHOICE_4;
        }

        // Insider question 생성자 (2지선다) Overloading
        public InsiderQuestion(String questionStr, Drawable choice1, Drawable choice2, int answer){
            this.questionStr = questionStr;
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.mode = MODE_CHOICE_2;
        }
        
        // getter 메소드
        public String getQuestionStr(){
            return questionStr;
        }

        public Drawable getChoice1(){
            return choice1;
        }

        public Drawable getChoice2(){
            return choice2;
        }

        public Drawable getChoice3(){
            return choice3;
        }

        public Drawable getChoice4(){
            return choice4;
        }

        public int getAnswer(){
            return answer;
        }

        public int getMode(){
            return mode;
        }

    }

    // Fragment 실행
    public void runFragment(){
        nowQuestion = insiderQuestionList.get(questionIndex);
        if (nowQuestion.getMode() == InsiderQuestion.MODE_CHOICE_2) {
            /* MODE_CHOICE_2 */
            insiderTestChoice2 = new InsiderTestChoice2();
            // Fragment 실행
            getSupportFragmentManager().beginTransaction().replace(R.id.insider_framelayout, insiderTestChoice2).commit();


        } else if (nowQuestion.getMode() == InsiderQuestion.MODE_CHOICE_4) {
            /* MODE_CHOICE_4 */
            insiderTestChoice4 = new InsiderTestChoice4();
            // Fragment 실행
            getSupportFragmentManager().beginTransaction().replace(R.id.insider_framelayout, insiderTestChoice4).commit();
        }
    }

    // 문제 객체 생성 및 List 추가 - MODE 4
    public void addQuestion_choice4(String question, Drawable choice1, Drawable choice2, Drawable choice3, Drawable choice4, int answer){
        InsiderQuestion insiderQuestion = new InsiderQuestion(question,choice1, choice2, choice3, choice4, answer); // 문제 객체 생성
        insiderQuestionAllList.add(insiderQuestion);                                                              // 생성된 문제 객체 리스트에 추가
    }

    // 문제 객체 생성 및 List 추가 - MODE 2
    public void addQuestion_choice2(String question, Drawable choice1, Drawable choice2, int answer){
        InsiderQuestion insiderQuestion = new InsiderQuestion(question, choice1, choice2, answer);
        insiderQuestionAllList.add(insiderQuestion);
    }

    // 랜덤으로 문제 10개 뽑기
    public void randomQuestionSelect(){
        int randomNumber;

        while (insiderQuestionList.size() < 10){
            randomNumber = random.nextInt(insiderQuestionAllList.size());
            if (insiderQuestionList.contains(insiderQuestionAllList.get(randomNumber))){    // 중복된 문제를 뽑았을 때
                continue;
            } else {
                insiderQuestionList.add(insiderQuestionAllList.get(randomNumber));
            }
        }
    }

    // All 리스트에 문제 추가 메소드
    public void first_run(){
        // 혹시 모를 버그 방지, 리스트 초기화
        insiderQuestionList.clear();
        insiderQuestionAllList.clear();

        // 인싸테스트 문제 추가 -----
        addQuestion_choice4("다음 중 뒤로가기 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_back),
                ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_menu),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock), 1);

        addQuestion_choice4("다음 중 와이파이 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 3);

        addQuestion_choice4("다음 중 홈 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight),
                ContextCompat.getDrawable(this, R.drawable.insider_bluetooth), 2);

        addQuestion_choice4("다음 중 메뉴 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_menu),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 1);

        addQuestion_choice4("다음 중 검색 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_back),
                ContextCompat.getDrawable(this, R.drawable.insider_home), 2);

        addQuestion_choice4("다음 중 새로고침 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_menu),
                ContextCompat.getDrawable(this, R.drawable.insider_wifi), 1);

        addQuestion_choice4("다음 중 설정 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock),
                ContextCompat.getDrawable(this, R.drawable.insider_bluetooth),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 4);

        addQuestion_choice4("다음 중 화면 고정 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock), 4);

        addQuestion_choice4("다음 중 화면 회전 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_menu), 3);

        addQuestion_choice4("다음 중 손전등 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 3);

        // 테스트용 문제 MODE2 -----
        addQuestion_choice2("다음 중 새로고침 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                 1);

        addQuestion_choice2("다음 중 설정 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 2);

        addQuestion_choice2("다음 중 화면 고정 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock), 2);

        addQuestion_choice2("다음 중 화면 회전 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation), 2);

        addQuestion_choice2("다음 중 손전등 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight), 2);
        // ----- END ------



    }

    /* Main Code */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insider_test_start);

        if (questionIndex != 0){
            questionIndex = 0;
        }

        answerCount = 0;    // 맞춘 정답 갯수 변수 초기화
        wrongCount = 0;     // 틀린 문제 갯수 변수 초기화

        // 문제 ALL 리스트에 추가
        first_run();

        // 랜덤으로 10개 문제 뽑기
        randomQuestionSelect();

        // Fragment 실행
        runFragment();

    }
    // Main End-----------

}
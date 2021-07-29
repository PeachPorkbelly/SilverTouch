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
    public static ArrayList<Drawable> insiderQuestionOrderList = new ArrayList<>();
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

        private Drawable questionTitle, choice1, choice2, choice3, choice4;
        private int answer;
        private int mode;


        // Insider question 생성자 (4지선다)
        public InsiderQuestion(Drawable questionTitle, Drawable choice1, Drawable choice2, Drawable choice3, Drawable choice4, int answer){
            this.questionTitle = questionTitle;
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = choice3;
            this.choice4 = choice4;
            this.answer = answer;
            this.mode = MODE_CHOICE_4;
        }

        // Insider question 생성자 (2지선다) Overloading
        public InsiderQuestion(Drawable questionTitle, Drawable choice1, Drawable choice2, int answer){
            this.questionTitle = questionTitle;
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.answer = answer;
            this.mode = MODE_CHOICE_2;
        }
        
        // getter 메소드
        public Drawable getQuestionTitle(){
            return questionTitle;
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
    public void addQuestion_choice4(Drawable question, Drawable choice1, Drawable choice2, Drawable choice3, Drawable choice4, int answer){
        InsiderQuestion insiderQuestion = new InsiderQuestion(question,choice1, choice2, choice3, choice4, answer); // 문제 객체 생성
        insiderQuestionAllList.add(insiderQuestion);                                                              // 생성된 문제 객체 리스트에 추가
    }

    // 문제 객체 생성 및 List 추가 - MODE 2
    public void addQuestion_choice2(Drawable question, Drawable choice1, Drawable choice2, int answer){
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

    public void setQuestionOrderDrawable() {
        if (insiderQuestionOrderList.size() == 10) {

            return;

        } else {

            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t01));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t02));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t03));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t04));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t05));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t06));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t07));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t08));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t09));
            insiderQuestionOrderList.add(ContextCompat.getDrawable(this, R.drawable.inssatest_t10));

        }
    }

    // All 리스트에 문제 추가 메소드
    public void first_run(){
        // 혹시 모를 버그 방지, 리스트 초기화
        insiderQuestionList.clear();
        insiderQuestionAllList.clear();

        // 인싸테스트 문제 추가
        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q01),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_wifi),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_data),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q02),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q02_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q02_answer_wrong),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q03),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q03_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q03_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q04),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q04_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q04_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q05),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q05_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q05_answer_wrong),
                1);

        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q06),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu3),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_refresh),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu2),
                3);

        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q07),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_setting),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_search),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_fixedscreen1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_back),
                4);

        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q08),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_back),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_refresh),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_screenrotation),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_search),
                4);



        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q09),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_screenrotation),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_home),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_search),
                3);



        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q10),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_fixedscreen2),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_setting),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_refresh),
                1);


        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q11),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_search),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu3),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_wifi1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_fixedscreen1),
                4);


        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q12),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_home),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu3),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_data1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_refresh),
                3);


        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q13),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_search),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_back),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_refresh),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_setting),
                3);

        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q14),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_setting),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_screenrotation),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_fixedscreen1),
                2);

        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q15),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_search),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_comment),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_refresh),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_screenrotation),
                4);

        addQuestion_choice4(ContextCompat.getDrawable(this, R.drawable.inssatest_q16),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_fixedscreen1),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_menu2),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_back),
                ContextCompat.getDrawable(this, R.drawable.inssatest_answer_icon_setting),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q17),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q17_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q17_answer_wrong),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q18),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q18_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q18_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q19),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q19_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q19_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q20),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q20_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q20_answer_wrong),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q21),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q21_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q21_answer_wrong),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q22),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q22_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q22_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q23),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q23_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q23_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q24),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q24_answer_wrong),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q24_answer_right),
                2);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q25),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q25_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q25_answer_wrong),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q26),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q26_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q26_answer_wrong),
                1);

        addQuestion_choice2(ContextCompat.getDrawable(this, R.drawable.inssatest_q27),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q26_answer_right),
                ContextCompat.getDrawable(this, R.drawable.inssatest_q26_answer_wrong),
                2);




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

        // 문제 번호 Drawable 리스트에 추가
        setQuestionOrderDrawable();

        // 문제 ALL 리스트에 추가
        first_run();

        // 랜덤으로 10개 문제 뽑기
        randomQuestionSelect();

        // Fragment 실행
        runFragment();

    }
    // Main End-----------

}
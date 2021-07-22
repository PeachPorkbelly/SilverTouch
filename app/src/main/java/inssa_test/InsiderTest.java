package inssa_test;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.silvertouch.R;

import java.util.ArrayList;
import java.util.Random;

public class InsiderTest extends AppCompatActivity {

    private ArrayList<InsiderQuestion> insiderQuestionList = new ArrayList<InsiderQuestion>();            // 문제들 리스트, 추후에 랜덤으로 문제 배열 설정
    private ArrayList<InsiderQuestion> insiderQuestionAllList = new ArrayList<InsiderQuestion>();         // 모든 문제들 리스트
    InsiderQuestion nowQuestion;                                                            // 현재 문제 저장 변수
    int questionIndex, answerCount;                                                         // questionIndex --> 몇번째 문제인지 저장하는 변수(0 부터 시작), answerCount --> 맞춘 정답 갯수
    ImageButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;                 // 객관식 문제 보기
    TextView questionNumberView, questionStrView;   // questionNumberView --> 몇번째 문제, questionStrView -->  문제
    Random random = new Random();

    // 인싸테스트 문제 클래스
    public class InsiderQuestion{

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

    // 문제 보여주는 메소드
    public void setQuestion(int questionIndex, InsiderQuestion insiderQuestion){
        nowQuestion = insiderQuestionList.get(questionIndex);

        questionNumberView.setText((questionIndex+1) + "번째 문제"); // 인덱스는 0부터 시작하기 때문에 +1 해줘야 함
        questionStrView.setText(insiderQuestion.getQuestionStr());
        choiceButton1.setImageDrawable(insiderQuestion.getChoice1());
        choiceButton2.setImageDrawable(insiderQuestion.getChoice2());
        choiceButton3.setImageDrawable(insiderQuestion.getChoice3());
        choiceButton4.setImageDrawable(insiderQuestion.getChoice4());

    }

    // 문제 객체 생성 및 List 추가
    public void addQuestion(String question, Drawable choice1, Drawable choice2, Drawable choice3, Drawable choice4, int answer){
        InsiderQuestion insiderQuestion = new InsiderQuestion(question,choice1, choice2, choice3, choice4, answer); // 문제 객체 생성
        insiderQuestionAllList.add(insiderQuestion);                                                              // 생성된 문제 객체 리스트에 추가
    }

    // 객관식 보기 클릭시 실행되는 메소드
    public void choiceBtnClicked(int choiceNumber){
        if (nowQuestion.getAnswer() == choiceNumber){  // 정답여부 체크
            answerCount += 1;   // 정답 카운트 증가
            questionIndex += 1; // 다음 문제 설정

            if (questionIndex > 10){
                /* 10문제 진행 했을 시 인싸테스트 종료 설정 */
                insiderQuestionList.clear();
                insiderQuestionAllList.clear();
                finish();
            }

            setQuestion(questionIndex, insiderQuestionList.get(questionIndex)); // 다음 문제 넘어가는 메소드
        } else{
            /* 틀렸을 경우 조치하는 메소드*/

        }
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

    public void first_run(){

        // 인싸테스트 문제 추가 -----
        addQuestion("다음 중 뒤로가기 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_back),
                ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_menu),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock), 1);

        addQuestion("다음 중 와이파이 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 3);

        addQuestion("다음 중 홈 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight),
                ContextCompat.getDrawable(this, R.drawable.insider_bluetooth), 2);

        addQuestion("다음 중 메뉴 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_menu),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 1);

        addQuestion("다음 중 검색 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_back),
                ContextCompat.getDrawable(this, R.drawable.insider_home), 2);

        addQuestion("다음 중 새로고침 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_menu),
                ContextCompat.getDrawable(this, R.drawable.insider_wifi), 1);

        addQuestion("다음 중 설정 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock),
                ContextCompat.getDrawable(this, R.drawable.insider_bluetooth),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 4);

        addQuestion("다음 중 화면 고정 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_home),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock), 4);

        addQuestion("다음 중 화면 회전 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_refresh),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_lock),
                ContextCompat.getDrawable(this, R.drawable.insider_screen_rotation),
                ContextCompat.getDrawable(this, R.drawable.insider_menu), 3);

        addQuestion("다음 중 손전등 아이콘은 무엇일까요?", ContextCompat.getDrawable(this, R.drawable.insider_wifi),
                ContextCompat.getDrawable(this, R.drawable.insider_search),
                ContextCompat.getDrawable(this, R.drawable.insider_flashlight),
                ContextCompat.getDrawable(this, R.drawable.insider_settings), 3);

    }

    /* Main Code */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insider_test_choice_4);

        answerCount = 0;    // 맞춘 정답 갯수 변수 초기화
        questionIndex = 0;  // 문제 번호 변수 초기화

        // 문제 ALL 리스트에 추가
        first_run();

        // 랜덤으로 10개 문제 뽑기
        randomQuestionSelect();

        // xml 연결
        questionNumberView = (TextView) findViewById(R.id.insider_order_mode_4);
        questionStrView = (TextView) findViewById(R.id.insider_question_mode_4);
        choiceButton1 = (ImageButton) findViewById(R.id.insider_choice_1_mode_4);
        choiceButton2 = (ImageButton) findViewById(R.id.insider_choice_2_mode_4);
        choiceButton3 = (ImageButton) findViewById(R.id.insider_choice_3_mode_4);
        choiceButton4 = (ImageButton) findViewById(R.id.insider_choice_4_mode_4);

        // 이미지 버튼 작동
        choiceButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceBtnClicked(1);
            }
        });

        choiceButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceBtnClicked(2);
            }
        });

        choiceButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceBtnClicked(3);
            }
        });

        choiceButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceBtnClicked(4);
            }
        });

        setQuestion(questionIndex, insiderQuestionList.get(questionIndex));

    }

}
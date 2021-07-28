package inssa_test;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.silvertouch.R;

import static inssa_test.InsiderTestStart.insiderQuestionOrderList;
import static inssa_test.InsiderTestStart.insiderTestChoice2;
import static inssa_test.InsiderTestStart.insiderTestChoice4;
import static inssa_test.InsiderTestStart.insiderTestEnd;
import static inssa_test.InsiderTestStart.nowQuestion;
import static inssa_test.InsiderTestStart.questionIndex;
import static inssa_test.InsiderTestStart.answerCount;
import static inssa_test.InsiderTestStart.wrongCount;
import static inssa_test.InsiderTestStart.insiderQuestionList;



public class InsiderTestChoice4 extends Fragment {
    // 변수 선언
    View view;
    ImageView questionOrder, questionTitle;
    ImageButton choiceButton1, choiceButton2, choiceButton3, choiceButton4, exitButton;

    // 변수 선언 끝

    // 생성자
    public InsiderTestChoice4(){

    }

    // Fragment 화면 전환
    public void runFragment(){
        if (questionIndex < 10) {
            nowQuestion = insiderQuestionList.get(questionIndex);
            if (nowQuestion.getMode() == InsiderTestStart.InsiderQuestion.MODE_CHOICE_2) {
                /* MODE_CHOICE_2 */
                insiderTestChoice2 = new InsiderTestChoice2();
                // Fragment 실행
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.insider_framelayout, insiderTestChoice2).commit();

            } else if (nowQuestion.getMode() == InsiderTestStart.InsiderQuestion.MODE_CHOICE_4) {
                /* MODE_CHOICE_4 */
                insiderTestChoice4 = new InsiderTestChoice4();
                // Fragment 실행
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.insider_framelayout, insiderTestChoice4).commit();
            }
        } else if (questionIndex == 10){
            insiderTestEnd = new InsiderTestEnd();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.insider_framelayout, insiderTestEnd).commit();
        }
    }

    public void setQuestion(){

        questionOrder.setImageDrawable(insiderQuestionOrderList.get(questionIndex));
        questionTitle.setImageDrawable(nowQuestion.getQuestionTitle());
        choiceButton1.setImageDrawable(nowQuestion.getChoice1());
        choiceButton2.setImageDrawable(nowQuestion.getChoice2());
        choiceButton3.setImageDrawable(nowQuestion.getChoice3());
        choiceButton4.setImageDrawable(nowQuestion.getChoice4());
    }

    public void choiceBtnClicked(int choiceNumber){
        if (questionIndex < 10) {
            if (nowQuestion.getAnswer() == choiceNumber) {  // 정답여부 체크
                answerCount += 1;   // 정답 카운트 증가

            } else {
                wrongCount += 1;
            }
            questionIndex += 1; // 다음 문제 설정
            runFragment();
            getActivity().getSupportFragmentManager().beginTransaction().remove(InsiderTestChoice4.this).commit();
        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.inssatest_choice_4, container, false);

        // xml 연동
        questionOrder = (ImageView) view.findViewById(R.id.inssatest_choice4_questionOrder);
        questionTitle = (ImageView) view.findViewById(R.id.inssatest_choice4_questionTitle);
        choiceButton1 = (ImageButton) view.findViewById(R.id.inssatest_choice4_answer01);
        choiceButton2 = (ImageButton) view.findViewById(R.id.inssatest_choice4_answer02);
        choiceButton3 = (ImageButton) view.findViewById(R.id.inssatest_choice4_answer03);
        choiceButton4 = (ImageButton) view.findViewById(R.id.inssatest_choice4_answer04);
        exitButton = (ImageButton) view.findViewById(R.id.inssatest_choice4_exit);
        
        // 문제 설정
        setQuestion();

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

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });


        return view;//super.onCreateView(inflater, container, savedInstanceState);
    }
}

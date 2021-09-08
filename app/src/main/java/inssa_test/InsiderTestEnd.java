package inssa_test;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.silvertouch.R;

import static inssa_test.InsiderTestStart.answerCount;
import static inssa_test.InsiderTestStart.questionIndex;
import static inssa_test.InsiderTestStart.wrongCount;
import static com.example.silvertouch.SavedInfo.getInt;
import static com.example.silvertouch.SavedInfo.setInt;

public class InsiderTestEnd extends Fragment {
    View view;
    TextView answerText, wrongText;
    Button exit;

    public InsiderTestEnd(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.insider_test_end, container, false);
        answerText = (TextView) view.findViewById(R.id.answertext);
        wrongText = (TextView) view.findViewById(R.id.wrongtext);

        exit = (Button) view.findViewById(R.id.exitinsidertest);

        answerText.setText("정답 : " + answerCount + "개");
        wrongText.setText("오답 : " + wrongCount + "개");

        // 문제 초기화
        questionIndex = 0;


        //물뿌리개 주고 + 이미지 띄우기
        if (answerCount>=8) {
            int wateringCan = getInt(getContext(),"WateringCan");
            setInt(container.getContext(),"WateringCan",wateringCan+1);

            // 이미지 토스트 부분
            ImageView iv = new ImageView(container.getContext());
            iv.setImageResource(R.drawable.mission_hangjeong_confirm);

            Toast toast = Toast.makeText(container.getContext(), "InsiderTestEnd",Toast.LENGTH_SHORT);
            toast.setView(iv);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            // -- 이미지 토스트 end --
        }else{
            Toast.makeText(container.getContext(),"아쉽게도 물뿌리개를 얻지 못했습니다",Toast.LENGTH_SHORT).show();
        }




        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // InsiderTestStart Activity를 종료
                getActivity().finish();
            }
        });




        return view;
    }
}

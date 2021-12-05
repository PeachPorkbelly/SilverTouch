package inssa_test;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import com.example.silvertouch.R;

import static inssa_test.InsiderTestStart.answerCount;
import static inssa_test.InsiderTestStart.questionIndex;
import static inssa_test.InsiderTestStart.wrongCount;
import static com.example.silvertouch.SavedInfo.getInt;
import static com.example.silvertouch.SavedInfo.setInt;

public class InsiderTestEnd extends Fragment {

    View view;
    TextView answerText;
    ImageView over80, under80;
    ImageButton exit, replay;
    Intent intent;


    public InsiderTestEnd(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.insider_test_end, container, false);
        answerText = (TextView) view.findViewById(R.id.answertext);

        //wrongText = (TextView) view.findViewById(R.id.wrongtext);

        exit = (ImageButton) view.findViewById(R.id.cardend_exit);
        replay = (ImageButton) view.findViewById(R.id.cardend_replay);

        answerText.setText(answerCount*10 + "점");
        //wrongText.setText("오답 : " + wrongCount + "개");

        // 문제 초기화
        questionIndex = 0;


        //물뿌리개 주고 + 이미지 띄우기
        if (answerCount>=8) {
            int wateringCan = getInt(getContext(),"WateringCan");
            setInt(container.getContext(),"WateringCan",wateringCan+1);


            ImageView iv = new ImageView(container.getContext());
            iv.setImageResource(R.drawable.cardend_over80);

            Toast toast = Toast.makeText(container.getContext(), "InsiderTestEnd",Toast.LENGTH_LONG);
            toast.setView(iv);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


        }else{

            ImageView iv = new ImageView(container.getContext());
            iv.setImageResource(R.drawable.cardend_under80);

            Toast toast = Toast.makeText(container.getContext(), "InsiderTestEnd",Toast.LENGTH_LONG);
            toast.setView(iv);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // InsiderTestStart Activity를 종료
                getActivity().finish();
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), InsiderTestStart.class);
                startActivity(intent);
            }
        });


        return view;
    }

}

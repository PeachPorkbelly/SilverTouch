package card_maker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.silvertouch.R;

public class card_main extends AppCompatActivity {

    ImageView card_image;
    Button btn_left, btn_right, btn_close, btn_emoji, btn_clear, btn_ok;

    int bgmax = 10;
    int[] card_bg = new int[bgmax];
    int nowbg = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_main);

        card_image = (ImageView) findViewById(R.id.card_image);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_emoji = (Button) findViewById(R.id.btn_emoji);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_ok = (Button) findViewById(R.id.btn_ok);

        card_bg[0] = R.drawable.card_child;
        card_bg[1] = R.drawable.card_family;
        card_bg[2] = R.drawable.card_friend;
        card_bg[3] = R.drawable.card_happiness;
        card_bg[4] = R.drawable.card_health;
        card_bg[5] = R.drawable.card_love;
        card_bg[6] = R.drawable.card_morning;
        card_bg[7] = R.drawable.card_smile;
        card_bg[8] = R.drawable.card_wish;
        card_bg[9] = R.drawable.card_iflockedclicked;

        card_image.setImageResource(card_bg[nowbg]);

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowbg == 0){
                    nowbg = bgmax;
                }
                else{
                    nowbg--;
                }
                card_image.setImageResource(card_bg[nowbg]);
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowbg + 1 == bgmax){
                    nowbg = 0;
                }
                else{
                    nowbg++;
                }
                card_image.setImageResource(card_bg[nowbg]);
            }
        });
    }
}

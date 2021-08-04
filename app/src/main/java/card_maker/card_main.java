package card_maker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.silvertouch.R;

public class card_main extends AppCompatActivity {

    ImageView card_image;
    Button btn_left, btn_right, btn_close, btn_emoji, btn_clear, btn_ok;

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
    }
}

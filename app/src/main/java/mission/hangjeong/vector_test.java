package mission.hangjeong;

import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Display;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

public class vector_test extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vector_test);

        Display display = getWindowManager().getDefaultDisplay();  // in Activity
        /* getActivity().getWindowManager().getDefaultDisplay() */ // in Fragment
        Point size = new Point();
        display.getSize(size); // or getSize(size)
        int width = size.x;
        int height = size.y;

        TextView text = (TextView)findViewById(R.id.textView3);
        text.setText(width+"*"+height);
    }
}

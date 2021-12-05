package school;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.R;

import java.util.ArrayList;

public class SchoolMain extends AppCompatActivity {

    EngList engList;
    Intent intent;
    ImageButton exit;
    String selectedBook;
    ArrayList<String> engBook = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.school_main);

        //변수와 아이디 연결
        selectedBook = getIntent().getExtras().getString("selectedBook");
        exit = (ImageButton)findViewById(R.id.school_main_exit);


        //어떤 책을 눌렀는지에 따라서 다른 책이 들어간다~!
        if(selectedBook.equals("kiosk")){
            engList = new EngList("kiosk");
            engBook = engList.kioskBook;
            //engAudio = engList.kioskAudio;

        }else if(selectedBook.equals("it")){
            engList = new EngList("it");
            engBook = engList.itBook;
        }else if(selectedBook.equals("daily")){
            engList = new EngList("daily");
            engBook = engList.everydayBook;
        }

        ListView listView = (ListView) findViewById(R.id.school_main_listview);
        final SchoolAdapter schoolAdapter = new SchoolAdapter(this,engBook);
        listView.setAdapter(schoolAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //AUDIO 리스트의 POSITION 인덱스에 있는 미디어를 플레이
                //MediaPlayer mp =
            }
        });


    }
}

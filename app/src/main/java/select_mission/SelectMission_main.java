package select_mission;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.MissionList;
import com.example.silvertouch.R;

import java.util.ArrayList;

public class SelectMission_main extends AppCompatActivity {

    MissionList ml;
    Intent intent;
    ImageButton exit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ml = new MissionList();
        exit = (ImageButton)findViewById(R.id.select_mission_hangjeong_exit);

        //수정필요(hangjeong 빼기)
        setContentView(R.layout.select_mission_hangjeong);

        ListView listView = (ListView)findViewById(R.id.missionList_listview);
        final SelectMission_Adapter selectMission_adapter = new SelectMission_Adapter(this,ml.missionTitleHJ);

        listView.setAdapter(selectMission_adapter);

        //https://lktprogrammer.tistory.com/163
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getApplicationContext(),ml.missionListHJ.get(position));
                startActivity(intent);
            }
        });

        /*
        //닫기 버튼튼
       exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),com.example.silvertouch.MainActivity.class);
                startActivity(intent);
            }
        });

         */
    }
}

package select_mission;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.silvertouch.MissionList;
import com.example.silvertouch.R;

import java.util.ArrayList;

public class SelectMission_main extends AppCompatActivity {

    MissionList ml;
    Intent intent;
    ImageButton exit;
    String selectedPlace;
    ImageView title;
    ArrayList<Class> missions = new ArrayList<>();
    ArrayList<String> missionTitle = new ArrayList<>();
    //TextView text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_mission_main);


        title = findViewById(R.id.select_mission_title);
        ml = new MissionList();
        selectedPlace = getIntent().getExtras().getString("selectedPlace");
        exit = (ImageButton)findViewById(R.id.select_mission_hangjeong_exit);
        //text = (TextView)findViewById(R.id.select_mission_text);


        if (selectedPlace.equals("hangjeong")){
            missionTitle = ml.missionTitleHJ;
            missions = ml.missionListHJ;
            title.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.select_mission_hangjeong_title));
        }else if (selectedPlace.equals("burger")){
            missionTitle = ml.missionTitleBG;
            missions = ml.missionListBG;
            title.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.select_mission_bg_title));
        }

        ListView listView = (ListView)findViewById(R.id.missionList_listview);
        final SelectMission_Adapter selectMission_adapter = new SelectMission_Adapter(this,missionTitle);
        listView.setAdapter(selectMission_adapter);

        //https://lktprogrammer.tistory.com/163
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getApplicationContext(), missions.get(position));
                startActivity(intent);
            }
        });

    }
}

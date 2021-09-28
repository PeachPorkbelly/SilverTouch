package select_mission;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.silvertouch.MissionList;
import com.example.silvertouch.R;

import java.util.ArrayList;

public class SelectMission_main extends AppCompatActivity {

    MissionList ml;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ml = new MissionList();
        //수정필요(hangjeong 빼기)
        setContentView(R.layout.select_mission_hangjeong);

        ListView listView = (ListView)findViewById(R.id.missionList_listview);
        final SelectMission_Adapter selectMission_adapter = new SelectMission_Adapter(this,ml.missionTitleHJ);

        //https://lktprogrammer.tistory.com/163
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}

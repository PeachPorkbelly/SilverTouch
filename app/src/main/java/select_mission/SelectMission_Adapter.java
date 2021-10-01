package select_mission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.silvertouch.R;

import java.util.ArrayList;

public class SelectMission_Adapter extends BaseAdapter {

    Context context;
    ArrayList<String> missionTitle;
    LayoutInflater layoutInflater = null;

    //생성자에 불러올 미션 타이틀이 들어있는 어레이 리스트를 매개변수로 줌
    public SelectMission_Adapter(Context context, ArrayList<String> missionTitle){
        this.context = context;
        this.missionTitle = missionTitle;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return missionTitle.size();
    }

    @Override
    public Object getItem(int position) {
        return missionTitle.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.select_mission_litems, parent, false);
        }

        TextView mText = (TextView)convertView.findViewById(R.id.select_mission_text);
        mText.setText(this.missionTitle.get(position));

        return convertView;


    }
}

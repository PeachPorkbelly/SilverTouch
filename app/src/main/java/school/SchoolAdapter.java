package school;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.silvertouch.R;

import java.util.ArrayList;

public class SchoolAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> engBook;
    LayoutInflater layoutInflater = null;

    public SchoolAdapter(Context context, ArrayList<String> engBook){
        this.context = context;
        this.engBook = engBook;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return engBook.size();
    }

    @Override
    public Object getItem(int position) {
        return engBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.school_items, parent, false);
        }

        TextView mText = (TextView)convertView.findViewById(R.id.school_items_text);
        mText.setText(this.engBook.get(position));

        return convertView;
    }
}

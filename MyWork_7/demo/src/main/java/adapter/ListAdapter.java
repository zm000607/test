package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

import java.util.ArrayList;

import bean.WeChatBean;
import view.ItemView;

public class ListAdapter extends BaseAdapter {
    private ArrayList<WeChatBean> list;
    private Context context;

    public ListAdapter(ArrayList<WeChatBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<WeChatBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout_wechatitem, null);
        if (convertView!=null){

            ImageView iv = convertView.findViewById(R.id.iv);
            TextView title = convertView.findViewById(R.id.title);
            TextView name = convertView.findViewById(R.id.name);
            TextView time = convertView.findViewById(R.id.time);
            Glide.with(convertView).load(list.get(position).getPicUrl()).into(iv);
            title.setText(list.get(position).getTitle());
            name.setText(list.get(position).getDescription());
            time.setText(list.get(position).getCtime());
        }
        return convertView;
    }

}

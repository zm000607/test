package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

import java.util.ArrayList;

import bean.DailyBean;

public class MyXlvAd extends RecyclerView.Adapter<MyXlvAd.ViewHolder> {
    private ArrayList<DailyBean> list;
    private Context context;

    public MyXlvAd(ArrayList<DailyBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<DailyBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        DailyBean storiesBean = list.get(i);
        holder.desc.setText(storiesBean.getTitle());
        holder.title.setText(storiesBean.getGa_prefix());
        Glide.with(context).load(storiesBean.getImages().get(0)).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
        }
    }
}

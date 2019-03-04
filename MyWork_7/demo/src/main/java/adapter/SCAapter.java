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

import bean.SCBean;

public class SCAapter extends RecyclerView.Adapter<SCAapter.ViewHolder> {
    private ArrayList<SCBean> list;
    private Context context;

    public SCAapter(ArrayList<SCBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<SCBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_citem, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        SCBean storiesBean = list.get(i);
        holder.name.setText(storiesBean.getName());
        holder.desc.setText(storiesBean.getDescription());
        Glide.with(context).load(storiesBean.getThumbnail()).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.OnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView name;
        private TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            name=itemView.findViewById(R.id.name);
            desc=itemView.findViewById(R.id.desc);
        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void OnClick(int position);
    }
}

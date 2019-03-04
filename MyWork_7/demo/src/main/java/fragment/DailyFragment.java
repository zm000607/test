package fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demo.R;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adapter.MyXlvAd;
import bean.DailyBean;
import presenter.ItemP;
import view.ItemView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends Fragment implements ItemView {


    private XRecyclerView rv;
    private ArrayList<DailyBean> list;
    private MyXlvAd myXlvAd;
    private Banner banner;

    public DailyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_daily, container, false);
        initView(inflate);
        initMvp();
        return inflate;
    }

    private void initMvp() {
        ItemP itemP = new ItemP(this);
        itemP.getData();
    }

    private void initView(View inflate) {
        rv = (XRecyclerView) inflate.findViewById(R.id.rv);
        list = new ArrayList<>();
        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        myXlvAd = new MyXlvAd(list, getContext());
        rv.setAdapter(myXlvAd);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_banner, null);
        banner = (Banner) view.findViewById(R.id.banner);
        rv.addHeaderView(view);
    }


    @Override
    public void updateUIData(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("stories");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Gson gson = new Gson();
                DailyBean dailyBean = gson.fromJson(object.toString(), DailyBean.class);
                list.add(dailyBean);
                myXlvAd.setList(list);
            }
            banner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DailyBean dailyBean= (DailyBean) path;
                    Glide.with(getContext()).load(dailyBean.getImages().get(0)).into(imageView);
                }
            }).start();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUIWeChatData(String result) {

    }

    @Override
    public void upataUITagsData(String result) {

    }

    @Override
    public void upataUISCData(String result) {

    }


}

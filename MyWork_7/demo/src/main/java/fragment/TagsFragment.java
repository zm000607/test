package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.demo.Main2Activity;
import com.example.demo.Main3Activity;
import com.example.demo.R;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import adapter.ListAdapter;
import adapter.TagsAapter;
import bean.TagsBean;
import bean.WeChatBean;
import presenter.ItemP;
import view.ItemView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TagsFragment extends Fragment implements ItemView {


    private XRecyclerView rv;
    private ArrayList<TagsBean> list;
    private TagsAapter tagsAapter;

    public TagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_tags, container, false);
        initView(inflate);
        initMvp();
        return inflate;
    }

    private void initMvp() {
        ItemP itemP = new ItemP(this);
        itemP.getTagsData();
    }

    private void initView(View inflate) {
        rv = (XRecyclerView) inflate.findViewById(R.id.rv);
        list = new ArrayList<>();
        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        tagsAapter = new TagsAapter(list, getContext());
        rv.setAdapter(tagsAapter);
        tagsAapter.setOnClickListener(new TagsAapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                intent.putExtra("url",list.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void updateUIData(String result) {

    }

    @Override
    public void updateUIWeChatData(String result) {

    }

    @Override
    public void upataUITagsData(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("recent");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Gson gson = new Gson();
                TagsBean tagsBean = gson.fromJson(object.toString(), TagsBean.class);
                list.add(tagsBean);
                tagsAapter.setList(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upataUISCData(String result) {

    }


}

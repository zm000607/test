package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;


import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demo.Main2Activity;
import com.example.demo.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import adapter.ListAdapter;
import bean.WeChatBean;
import presenter.ItemP;
import view.ItemView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends Fragment implements ItemView {


    private ListView lv;
    private ArrayList<WeChatBean> list;
    private ListAdapter listAdapter;
    private static final String TAG = "WeChatFragment";
    private SearchView searchView;

    public WeChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_we_chat, container, false);

        initView(inflate);
        initMvp();
        return inflate;
    }

    private void initMvp() {
        ItemP itemP = new ItemP(this);
        itemP.getWeChatData();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            getActivity().getMenuInflater().inflate(R.menu.wechat, menu);
            searchView = (SearchView) menu.findItem(R.id.search).getActionView();
            //搜索图标是否显示在搜索框内
            searchView.setIconifiedByDefault(true);
            //设置搜索框展开时是否显示提交按钮，可不显示
            searchView.setSubmitButtonEnabled(true);
            // 让键盘的回车键设置成搜索
            searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
            // 搜索框是否展开，false表示展开
            searchView.setIconified(true);
            // 获取焦点
            searchView.setFocusable(true);
            searchView.requestFocusFromTouch();
            // 设置提示词
            searchView.setQueryHint("请输入关键字");
            //监听输入框输入，点击搜索按钮的信息
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Log.e("TAG", "----" + query);
                    return false;
                }
                //监听输入框搜索的每个字
                @Override
                public boolean onQueryTextChange(String newText) {

                    return true;
                }
            });
    }

    private void initView(View inflate) {
        lv = (ListView) inflate.findViewById(R.id.lv);

    }

    @Override
    public void updateUIData(String result) {

    }

    @Override
    public void updateUIWeChatData(String result) {
        list = new ArrayList<>();
        Log.d(TAG, "updateUIWeChatData: "+result);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("newslist");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Gson gson = new Gson();
                WeChatBean weChatBean = gson.fromJson(object.toString(), WeChatBean.class);
                list.add(weChatBean);
                Log.d(TAG, "updateUIWeChatData: "+list.size());
                listAdapter = new ListAdapter(list,getActivity());
                lv.setAdapter(listAdapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), Main2Activity.class);
                        intent.putExtra("url",list.get(position).getUrl());
                        startActivity(intent);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upataUITagsData(String result) {

    }

    @Override
    public void upataUISCData(String result) {

    }


}

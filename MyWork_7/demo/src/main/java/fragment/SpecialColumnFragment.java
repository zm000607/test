package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.R;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adapter.SCAapter;
import bean.SCBean;
import presenter.ItemP;
import view.ItemView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialColumnFragment extends Fragment implements ItemView {


    private XRecyclerView rv;
    private ArrayList<SCBean> list;
    private SCAapter scAapter;

    public SpecialColumnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_special_column, container, false);
        initView(inflate);
        initMvp();
        return inflate;
    }

    private void initMvp() {
        ItemP itemP = new ItemP(this);
        itemP.getSCData();
    }

    private void initView(View inflate) {
        rv = (XRecyclerView) inflate.findViewById(R.id.rv);
        list = new ArrayList<>();
        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        scAapter = new SCAapter(list, getContext());
        rv.setAdapter(scAapter);
    }

    @Override
    public void updateUIData(String result) {

    }

    @Override
    public void updateUIWeChatData(String result) {

    }

    @Override
    public void upataUITagsData(String result) {

    }

    @Override
    public void upataUISCData(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Gson gson = new Gson();
                SCBean scBean = gson.fromJson(object.toString(), SCBean.class);
                list.add(scBean);
                scAapter.setList(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

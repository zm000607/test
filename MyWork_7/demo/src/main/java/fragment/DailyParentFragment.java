package fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.R;

import java.util.ArrayList;

import adapter.VpAapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyParentFragment extends Fragment {


    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> fragmentList;

    public DailyParentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_daily_parent, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tab = (TabLayout) inflate.findViewById(R.id.tab);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
        fragmentList = new ArrayList<>();
        fragmentList.add(new DailyFragment());
        fragmentList.add(new ThemeFragment());
        fragmentList.add(new SpecialColumnFragment());
        fragmentList.add(new TagsFragment());
        VpAapter vpAapter = new VpAapter(getChildFragmentManager(), fragmentList);
        vp.setAdapter(vpAapter);
        tab.addTab(tab.newTab().setText("日报"));
        tab.addTab(tab.newTab().setText("主题"));
        tab.addTab(tab.newTab().setText("专栏"));
        tab.addTab(tab.newTab().setText("热门"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

    }
}

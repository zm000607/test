package com.example.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;

import java.util.ArrayList;

import adapter.VpAapter;
import fragment.DailyFragment;
import fragment.DailyParentFragment;
import fragment.SpecialColumnFragment;
import fragment.TagsFragment;
import fragment.ThemeFragment;
import fragment.WeChatFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;
    private NavigationView nv;
    private DrawerLayout dl;
    private FrameLayout fl;
    private FragmentManager supportFragmentManager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(tb);
        nv.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, tb, R.string.app_name, R.string.app_name);
        dl.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initView() {
        tb = (Toolbar) findViewById(R.id.tb);
        nv = (NavigationView) findViewById(R.id.nv);
        dl = (DrawerLayout) findViewById(R.id.dl);
        fl = (FrameLayout) findViewById(R.id.fl);
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.fl,new DailyParentFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.it_1:
                        //显示searchView.setVisibility(View.INVISIBLE);
                        transaction.replace(R.id.fl,new DailyParentFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        tb.setTitle("知乎日报");
                        break;
                    case R.id.it_2:
                        transaction.replace(R.id.fl,new WeChatFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();
                        tb.setTitle("微信精选");
                        break;
                }
                dl.closeDrawer(Gravity.LEFT);
                return true;
            }
        });

    }


}

package com.example.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import single.SingleTon;
import single.SingleTon_2;
import single.SingleTon_3;
import single.SingleTon_4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bun;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bun = (Button) findViewById(R.id.bun);

        bun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bun:
                single();
                break;
        }
    }
    /*单例模式
    * 优点:系统内存中该类只存在一个对象
    *      节省了系统资源
    *      对于一些需要频繁创建销毁的对象
    *      使用单例模式可以提高系统性能。
    * 缺点:当想实例化一个单例类的时候
    *      必须要记住使用相应的获取对象的方法
    *      而不是使用new 可能会给其他开发人员造成困扰
    *      特别是看不到源码的时候
    * */
    private void single() {
        //单例模式饿汉式静态常量
      /*  SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/

        //单例模式饿汉式静态代码块
       /* SingleTon_2 instance = SingleTon_2.getInstance();
        SingleTon_2 instance2 = SingleTon_2.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/

        //单例模式懒汉式(线程不安全)
        /*SingleTon_3 instance = SingleTon_3.getInstance();
        SingleTon_3 instance2 = SingleTon_3.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/

        //单例模式懒汉式(同步方法 线程安全)
        /*SingleTon_4 instance = SingleTon_4.getInstance();
        SingleTon_4 instance2 = SingleTon_4.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/

        //单例模式懒汉式(线程安全，同步代码块)
        /*SingleTon_5 instance = SingleTon_5.getInstance();
        SingleTon_5 instance2 = SingleTon_5.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/

        //单例模式双重检查
        /*SingleTon_6 instance = SingleTon_6.getInstance();
        SingleTon_6 instance2 = SingleTon_6.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/

        //单例模式静态内部类
        /*SingleTon_7 instance = SingleTon_7.getInstance();
        SingleTon_7 instance2 = SingleTon_7.getInstance();
        Log.d(TAG, "instance: "+instance.toString()+"instance2:"+instance2.toString());*/
    }
}

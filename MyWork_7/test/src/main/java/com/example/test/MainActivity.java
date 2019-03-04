package com.example.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import builder.Computer;
import builder.MacBookBuilder;
import factory.FactoryA;
import factory.FactoryB;
import factory.Product;
import observer.Coder;
import observer.IfBlog;
import single.SingleTon;
import template.ArmyComputer;
import template.NBCoder;
import template.Xiaobai;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bun;
    private static final String TAG = "MainActivity";
    private Button bun_2;
    private Button bun_3;
    private IfBlog ifBlog;
    private Button bun_4;
    private Button bun_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Coder coderSan = new Coder("张三");
        Coder coderSi = new Coder("李四");
        ifBlog = new IfBlog();
        ifBlog.addObserver(coderSan);
        ifBlog.addObserver(coderSi);
    }

    private void initView() {
        bun = (Button) findViewById(R.id.bun);

        bun.setOnClickListener(this);
        bun_2 = (Button) findViewById(R.id.bun_2);
        bun_2.setOnClickListener(this);
        bun_3 = (Button) findViewById(R.id.bun_3);
        bun_3.setOnClickListener(this);
        bun_4 = (Button) findViewById(R.id.bun_4);
        bun_4.setOnClickListener(this);
        bun_5 = (Button) findViewById(R.id.bun_5);
        bun_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bun:
                single();
                break;
            case R.id.bun_2:
                build();
                break;
            case R.id.bun_3:
                observer();
                break;
            case R.id.bun_4:
                factory();
                break;
            case R.id.bun_5:
                template();
                break;
        }
    }

    /*模板模式
    * 优点:1、封装不变部分，扩展可变部分。
    *      2、提取公共代码，便于维护。
    *      3、行为由父类控制，子类实现。
    * 缺点:每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
    * */
    private void template() {
        new Xiaobai().startup();
        new NBCoder().startup();
        new ArmyComputer().startup();
    }

    /*工厂模式
     *优点: 1、一个调用者想创建一个对象，只要知道其名称就可以了。
     *      2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
     *      3、屏蔽产品的具体实现，调用者只关心产品的接口。
     *缺点:每次增加一个产品时，都需要增加一个具体类和对象实现工厂，
     *     使得系统中类的个数成倍增加，
     *     在一定程度上增加了系统的复杂度，
     *     同时也增加了系统具体类的依赖。这并不是什么好事。
     * */
    private void factory() {
        Product product = new FactoryA().createProduct();
        product.method();
        Product product1 = new FactoryB().createProduct();
        product1.method();
    }

    /*观察者模式
     *优点:1、观察者和被观察者是抽象耦合的。
     *     2、建立一套触发机制。
     *缺点:1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
     *     2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
     *     3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
     * */
    private void observer() {
        ifBlog.postBlog("明天放假");
    }

    /*构建者模式
     *优点:1、建造者独立，易扩展。
     *     2、便于控制细节风险。
     *缺点:1、产品必须有共同点，范围有限制。
     *     2、如内部变化复杂，会有很多的建造类。
     * */
    private void build() {
        Computer computer = new MacBookBuilder().builderBoard("Intel 主板")
                .buildDisplay("Retina 显示器")
                .buildOs()
                .build();
        Log.d(TAG, "computer: " + computer.toString());
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
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        Log.d(TAG, "instance: " + instance.toString() + "instance2:" + instance2.toString());

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

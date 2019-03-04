package observer;

import android.util.Log;

import java.util.Observable;

public class IfBlog extends Observable {

    private static final String TAG = "ItBlog";

    public void postBlog(String msg){
        Log.d(TAG, "postBlog: "+msg);
        //设置状态发生改变
        setChanged();
        //通知所有的观察者
        notifyObservers(msg);
    }
}

package observer;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class Coder implements Observer {
    private static final String TAG = "Coder";
    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d(TAG, "name: "+name+"msg:"+arg.toString());
    }
}

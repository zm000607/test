package template;

import android.util.Log;

/**
 * Created by asus on 2019/3/4.
 */

public class Xiaobai extends AbsComputer {
    private static final String TAG = "Xiaobai";

    @Override
    protected void login() {
        Log.d(TAG, "小白电脑没有密码,直接进入操作页面: ");
    }
}

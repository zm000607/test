package template;

import android.util.Log;

/**
 * Created by asus on 2019/3/4.
 */

public class NBCoder extends AbsComputer {
    private static final String TAG = "NBCoder";

    @Override
    protected void login() {
        Log.d(TAG, "程序员的电脑,有个128位密码: ");
    }
}

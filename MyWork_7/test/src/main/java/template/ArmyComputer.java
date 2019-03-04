package template;

import android.util.Log;

/**
 * Created by asus on 2019/3/4.
 */

public class ArmyComputer extends AbsComputer {

    private static final String TAG = "ArmyComputer";

    @Override
    protected void checkHardWare() {
        super.checkHardWare();
        Log.d(TAG, "检测防火墙: ");
    }

    @Override
    protected void login() {
        Log.d(TAG, "输入了多重1024位密码: ");
    }
}

package template;

import android.util.Log;

public abstract class AbsComputer {

    private static final String TAG = "AbsComputer";
    public void startup(){
        Log.d(TAG, "准备启动: ");
        powerOn();
        checkHardWare();
        loadOs();
        login();
        Log.d(TAG, "启动成功: ");
    }

    protected abstract void login();

    protected void loadOs() {
        Log.d(TAG, "加载操作系统: ");
    }

    protected void checkHardWare() {
        Log.d(TAG, "检测硬件: ");
    }

    protected void powerOn() {
        Log.d(TAG, "按下电源: ");
    }
}

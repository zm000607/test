package factory;

import android.util.Log;

/**
 * Created by asus on 2019/3/4.
 */

public class ProductA extends Product {
    private static final String TAG = "ProductA";

    @Override
    public void method() {
        Log.d(TAG, "我是产品A ");
    }
}

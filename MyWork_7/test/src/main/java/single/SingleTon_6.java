package single;

/*单例模式
* 双重检查
* */
public class SingleTon_6 {
    private static volatile SingleTon_6 singleTon_6;

    private SingleTon_6() {}

    public static SingleTon_6 getInstance() {
        if (singleTon_6 == null) {
            synchronized (SingleTon_6.class) {
                if (singleTon_6 == null) {
                    singleTon_6 = new SingleTon_6();
                }
            }
        }
        return singleTon_6;
    }
}

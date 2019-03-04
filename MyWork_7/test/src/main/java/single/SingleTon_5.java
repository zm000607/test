package single;

/*单例模式
* 懒汉式(线程安全，同步代码块)
* */
public class SingleTon_5 {
    private static SingleTon_5 singleTon_5;

    private SingleTon_5() {}

    public static SingleTon_5 getInstance() {
        if (singleTon_5 == null) {
            synchronized (SingleTon_5.class) {
                singleTon_5 = new SingleTon_5();
            }
        }
        return singleTon_5;
    }
}

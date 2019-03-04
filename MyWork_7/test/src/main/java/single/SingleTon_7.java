package single;

/*单例模式
* 静态内部类
* */
public class SingleTon_7 {
    private SingleTon_7() {}

    private static class SingletonInstance {
        private static final SingleTon_7 INSTANCE = new SingleTon_7();
    }

    public static SingleTon_7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

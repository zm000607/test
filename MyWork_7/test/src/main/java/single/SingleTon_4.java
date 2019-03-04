package single;

/*单例模式
* 懒汉式(同步方法 线程安全)
* */
public class SingleTon_4 {
    private static SingleTon_4 singleTon_4;

    private SingleTon_4() {
    }

    public static synchronized SingleTon_4 getInstance(){
        if (singleTon_4==null){
            singleTon_4=new SingleTon_4();
        }
        return singleTon_4;
    }
}

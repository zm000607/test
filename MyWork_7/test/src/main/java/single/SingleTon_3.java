package single;

/*单例模式
* 懒汉式(线程不安全)
* */
public class SingleTon_3 {
    private static SingleTon_3 singleTon_3;
    private SingleTon_3() {
    }
    public static SingleTon_3 getInstance(){
        if (singleTon_3==null){
            singleTon_3=new SingleTon_3();
        }
        return singleTon_3;
    }
}

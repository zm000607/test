package single;

/*单例模式
* 饿汉式静态代码块
*/
public class SingleTon_2 {
    private static SingleTon_2 singleTon_2;
    static {
        singleTon_2=new SingleTon_2();
    }
    private SingleTon_2() {
    }
    public static SingleTon_2 getInstance(){
        return singleTon_2;
    }
}

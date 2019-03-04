package single;
/*单例模式
* 饿汉式静态常量
*/
public class SingleTon {
    private static SingleTon singleTon=new SingleTon();
    private SingleTon() {
    }
    public static SingleTon getInstance(){
        return singleTon;
    }
}

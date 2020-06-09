package cn.code.day3_17Thread;

public class ImplThread {
    public static void main(String[] args) {
        //3.创建接口类的实现类对象
        MThread mytest = new MThread();
        //4.给Thread有参构造传递一个Runnable的引用来实现Thread的创建
        Thread m = new Thread(mytest);
        m.start();
    }

}

//1.创建一个Runable接口的实现类
class MThread implements Runnable{
    //2.重写实现类的构造方法
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("接口实现类实现了"+i+"次");
        }
    }
}

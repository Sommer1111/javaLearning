package cn.code.day3_17Thread;

import java.lang.Thread;
import java.util.Random;

public class TestThread {
    public static void main(String[] args) {
        //1.生成3个随机的售票数
        Random r1 = new Random();
        Random r2 = new Random();

        int a = r1.nextInt(101);
        int loss = 100 - a + 1;
        int b = r2.nextInt(loss);
        int c = 100-b-a;

        //3.生成3个窗口
        MyThread sell1 = new MyThread(a);
        sell1.setName("窗口1");

        MyThread sell2 = new MyThread(b);
        sell2.setName("窗口2");

        MyThread sell3 = new MyThread(c);
        sell3.setName("窗口3");

        //4.售票环节
        sell1.start();
        sell2.start();
        sell3.start();

    }
}


//2.设定三个售票窗口的线程，问题，如何将票数传递给线程？
//通过构造函数传值
class MyThread extends Thread{
    private  int a;
    public MyThread(int a)
    {
        this.a=a;
    }

    @Override
    public void run() {

        for (int i = 0; i <a+1; i++) {
            System.out.println(currentThread().getName()+"售票一张");
        }
        System.out.println(currentThread().getName()+"共有"+a+"张票，全部售完");


    }
}
package cn.code.day3_17Thread;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Lock {
    public static void main(String[] args) {
        Window w1 = new Window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }


}

class Window implements Runnable{

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while(true){

            try{
                lock.lock();
                if(ticket>0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"窗口卖出了第"+ticket+"张票");
                    ticket--;
                }else{
                    break;
                }
            }finally{
                lock.unlock();
            }

        }
    }
}

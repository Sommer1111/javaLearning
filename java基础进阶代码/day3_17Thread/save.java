package cn.code.day3_17Thread;

import java.util.concurrent.locks.ReentrantLock;

public class save {
    public static void main(String[] args) {
        Save1 s = new Save1();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.start();
        t2.start();
        t3.start();
    }

}

class Save1 implements Runnable{

    private int ticket = 0;
    ReentrantLock lock1 = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                lock1.lock();
                if(ticket ==3000 ){
                    break;
                }else{
                    ticket +=1000;
                    System.out.println(Thread.currentThread().getName()+"往账户中存入了1000元，现有余额"+ticket+"元！");
                }
            }finally{
                lock1.unlock();
            }

        }


    }
}

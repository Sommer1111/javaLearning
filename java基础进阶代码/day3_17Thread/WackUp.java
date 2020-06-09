package cn.code.day3_17Thread;

import static java.lang.Thread.sleep;

public class WackUp {
    public static void main(String[] args) {
        wack w1 = new wack();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);

        t1.setName("贤臣1");
        t2.setName("贤臣2");

        t1.start();
        t2.start();
    }



}

class wack implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while(true){
            synchronized(this){
                notify();
                if(number <= 100){

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"打印出了："+number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
            }

            }
        }

    }
}

package day3_17Thread;


import static java.lang.Thread.sleep;

public class Test1 {
    public static void main(String[] args) {
        Test t1 = new Test();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t1);
        Thread tt3 = new Thread(t1);

        tt1.start();
        tt2.start();
        tt3.start();

    }

}

class Test implements Runnable{

    private int ticket = 100;
    @Override
    public void run() {
        show();
    }

    private synchronized void show(){
        for (int i = 0; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() +"窗口"+ ticket + "售出");
                ticket--;
            }
        }

    }
}





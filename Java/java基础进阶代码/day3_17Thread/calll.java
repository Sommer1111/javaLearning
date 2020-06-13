package day3_17Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class calll {
    public static void main(String[] args) {
        call c = new call();
        FutureTask f = new FutureTask(c);
        Thread t = new Thread(f);
        t.start();
        try {
            Object sum1 = f.get();
            System.out.println("总和为："+sum1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}

class call implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <=100 ; i++) {
            if(i%2==0){
                System.out.println(i);
                sum = sum+i;
            }

        }
        return sum;
    }
}

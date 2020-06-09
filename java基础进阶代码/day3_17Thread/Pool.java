package cn.code.day3_17Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Pool {
    public static void main(String[] args) {
        Run run = new Run();
        Thread thread = new Thread(run);

        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor s = (ThreadPoolExecutor)service;
        //service.submit(thread);
        service.execute(thread);
        service.shutdown();
    }

}

class Run implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
    }
}



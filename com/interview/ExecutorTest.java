package com.interview;

import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService service1 = Executors.newFixedThreadPool(3);
        for (int i=0;i<3;i++) {
            //service1.execute(new Task());
        }
        service1.shutdown();
        ////////////////
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        for (int i=0;i<3;i++) {
            //service2.execute(new Task());
        }
        service2.shutdown();
/////////////////////////////////////
        ExecutorService service3 = Executors.newCachedThreadPool();
//        Future<?> future = service3.submit(new Task());
        /////////////////
        System.out.println("----------------");

        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
        }
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(new Task(),9,TimeUnit.SECONDS);
        long t2 = System.currentTimeMillis();
        long  t=t2-t1;
        System.out.println("t= "+t);
        if (t>4)
        scheduledExecutorService.shutdown();
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("12345"+         Thread.currentThread().getName());
    }
}

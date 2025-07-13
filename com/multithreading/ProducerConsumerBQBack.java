package com.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBQBack {

    static BlockingQueue<Integer> queue=new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            try {
                producer();
            } catch (Exception e) {
                //throw new RuntimeException(e);
            }
        });

        Thread t2=new Thread(()->{
            try {
                Thread.sleep(500);
                consumer();
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }



    private static void producer() throws InterruptedException {
        while (true){
            Random random=new Random();
            int i = random.nextInt(300);
            queue.put(i);
            System.out.println("added "+i);
               Thread.sleep(1500);
        }
    }

    private static void consumer() throws InterruptedException {
        while (true){
            Integer remove = queue.remove();
            System.out.println("removed "+remove);
            Thread.sleep(1000);
        }
    }
}


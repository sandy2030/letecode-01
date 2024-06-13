package com.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBQ {
        static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
            Thread t1= new Thread(() -> {
                    try {
                        producer();
                    }catch (Exception e){

                    }
            });
            Thread t2= new Thread(() -> {
                try {
                    Thread.sleep(100);
                    consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t1.start();
            t2.start();
            //t1.join(t2);
    }
    static void producer() throws InterruptedException {
        while (true){
            Random random=new Random();
            int i=random.nextInt(300);
            queue.put(i);
            System.out.println("added  "+i);
                Thread.sleep(2500);
        }
    }

    static void consumer() throws InterruptedException {
        while (true) {
            Integer remove = queue.take();
            System.out.println("removed  "+remove);
            Thread.sleep(2000);

        }
    }

}


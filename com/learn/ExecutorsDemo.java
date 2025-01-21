package com.learn;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(new Task());

        try {
            Integer integer = future.get();
            System.out.println("result "+integer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main completed !!!!");
        service.shutdown();
    }


    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(5000);
            return new Random().nextInt(100);
        }
    }

}


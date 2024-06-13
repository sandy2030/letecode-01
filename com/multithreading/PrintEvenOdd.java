package com.multithreading;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrintEvenOdd implements  Runnable {
static int cnt=1;

    public static void main(String[] args) {
        Object lock=new Object();
        Runnable r1=printEvenOdd(lock);
    }

    private static Runnable printEvenOdd(Object lock) {
        return null;
    }


    @Override
    public void run() {
        while (cnt<=10){
    if (cnt%2==0 &&     Thread.currentThread().getName().equals("even")){
    }
        }
    }
}


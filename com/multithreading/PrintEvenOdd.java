package com.multithreading;
public class PrintEvenOdd {
    static int N=10;
    int i=0;
    public static void main(String[] args) {
        PrintEvenOdd obj=new PrintEvenOdd();

        Thread odd=new Thread(()->obj.printOdd());
        odd.setName("odd");
        Thread even=new Thread(() -> obj.printEven());
        even.setName("even");
        odd.start();
        even.start();
    }

    synchronized void printOdd(){
        while (i<N) {
            if (i % 2 == 0){
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread name: " + Thread.currentThread().getName() + " " + i);
            i++;
            notify();
        }
    }

    synchronized void  printEven(){
        while (i<N){
            if (i % 2 == 1){
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread name: " + Thread.currentThread().getName() + " " + i);
            i++;
            notify();
        }
    }

}


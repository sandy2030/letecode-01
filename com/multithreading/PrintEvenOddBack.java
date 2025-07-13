package com.multithreading;
public class PrintEvenOddBack {
    static int N=10;
    int i=0;
    void printOdd() {
     synchronized (this){
        while (i < N) {
            if (i % 2 == 0) {
                try {
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread name "+Thread.currentThread().getName()+"  i=  "+i);
            i++;
            notify();
        }
    }
    }

    void printEven(){
        synchronized (this){
            while (i < N) {
                if (i % 2 == 1) {
                    try {
                        wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread name "+Thread.currentThread().getName()+"  i=  "+i);
                i++;
                notify();
            }
        }
    }
    public static void main(String[] args) {
        PrintEvenOddBack obj=new PrintEvenOddBack();
        Thread odd=new Thread(()-> obj.printOdd());
        odd.setName("odd");
        Thread even=new Thread(()-> obj.printEven());
        even.setName("even");
        odd.start();
        even.start();
    }

}


package com.demo;

public class ThreadEx {
    public static void main(String[] args) {

        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(7000);
            }catch (InterruptedException e){
                System.out.println(" t1 exception --->"+e.getMessage());
            }
        },"t1");
        Thread t2=new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(9000);
            }catch (InterruptedException e){
                System.out.println(" t2 exception --->"+e.getMessage());
            }
        },"t2");

        getNme();
        t2.start();
        t1.start();

        try {
            t2.join();
            t1.join();
        }catch (InterruptedException e){
            System.out.println("t1 join error  "+e.getMessage());
        }

    }
    static void getNme(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(" main  exception --->"+e.getMessage());
        }
        System.out.println(" main thread  msg ::::::  "+Thread.currentThread().getName());
    }
}

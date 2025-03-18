package com.demo;

import java.util.Stack;
public class DemoSession {
    Stack<Integer>stack;
    static boolean flag=false;
    public DemoSession(Stack<Integer> stack) {
        this.stack = stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        DemoSession obj=new DemoSession(stack);

        Thread p=new Thread(()->obj.push(1));
        p.setName("producer");
        Thread c=new Thread(()->obj.pop());
        c.setName("consumer");
        p.start();
        c.start();
    }

    private void push(Integer i) {
            while (true){
                synchronized (this) {
                System.out.println("within push ");
                    while(stack.size()==1) {
                        System.out.println("pushed into stack .....  Thread name is " + Thread.currentThread().getName());
                        try {
                            wait();
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            System.out.println("push " + e.getMessage());
                        }
                        System.out.println("going to push notify ..");
                    }
                    this.stack.push(i);
                    System.out.println("stack size  after push  " + stack.size());
                notify();
                    System.out.println("called push notify ");
            }// end of synchronized
        }
    }

    private void pop(){
            while (true){
                synchronized (this) {
                    System.out.println("within pop ");
                while (stack.size()==0){
                    System.out.println("popped out from stack  .....  Thread name is " + Thread.currentThread().getName());
                    try {
                        wait();
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        System.out.println("pop " + e.getMessage());
                    }
                    System.out.println("going to pop notify ..");
                }
                    this.stack.pop();
                    System.out.println("stack size  after popped up  " + stack.size());
                notify();
                    System.out.println("called pop notify ");
            }
        }
    }

}

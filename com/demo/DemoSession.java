package com.demo;

import java.util.Stack;
public class DemoSession {
 Stack<Integer>stack;

    public DemoSession(Stack<Integer> stack) {
        this.stack = stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        //stack.setSize(1);
        DemoSession obj=new DemoSession(stack);

            Thread p=new Thread(()->{
                System.out.println("producer");
                obj.push(1);
            },"producer");

            Thread c=new Thread(()->{
                System.out.println("consumer");
                obj.pop();
            },"consumer");

            p.start();
            c.start();
    }

    private void push(Integer i) {
        synchronized (this) {
            System.out.println("within push ");
            if (stack.size() < 1){
                this.stack.push(i);
                System.out.println("pushed into stack .....  Thread name is "+Thread.currentThread().getName());
            try {
                System.out.println("stack size  after push  "+stack.size());
                wait();
            } catch (InterruptedException e) {
                System.out.println("push " + e.getMessage());
            }
            }
            notify();
        }
    }

    private void pop(){
        System.out.println("within pop ");
        synchronized (this) {
            if (stack.size() >= 1){
                this.stack.pop();
                System.out.println("popped out from stack  .....  Thread name is "+Thread.currentThread().getName());
            try {
                System.out.println("stack size  after popped up  "+stack.size());
                wait();
            } catch (InterruptedException e) {
                System.out.println("pop " + e.getMessage());
            }
            }
            notify();
        }
    }

}

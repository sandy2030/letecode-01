package com.multithreading;

public class JoinExample {
    public static void main(String[] args) {
        Thread child = new Thread(() -> {
            System.out.println("Child thread starting...");
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child thread completed.");
        });

        child.start();

        try {
            // Main thread waits for child to finish
            child.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread resumes after child thread finishes.");
    }
}

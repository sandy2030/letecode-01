package com.letecode;

public class FibonacciRecursive {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number");
            return;
        }

        System.out.print("Fibonacci sequence: ");
        for (int i = 0; i < n; i++) {
            fibonacci(i);
            //System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 2; // Number of terms in the Fibonacci sequence
        printFibonacci(n);

    }
}

package com.letecode;

public class Fib {
    public static int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;

            return fib(N - 1) + fib(N - 2);
    }
    public static long fibonacci(int n) {
        if (n <=1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }
}

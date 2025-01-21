package com.interview;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class ShortUrlGenerator {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();
    private final AtomicLong idCounter = new AtomicLong(1);
    // Converts a unique ID into a base-62 encoded string
    public String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(ALPHABET.charAt((int) (num % BASE)));
            num /= BASE;
        }

        System.out.println("id  "+idCounter.getAndIncrement());
        return sb.reverse().toString();
    }

    // Converts a base-62 encoded string back to a number
    public long decode(String str) {
        long num = 0;
        for (char c : str.toCharArray()) {
            num = num * BASE + ALPHABET.indexOf(c);
        }
        return num;
    }

    public static void main(String[] args) {
        ShortUrlGenerator obj=new ShortUrlGenerator();
        Random random=new Random();
        System.out.println(obj.encode(144));
        System.out.println(obj.decode("i7ntP"));

    }
}

package com.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonMultiThreaded instance1 = SingletonMultiThreaded.getInstance();
        SingletonMultiThreaded instance2 = SingletonMultiThreaded.getInstance();

        System.out.println("Instance 1 hash code: " + instance1.hashCode());
        System.out.println("Instance 2 hash code: " + instance2.hashCode());

        try {
            SingletonMultiThreaded clonedInstance = (SingletonMultiThreaded) instance1.clone();
            System.out.println("Cloned instance hash code: " + clonedInstance.hashCode());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
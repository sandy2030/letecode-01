package com.singleton;

public class SingletonMultiThreaded implements Cloneable {
    private static volatile SingletonMultiThreaded instance;

    private SingletonMultiThreaded() {
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static SingletonMultiThreaded getInstance(){
        if (null==instance){
            synchronized (SingletonMultiThreaded.class){
                if (null==instance){
                    instance=new SingletonMultiThreaded();
                }
            }
        }
        return instance;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance cannot be cloned");
    }
    protected Object readResolve() {
        return getInstance();
    }
}

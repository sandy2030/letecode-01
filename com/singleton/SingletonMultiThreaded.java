package com.singleton;

public class SingletonMultiThreaded {
    private static volatile SingletonMultiThreaded instance;

    private SingletonMultiThreaded() {
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
}

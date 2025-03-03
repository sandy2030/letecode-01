package com.singleton;

public class SingletonMultiThreaded implements Cloneable {
    private static volatile SingletonMultiThreaded instance;

    private SingletonMultiThreaded(){
        if (instance!=null){
            throw new IllegalStateException("not allowed");
        }
    }

    public SingletonMultiThreaded getInstance(){
        if (instance==null){
            synchronized (SingletonMultiThreaded.class){
                if (instance==null){
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

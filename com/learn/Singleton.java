package com.learn;

public class Singleton {
    private static  volatile Singleton instance;

    // prevent reflection
    private Singleton() {
        if (instance!=null)
            throw new RuntimeException("use getInstance method to get singleton instance");
    }

    // double check makes thread safe
    public static Singleton getInstamce(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }

    // prevent serialization
    public Object readResolve(){
        return getInstamce();
    }

    // prevent cloning
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Singleton can not be cloned");
    }

}

package com.singleton;

public class SingletonWithClonePrevention implements Cloneable {
    // The single instance of the class
    private static final SingletonWithClonePrevention INSTANCE = new SingletonWithClonePrevention();

    // Private constructor to prevent instantiation
    private SingletonWithClonePrevention() {
        // Prevent instantiation through reflection
        if (INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    // Public method to provide access to the instance
    public static SingletonWithClonePrevention getInstance() {
        return INSTANCE;
    }

    // Override the clone method to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance cannot be cloned");
    }

    // To prevent creating another instance during deserialization
    protected Object readResolve() {
        return getInstance();
    }

    // Example method to demonstrate singleton behavior
    public void showMessage() {
        System.out.println("Hello, I am a singleton!");
    }
}

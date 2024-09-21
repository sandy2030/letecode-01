package com.learn;
public class ChildOfImmutable  extends Immutable{
    private String mutableName;
    public ChildOfImmutable(String name, int age) {
        super(name, age);
        this.mutableName = name;
    }
    @Override
    public String getMutableName() {
        return mutableName;
    }
    public void setMutableName(String newName) {
        this.mutableName = newName;
    }
    public static void main(String[] args) {
        ChildOfImmutable person = new ChildOfImmutable("Alice", 25);
        System.out.println("Initial name: " + person.getMutableName()); // Output: Alice
        // Now modify the name using the setter in the subclass
        person.setMutableName("Bob");
        System.out.println("Modified name: " + person.getMutableName()); // Output: Bob
    }
}
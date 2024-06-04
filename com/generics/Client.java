package com.generics;

public class Client {
    public static void main(String[] args) {
        // no need to pass integer type as this class is only for integer
        ObjectInfoUsageWithoutGeneric withoutGen=new ObjectInfoUsageWithoutGeneric();
        Integer i = withoutGen.getObjectInfo(2); //  this method is bound to return only integer
        System.out.println("i= "+i);
        // pass integer as generic type
        ObjectInfoUsageWithGeneric<Integer> withGenInt=new ObjectInfoUsageWithGeneric();
        Integer i1 = withGenInt.getObjectInfo(20);
        System.out.println("i1= "+i1);
        // create another object with double as generic type
        ObjectInfoUsageWithGeneric<Double> withGenDbl=new ObjectInfoUsageWithGeneric<>();
        Double d = withGenDbl.getObjectInfo(2.3);
        System.out.println("d= "+d);
    }
}

package com.generics;

/*
*  incorrect way of creating class without using generics after  implementing interface using generics
*  this class is tightly coupled with Integer datatype and  getObjectInfo() method can only return Integer
*   public class ObjectInfoUsageWithGeneric<T> implements ObjectInfo<T>  is the correct way
* */
public class ObjectInfoUsageWithoutGeneric implements ObjectInfo<Integer>{
    @Override
    public Integer getObjectInfo(Integer val) {
        return val;
    }

    public static void main(String[] args) {
        ObjectInfoUsageWithoutGeneric obj=new ObjectInfoUsageWithoutGeneric();
        Integer objectInfo = obj.getObjectInfo(1);
    }
}

package com.generics;

/*
*  correct way of creating class with using generics after  implementing interface using generics
* *  this class is not tightly coupled with any datatype and  getObjectInfo() method can return any datatypes
 * */
public class ObjectInfoUsageWithGeneric<T> implements ObjectInfo<T>{
    @Override
    public T getObjectInfo(T t) {
        return t;
    }
}

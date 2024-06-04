package com.generics;

public class ObjectInfoUsage implements ObjectInfo<Integer>{
    @Override
    public Integer getObjectInfo(Integer val) {
        return val;
    }

    public static void main(String[] args) {
        ObjectInfoUsage obj=new ObjectInfoUsage();
        Integer objectInfo = obj.getObjectInfo(1.2);
    }
}

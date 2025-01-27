package com.letecode;

public class GeneralPractice {
    void callMe(String str){
        System.out.println("callMe with string "+str);
    }

    void callMe(Object obj){
        System.out.println("callMe with object "+obj.toString());
    }

    void callMe(Integer in){
        System.out.println("callMe with integer "+in);
    }
    public static void main(String[] args) {
        GeneralPractice gp=new GeneralPractice();
        String hi="hi";
        Object obj=(Object) hi;
        //gp.callMe("hi");
        //gp.callMe(obj);
//        gp.callMe(null);  // compile time error  due to ambigious call with callMe(Integer) and callMe(Integer)


    }
}

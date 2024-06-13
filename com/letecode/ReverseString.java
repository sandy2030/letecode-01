package com.letecode;

public class ReverseString{
  
   public static void main(String areg[]){
     
     String str="Sandeep pan";
     int i=str.length()-1;
     StringBuffer sb=new StringBuffer();
     while(i>=0){
       sb.append(str.charAt(i));
       i--;
     }
     System.out.println(sb);
   }
  
}
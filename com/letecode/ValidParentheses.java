package com.letecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    static boolean isValidParentheses(String s){
        Map<Character,Character> map=new HashMap<>();
        // (){}[]
        //({ })
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (!map.containsKey(c)){
                stack.push(c);
            }
            else {
                if (stack.isEmpty())
                    return false;
                char top=stack.pop(); // {
                if(map.get(c)!=top)
                {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String  s="";
    }
}

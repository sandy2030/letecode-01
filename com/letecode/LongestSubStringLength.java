package com.letecode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLength {
    private static int legthOfLongestSubString(String str){
        if (str==null || str.length()==0)
            return 0;
        if (str.length()==1)
            return 1;
        int left=0, right=0, ans=0;
        Set<Character> set=new HashSet<>();
        while (right<str.length()){
            char c=str.charAt(right);
            if (set.contains(c)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(c);
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str="pwwkew";
        System.out.println(legthOfLongestSubString(str));
    }
}

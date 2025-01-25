package com.letecode;

public class LongestPalindromicSubstring {
    public  static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start=0,end=0;
        for (int i=0;i<s.length();i++) {
            int len1 = expandFromCenter(s, i, i );
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (end-start<len){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public static Integer expandFromCenter(String str,int left, int right) {
        while (left>=0 && right<str.length() && str.charAt(left)== str.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
static boolean isPalindrome(String str){
    char[] charArray = str.toCharArray();
    int len=charArray.length,i=0;
    boolean flag=true;
    // madxm
    while (i<len){
        if (charArray[i]!=charArray[len-(i+1)]){
                flag=false;
                break;
        }
        i++;
    }
    return flag;
}

    public static void main(String[] args) {
        String str = "ac";
        System.out.println(longestPalindrome("abcbabbabc"));
    }
}

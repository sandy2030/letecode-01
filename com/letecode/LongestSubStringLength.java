package com.letecode;

import java.util.HashMap;
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
    static int longestUniqueSubstr(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {

            // Initializing all characters as not visited
            boolean[] visited = new boolean[256];

            for (int j = i; j < n; j++) {

                // If current character is visited,
                // Break the loop
                if (visited[s.charAt(j)]) {
                    break;
                }
                else {

                    // Else update the result if this
                    // window is larger, and mark current
                    // character as visited.
                    res = Math.max(res, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
        }
        return res;
    }

    static String m(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuffer sb=new StringBuffer();
        System.out.println("str   "+str);
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i)))
            {
                sb.append(str.charAt(i));
                map.put(str.charAt(i),1);
            }

        }
        String s=sb.toString();
        System.out.println(s+""+map);

        return s;
    }
    public static void main(String[] args) {
        String str="pwwkew";
     //   System.out.println(legthOfLongestSubString(str));
        String s = "geeksforgeeks";
        //System.out.println(longestUniqueSubstr(s));
        m(s);
        //System.out.println(map);
    }
}

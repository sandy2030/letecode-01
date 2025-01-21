package com.letecode;

public class isPalindrome {
    static boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while (left<right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                    left++;
                while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                    right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindrome1(String str)
    {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        String s="gekkkeg";
        System.out.println(isPalindrome1(s));
    }
}

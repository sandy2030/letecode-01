package com.letecode;

public class LongestPalindrome {

    // Helper function to expand from the center and check for the longest palindrome
    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandAroundCenter(s, i, i);   // Odd-length palindromes
            String evenPalindrome = expandAroundCenter(s, i, i + 1); // Even-length palindromes

            // Update longest palindrome if found longer one
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        String input = "abbamadam";
        String result = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}

package com.letecode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // For odd-length palindromes
            String oddPalindrome = expandAroundCenter(s, i, i);

            // For even-length palindromes
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Update the longest palindrome
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the palindromic substring found
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String str = "babad";
        System.out.println("Longest Palindromic Substring is: " + solution.longestPalindrome(str));
    }
}

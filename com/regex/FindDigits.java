package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDigits {
    public static void main(String[] args) {
        // The string to search for digits
        String input = "Hello123, this is 456 a test 7890.";

        // Compile a regex pattern to match sequences of digits (\\d+)
        Pattern pattern = Pattern.compile("\\d+");

        // Create a matcher that will match the pattern in the input string
        Matcher matcher = pattern.matcher(input);

        // Iterate through all matches and print them
        while (matcher.find()) {
            System.out.println("Found sequence of digits: " + matcher.group());
        }
    }
}
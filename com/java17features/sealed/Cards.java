package com.java17features.sealed;

public class Cards {
    public static void main(String[] args) {
        String day = "MONDAY";

        String message = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "It's a weekday!";
            case "SATURDAY", "SUNDAY" -> "It's the weekend!";
            default -> "Invalid day";
        };
        System.out.println(message);
    }
}

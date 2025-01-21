package com.mybank;

class Transaction {
    private String type;
    private double amount;
    private int timestamp;

    public Transaction(String type, double amount, int timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return type + ": " + amount + " at " + timestamp;
    }
}
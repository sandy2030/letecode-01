package com.mybank;

import java.util.ArrayList;
import java.util.List;

class Account {
    private int accountId;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount, int timestamp) {
        balance += amount;
        transactions.add(new Transaction("deposit", amount, timestamp));
    }

    public void withdraw(double amount, int timestamp) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("withdraw", amount, timestamp));
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public double getTotalTransactionValue() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public void mergeAccount(Account otherAccount) {
        this.balance += otherAccount.getBalance();
        this.transactions.addAll(otherAccount.getTransactions());
    }
}
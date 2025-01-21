package com.mybank;

class ScheduledTransfer {
    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private int timestamp;
    private boolean completed;

    public ScheduledTransfer(int fromAccountId, int toAccountId, double amount, int timestamp) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.completed = false;
    }

    public void completeTransfer(Bank bank) {
        Account fromAccount = bank.getAccounts().get(fromAccountId);
        Account toAccount = bank.getAccounts().get(toAccountId);
        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount, timestamp);
            toAccount.deposit(amount, timestamp);
            completed = true;
        }
    }

    public boolean isCompleted() {
        return completed;
    }
}
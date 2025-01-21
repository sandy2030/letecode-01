package com.mybank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Bank {
    private Map<Integer, Account> accounts;
    private Map<Integer, ScheduledTransfer> scheduledTransfers;

    public Bank() {
        accounts = new HashMap<>();
        scheduledTransfers = new HashMap<>();
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public String createAccount(int accountId) {
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, new Account(accountId));
            return "Account created: " + accountId;
        } else {
            return "Account already exists.";
        }
    }

    public String deposit(int accountId, double amount, int timestamp) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount, timestamp);
            return "Deposited: " + amount + " to account " + accountId;
        } else {
            return "Account not found.";
        }
    }

    public String withdraw(int accountId, double amount, int timestamp) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.withdraw(amount, timestamp);
            return "Withdrew: " + amount + " from account " + accountId;
        } else {
            return "Account not found.";
        }
    }

    public List<Account> rankAccountsByTransactions() {
        return accounts.values()
            .stream()
            .sorted((a, b) -> Double.compare(b.getTotalTransactionValue(), a.getTotalTransactionValue()))
            .collect(Collectors.toList());
    }

    public String scheduleTransfer(int fromAccountId, int toAccountId, double amount, int timestamp) {
        if (accounts.containsKey(fromAccountId) && accounts.containsKey(toAccountId)) {
            ScheduledTransfer transfer = new ScheduledTransfer(fromAccountId, toAccountId, amount, timestamp);
            scheduledTransfers.put(timestamp, transfer);
            return "Scheduled transfer from " + fromAccountId + " to " + toAccountId + " for " + amount + " at " + timestamp;
        } else {
            return "Account not found.";
        }
    }

    public String checkTransferStatus(int timestamp) {
        ScheduledTransfer transfer = scheduledTransfers.get(timestamp);
        if (transfer != null && transfer.isCompleted()) {
            return "Transfer at " + timestamp + " completed.";
        } else {
            return "Transfer at " + timestamp + " pending.";
        }
    }

    public String mergeAccounts(int accountId1, int accountId2) {
        Account account1 = accounts.get(accountId1);
        Account account2 = accounts.get(accountId2);
        if (account1 != null && account2 != null) {
            account1.mergeAccount(account2);
            accounts.remove(accountId2);
            return "Merged account " + accountId2 + " into " + accountId1;
        } else {
            return "One or both accounts not found.";
        }
    }
}
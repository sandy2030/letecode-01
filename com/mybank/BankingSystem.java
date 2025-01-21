package com.mybank;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        List<String> result = new ArrayList<>();
        
        result.add(bank.createAccount(1));
        result.add(bank.createAccount(2));
        result.add(bank.deposit(1, 1000, 1));
        result.add(bank.withdraw(1, 500, 2));
        result.add(bank.scheduleTransfer(1, 2, 200, 3));
        result.add(bank.checkTransferStatus(3));
        result.add(bank.mergeAccounts(1, 2));

        for (String res : result) {
            System.out.println(res);
        }
    }
}
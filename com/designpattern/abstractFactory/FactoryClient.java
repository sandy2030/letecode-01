package com.designpattern.abstractFactory;

public class FactoryClient {
    public static void main(String[] args) {
        BankAccountFactory accountFactory=new RetailBankAccountFactory();
        SavingAccount savingAccount = accountFactory.createSavingAccount();
        CurrentAccount currentAccount = accountFactory.createCurrentAccount();
        LoanAccount loanAccount = accountFactory.createLoanAccount();
        savingAccount.getAccountType();
        currentAccount.getAccountType();
        loanAccount.getAccountType();
    }
}

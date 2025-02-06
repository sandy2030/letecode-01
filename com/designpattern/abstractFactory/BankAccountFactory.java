package com.designpattern.abstractFactory;

public interface BankAccountFactory {
    SavingAccount createSavingAccount();
    CurrentAccount createCurrentAccount();
    LoanAccount createLoanAccount();
}

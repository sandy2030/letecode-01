package com.designpattern.abstractFactory;

public class RetailBankAccountFactory implements BankAccountFactory{
    @Override
    public SavingAccount createSavingAccount() {
        return new PersonalSavingAccount();
    }

    @Override
    public CurrentAccount createCurrentAccount() {
        return new BusinessCurrentAccount();
    }

    @Override
    public LoanAccount createLoanAccount() {
        return new HomeLoanAccount();
    }
}

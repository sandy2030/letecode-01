package com.designpattern.abstractFactory;

public class HomeLoanAccount implements LoanAccount{
    @Override
    public void getAccountType() {
        System.out.println("Personal Loan account");
    }
}

package com.designpattern.abstractFactory;

public class PersonalSavingAccount  implements SavingAccount{
    @Override
    public void getAccountType() {
        System.out.println("Personal Saving account");
    }
}

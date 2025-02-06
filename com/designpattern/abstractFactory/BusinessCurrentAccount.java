package com.designpattern.abstractFactory;

public class BusinessCurrentAccount  implements CurrentAccount{
    @Override
    public void getAccountType() {
        System.out.println("Personal current account");
    }
}

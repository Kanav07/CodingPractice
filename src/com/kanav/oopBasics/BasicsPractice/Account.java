package com.kanav.oopBasics.BasicsPractice;

public class Account {

    private static final int DEFAULT_ACCOUNT = 99999999;
    private static final double DEFAULT_BALANCE = 0.0;

    private int accountNumber;
    private double balance;

    public Account(){
        this.accountNumber = DEFAULT_ACCOUNT;
        this.balance = DEFAULT_BALANCE;
     }

    public Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.balance = DEFAULT_BALANCE;
     }


    public Account(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
     }





}

package com.galvanize.apibank;

public class BankAccount {

    private int id;
    private String name;
    private double balance;

    public BankAccount(){
    }

    public BankAccount(int id, String name, double deposit){
        this.id = id;
        this.name = name;
        this.balance = deposit;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }
}

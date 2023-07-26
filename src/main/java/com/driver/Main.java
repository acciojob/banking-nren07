package com.driver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            BankAccount bank=new SavingsAccount("Narendra Singh",1000.00,500.00,3.4);
            bank.deposit(500.00);
            bank.withdraw(0.00);
            System.out.println(bank.getName());
            System.out.println(bank.getBalance());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
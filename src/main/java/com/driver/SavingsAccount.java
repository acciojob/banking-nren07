package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if(amount>maxWithdrawalLimit) throw new CustomException("Maximum Withdraw Limit Exceed");
        else if(super.getBalance()-amount<super.getMinBalance()) throw new CustomException("Insufficient Balance");
        else super.withdraw(amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest=super.getBalance()*years*this.rate/100;

        return super.getBalance()+interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double finalAmount=super.getBalance()*Math.pow(1+this.rate/100,years);
        return finalAmount;
    }

}

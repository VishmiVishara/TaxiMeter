package models.admin;

import java.util.InputMismatchException;

public class SavingsAccount extends Account{
    private static final double withdrawCharge=5.0;

    public SavingsAccount(int accountId, double balance) {
        super(accountId, balance);
    }

    public double withdrawAmount(double amount){
        if(getBalance()>amount+5) {
            setBalance(getBalance() - (amount+withdrawCharge));
            return getBalance();
        }
        else{
            throw new InputMismatchException();
        }
    }
}

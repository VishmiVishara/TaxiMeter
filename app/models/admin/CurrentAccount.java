package models.admin;

import java.util.InputMismatchException;

public class CurrentAccount extends Account {

    public CurrentAccount(int accountId, double balance) {
        super(accountId, balance);
    }

    public double withdrawAmount(double amount){
        if(getBalance()>amount) {
            setBalance(getBalance() - (amount));
            return getBalance();
        }
        else{
            throw new InputMismatchException();
        }
    }
}


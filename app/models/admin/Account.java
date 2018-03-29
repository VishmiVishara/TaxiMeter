package models.admin;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;


abstract public class Account {
    private int accountId;
    private double balance;
    private LinkedList<Transaction> transaction = new LinkedList<>();

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract double withdrawAmount(double amount);

    Account(int accountId, double balance) {
        this.setAccountId(accountId);
        this.setBalance(balance);
    }

    private double depositAmount(double amount) {
        balance += amount;
        return balance;
    }

    /**
     * @param transaction : this is the transaction object which is going to create in the main method and passed.
     * @return : this method will return the modified transaction object.
     * @throws InputMismatchException : This Exception will be thrown if the user enters a larger amount than his/her balance.
     */
    public Transaction handleTransaction(Transaction transaction) throws InputMismatchException{
        if(transaction.type.equals("DEPOSIT")) {
            depositAmount(transaction.amount);
            this.transaction.add(transaction);
            transaction.setDate(new Date());
        }
        else
            try {
                withdrawAmount(transaction.amount);
                this.transaction.add(transaction);
                transaction.setDate(new Date());
            }
            catch (InputMismatchException e){
                throw new InputMismatchException();
            }
        return transaction;
    }
}


package models.validator;

import models.admin.Account;
import models.admin.Transaction;

import java.util.InputMismatchException;

public class IOValidator {
    public static Transaction validAmount(Transaction t,double amount) throws Exception {
        try {
            t.amount = amount;
        } catch (Exception e) {
            throw new Exception();
        }

        if (amount >= 0) {
            return t;
        } else {
            throw new Exception();
        }
    }

    public static void validateAccount(Account a) throws InputMismatchException {
        if (a == null) {
            throw new InputMismatchException();
        }
    }
}


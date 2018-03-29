package controllers;

import models.admin.*;
import models.validator.IOValidator;
import play.mvc.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountController extends Controller {

    public Result performTransaction(int acId, String tType, double am) {
        final Logger logger = Logger.getLogger(Account.class.getName());

        AccountDao acdao = new AccountDaoImpl();
        TransactionDao trdao = new TransactionDaoImpl();

        Transaction t = new Transaction("");
        Account a;
        Handler fileHandler;
        int userIn;

        logger.setUseParentHandlers(false);
        logger.warning("");
        logger.setLevel(Level.WARNING);

        try {
            fileHandler = new FileHandler("./logs/InvalidAmounts.log", true);
            fileHandler.setLevel(Level.WARNING);
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            logger.log(Level.WARNING, e.getCause() + "");
        }

        //Validating account from here...
        try {
            userIn = acId;
            a = acdao.getAccount(userIn);
            IOValidator.validateAccount(a);
        } catch (Exception e) {
            logger.log(Level.WARNING, "checked for Invalid AccountID : ");
            return notFound("Account not found.");
        }

        //Getting the transaction type from here...
        try {
            t.type = tType;
        } catch (InputMismatchException e) {
            logger.log(Level.WARNING, "Invalid procedures by : " + a.getAccountId());
            return notFound("1.");
        }catch (NullPointerException e) {
            logger.log(Level.WARNING, "Invalid procedures by : " + a.getAccountId());
            return unauthorized("Wrong transaction type.");
        }

        //Getting the amount from here...
        try {
            t = IOValidator.validAmount(t,am);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Invalid amount added by : " + a.getAccountId());
            return unauthorized("Invalid amount. Please try again.");
        }

        //Transaction Procedure from here...
        try {
            t = a.handleTransaction(t);
            trdao.setTransaction(t, a.getAccountId());
            acdao.updateAccount(a);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Amount exceeding balance by : " + a.getAccountId());
            return unauthorized("Insufficient balance. Please try again.");
        }
        return ok("Transaction successful! Y");
    }
}
package models.admin;

public interface AccountDao {
    Account getAccount(int userIn);
    void updateAccount(Account a);
}




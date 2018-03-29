package models.admin;

import java.sql.*;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account getAccount(int userIn) {
        Account a = null;
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Couldn't load the driver.");
                System.exit(0);
            }

            String s= "SELECT ACCOUNT_ID,ACTYPE,BALANCE FROM ACCOUNT WHERE ACCOUNT_ID = " + userIn + ";";
            Statement getAc = conn.prepareStatement("SELECT ACCOUNT_ID,ACTYPE,BALANCE FROM ACCOUNT WHERE ACCOUNT_ID = " + userIn + ";");
            ResultSet rs = getAc.executeQuery(s);
            while (rs.next()){
                if (rs.getString("ACTYPE").equalsIgnoreCase("SAVINGS"))
                    a = new SavingsAccount(rs.getInt("ACCOUNT_ID"), rs.getDouble("BALANCE"));
                else
                    a = new CurrentAccount(rs.getInt("ACCOUNT_ID"), rs.getDouble("BALANCE"));}
            return a;
        } catch (SQLException e) {
        }
        return null;
    }

    public void updateAccount(Account a) {
        try {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Couldn't load the driver.");
                System.exit(0);
            }
            String s= "UPDATE ACCOUNT SET BALANCE = " + a.getBalance() + " WHERE ACCOUNT_ID = " + a.getAccountId() + ";";
            Statement setAccount = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE = " + a.getBalance() + " WHERE ACCOUNT_ID = " + a.getAccountId() + ";");
            setAccount.executeUpdate(s);
            setAccount.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
}


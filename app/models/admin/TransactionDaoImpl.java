package models.admin;

import java.sql.*;

public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void setTransaction(Transaction t, int a) {
        try {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Couldn't load the driver.");
                System.exit(0);
            }
            String s = "INSERT INTO BANK_TRANSACTION(TDATE,AMOUNT,TTYPE,ACCOUNT_ID) VALUES ('" + t.getDate().toString() + "'," + t.amount + ",'" + t.type + "'," + a + ");";
            Statement setTrans = conn.prepareStatement("INSERT INTO BANK_TRANSACTION(TDATE,AMOUNT,TTYPE,ACCOUNT_ID) VALUES ('" + t.getDate().toString() + "'," + t.amount + ",'" + t.type + "'," + a + ");");
            setTrans.executeUpdate(s);
            setTrans.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

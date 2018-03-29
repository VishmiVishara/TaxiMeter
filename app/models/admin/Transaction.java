package models.admin;

import java.util.Date;

public class Transaction {
    private Date date;
    public double amount;
    public String type;

    public Transaction(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "date: " + date.toString()+"   type: "+type+"   Amount: "+amount;
    }
}

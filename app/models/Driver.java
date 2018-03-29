package models;


import io.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Driver extends Model{
    @Id
    @Constraints.Required
    public Integer DriverId;

    public String FirstName;
    public String LastName;

    @Constraints.Required
    public String NIC;

    @Constraints.Required
    public String MobileNumber;

    @Constraints.Required
    public String Email;
    public Integer Rating;

    public static final Finder<Integer, Driver> find = new Finder<>(Driver.class);

}

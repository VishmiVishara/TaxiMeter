package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import javax.persistence.Entity;


@Entity
public class Driver extends Controller {

    public Result index() {
        List<models.Driver> drivers = models.Driver.find.query().where()
                .ilike("FirstName","%a%")
                .setMaxRows(25)
                .findPagedList()
                .getList();

        return ok(play.libs.Json.toJson(drivers));
    }
}



package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;

import java.util.List;
import java.util.Map;


/**
 * this is SignController.
 */

@RestController
@CrossOrigin
public class SignController {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  @PostMapping("/signUpp")
  public String createAccount(@RequestBody Map params) {
    String username = params.get("username").toString();
    String password = params.get("password").toString();
    Account data = new Account(123, username,password);

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
        String query = "insert into account (ID,USERNAME,PASSWORD) values(NULL,:username,:password)";
        connection.createQuery(query)
                .addParameter("username", data.getUsername())
                .addParameter("password", data.getPassword())
                .executeUpdate();
    }
    return data.getUsername();
  }

  @PostMapping("/loginn")
  public String accountCheck(@RequestBody Map params) {
    String username = params.get("username").toString();
    String password = params.get("password").toString();
    Account data = new Account(123, username,password);

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT * "
                  + "FROM ACCOUNT "
                  + "WHERE USERNAME = :username AND PASSWORD = :password";
      List<Account> find = connection.createQuery(query)
              .addParameter("username", data.getUsername())
              .addParameter("password", data.getPassword())
              .executeAndFetch(Account.class);


      if(!find.isEmpty()) return data.getUsername();
      else return "unknown user";
    }
  }
}
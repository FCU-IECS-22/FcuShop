package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    @PostMapping("/productsOfCart")
    public String getProductsOfCart(@RequestBody Map params) {
        Object all = params.get("cartItems").toString();
        System.out.println(all);

//    try (Connection connection = sql2oDbHandler.getConnector().open()) {
//      String query = "SELECT * FORM product WHERE ID = :id";
//      connection.createQuery(query)
//              .addParameter("username", data.getUsername())
//              .addParameter("password", data.getPassword())
//              .executeUpdate();
//    }
        return "hehe";
    }
}

package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;

import java.util.Map;


@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    @PostMapping("/productsOfCart")
    public Object getProductsOfCart(@RequestBody Map params) {
        Object all = params.get("cartItems");

        System.out.println("cartItems : ");
        System.out.println(all);

        try (Connection connection = sql2oDbHandler.getConnector().open()) {
          String query = "SELECT * FROM PRODUCT WHERE ID = :id";
          connection.createQuery(query)
                  .addParameter("id", all)
                  .executeUpdate();
        }
        return all;
    }
}

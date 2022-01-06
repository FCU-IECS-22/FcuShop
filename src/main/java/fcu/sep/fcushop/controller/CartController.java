package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    @PostMapping("/productsOfCart")
    public List<Product> getProductsOfCart(@RequestBody Map params) {
        ArrayList all = (ArrayList) params.get("cartItems");

        try (Connection connection = sql2oDbHandler.getConnector().open()) {
          String query = "SELECT ID id, NAME name, IMAGE_URL imageUrl, PRICE price,"
                  + "DESCRIPTION description FROM PRODUCT WHERE ID IN(:arrayID)";

          return connection.createQuery(query)
                  .addParameter("arrayID",all)
                  .executeAndFetch(Product.class);
        }

    }
}

package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.service.ProductService;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;


/**
 * this is ProductController.
 */

@RestController
@CrossOrigin
public class ProductController {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;
  ProductService productManager;

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productManager.getProducts();
  }

  @GetMapping("/products/{keyword}")
  public List<Product> getProducts(@PathVariable("keyword") String keyword) {
    return productManager.getProducts(keyword);
  }

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

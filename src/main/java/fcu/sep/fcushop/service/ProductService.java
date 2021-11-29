package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.sql2o.Connection;

/**
 * ProductService.
 */
@Service
public class ProductService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public ProductService() {

  }

  /**
   * getProducts().
   *
   * @return connection.createQuery(query).executeAndFetch(Product.class);
   *
   */
  public List<Product> getProducts() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price,"
              + " DESCRIPTION description" + " from PRODUCT";
      return connection.createQuery(query).executeAndFetch(Product.class);
    }
  }

  /**
   * getProducts(String keyword).
   *
   * @param keyword is keyword.
   * @return connection.createQuery(query).executeAndFetch(Product.class);
   */
  public List<Product> getProducts(String keyword) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price,"
              + " DESCRIPTION description" + " from PRODUCT where name LIKE :keyword";
      return connection.createQuery(query)
              .addParameter("keyword", "%" + keyword + "%")
              .executeAndFetch(Product.class);
    }
  }
  //productController, Product, ProductService need to change
}
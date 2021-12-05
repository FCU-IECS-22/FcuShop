package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;


/**
 * This is class ManageController.
 */
@RestController
public class ManageController {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;


  /**
   *  This is class OneController.
   */
  @Controller
  public class OneController {
    @RequestMapping("/manageFile")
    public String manageFile() {
      return "redirect:/manageFile.html";
    }
  }

  /**
   *  This is class TwoController.
   */
  @Controller
  public class TwoController {

    /**
     * This is getNewData function.
     * @ param data form login website.
     * @ return index.html;
     */
    @PostMapping("/addFile")
     public String getNewData(@ModelAttribute("product") Product data) {
      System.out.println(data.getId());
      System.out.println(data.getName());
      System.out.println(data.getImageUrl());
      System.out.println(data.getDescription());
      System.out.println(data.getPrice());
      try (Connection connection = sql2oDbHandler.getConnector().open()) {
        String query = "insert into product (id,name,image_url,price,description)"
                        + "values(NULL,:name,:image_url,:price,:description)";
        connection.createQuery(query)
            .addParameter("name", data.getName())
            .addParameter("image_url", data.getImageUrl())
            .addParameter("price", data.getPrice())
            .addParameter("description", data.getDescription())
            .executeUpdate();
      }

      return "redirect:/index.html";
    }
  }
}

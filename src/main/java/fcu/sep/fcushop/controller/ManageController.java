package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/modifyFile")
    public String modifyFile() {
      return "redirect:/modifyFile.html";
    }

    @RequestMapping("/addFile")
    public String addFile() {
      return "redirect:/addFile.html";
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

    @PostMapping("/modifyFile")
    public String modifyData(HttpServletRequest request) {
      String oldName = request.getParameter("oldName");
      String newName = request.getParameter("newName");
      String imageUrl = request.getParameter("imageUrl");
      String price = request.getParameter("price");
      String description = request.getParameter("description");
      try (Connection connection = sql2oDbHandler.getConnector().open()) {
        String query = "update product set `name` = :newName, image_url = :image_url,"
                + " price = :price,description = :description"
                + " where `name` = :oldName";
        connection.createQuery(query)
                  .addParameter("oldName", oldName)
                  .addParameter("newName", newName)
                  .addParameter("image_url", imageUrl)
                  .addParameter("price", price)
                  .addParameter("description", description)
                  .executeUpdate();
      }
      return "redirect:/index.html";
    }
  }
}

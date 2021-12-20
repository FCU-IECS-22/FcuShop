package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;

import java.util.Map;


/**
 * this is EditController.
 */

@RestController
@CrossOrigin
public class EditController {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  @PostMapping("/edit")
  public String createProduct(@RequestBody Map params) {


    String oldName = params.get("oldName").toString();
    String newName = params.get("newName").toString();
    String imageUrl = params.get("imageUrl").toString();
    String price = params.get("price").toString();
    String description = params.get("description").toString();

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


      return "要傳啥？";
    }
  }
}
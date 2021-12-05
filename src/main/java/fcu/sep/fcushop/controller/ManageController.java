package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;

import java.util.List;

@RestController
public class ManageController {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;


    @Controller
    public class OneController {
        @RequestMapping("/manageFile")
        public String manageFile() {
            return "redirect:/manageFile.html";
        }
    }

    @Controller
    public class TwoController {
        @PostMapping("/addFile")
        public String getNewData(@ModelAttribute("product") Product data) {
            System.out.println(data.getId());
            System.out.println(data.getName());
            System.out.println(data.getImageUrl());
            System.out.println(data.getDescription());
            System.out.println(data.getPrice());

            try (Connection connection = sql2oDbHandler.getConnector().open()) {
                String query = "insert into product (id,name,image_url,price,description)" +
                                "values(NULL,:name,:image_url,:price,:description)";
                connection.createQuery(query)
                    .addParameter("name",data.getName())
                    .addParameter("image_url", data.getImageUrl())
                    .addParameter("price",  data.getPrice())
                    .addParameter("description", data.getDescription())
                    .executeUpdate();

            }
            return "redirect:/index.html";
        }
    }
}

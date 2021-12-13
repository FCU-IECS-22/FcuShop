package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Account;
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
public class AccountController {

    @Autowired
    private Sql2oDbHandler sql2oDbHandler;


    /**
     *  This is class OneController.
     */
    @Controller
    public class AccountRoute {

        @RequestMapping("/login")
        public String login() {
            return "redirect:/login.html";
        }

        @RequestMapping("/signUp")
        public String signUp() {
            return "redirect:/signup.html";
        }


    }

    /**
     *  This is class AccountDataProcess.
     */
    @Controller
    public class AccountDataProcess {

        /**
         * This is getNewData function.
         * @ param data form login website.
         * @ return index.html;
         */


        @PostMapping("/signUp")
        public String getNewAccountData(@ModelAttribute("account") Account data) {
            System.out.println("data : " + data);

            System.out.println("ID : " + data.getId());
            System.out.println("UserName : " + data.getUsername());
            System.out.println("Password : " + data.getPassword());

            try (Connection connection = sql2oDbHandler.getConnector().open()) {
                String query = "insert into account (ID,USERNAME,PASSWORD) values(NULL,:username,:password)";
                connection.createQuery(query)
                        .addParameter("username", data.getUsername())
                        .addParameter("password", data.getPassword())
                        .executeUpdate();
            }
            return "redirect:/index.html";
        }
    }
}

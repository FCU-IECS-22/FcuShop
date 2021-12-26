package fcu.sep.fcushop.service;


import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.sql2o.Connection;

import java.util.List;
import java.util.Map;

@Service
public class ManageService {


    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public ManageService() {

    }

    public Connection deleteData(@RequestBody Map params) {
        String id = params.get("id").toString();

        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "DELETE FROM product WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        }


    }
}

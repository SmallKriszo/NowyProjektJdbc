package nowyProjectJdbc;

import nowyProjectJdbc.config.Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    Connection h2Connection = Config.getInstance().getConnection();

    String querySql = "select ID,NAME, SURNAME, AGE\n" +
            "from MY_SCHEMA.PERSON";

    try{
        Statement statement = null;
        try {
            statement = h2Connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet result = statement.executeQuery(querySql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

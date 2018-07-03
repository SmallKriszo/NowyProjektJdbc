package nowyProjectJdbc;

import nowyProjectJdbc.config.Config;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionsTests {
    @Test
    public void obtainConnection(){

            Connection connection = null;
            try {
                connection = Config.getInstance().getConnection();
                Assert.assertNotNull("Null!!!", connection);
            }finally {
                if (null != connection) {
                    try {
                        connection.close();
                    }catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

        }
    }
}

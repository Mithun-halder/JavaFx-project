import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class MySQLJDBCUtil {


    public static Connection getConnection() throws SQLException {



            String url       = "jdbc:mysql://localhost:3306/project";
            String user      = "root";
            String password  = "1234";

            Connection conn = null;

            conn = DriverManager.getConnection(url, user, password);

            return conn;
    }

}
package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database 
{
    public static Connection connect() throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url="jdbc:oracle:thin:@192.168.1.47:1521:xe";
        Connection connection=DriverManager.getConnection(url,"user8","password");
        return connection;
    }
}

package statements;

import DatabaseConnectivity.database;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStat 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con=database.connect();
        CallableStatement cs=con.prepareCall("{call insertUser(?,?,?)}");
        cs.setInt(1, 104);
        cs.setString(2,"cardi");
        cs.registerOutParameter(3, java.sql.Types.VARCHAR);
	cs.executeUpdate();
	String result = cs.getString(3);
	System.out.println("User save Success::"+result);
    }
}

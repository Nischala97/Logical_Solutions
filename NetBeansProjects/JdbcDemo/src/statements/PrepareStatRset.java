package statements;

import DatabaseConnectivity.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatRset 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con=database.connect();
        String query="select * from jdbcTest where id=?";
        PreparedStatement ps=con.prepareStatement(query);
        
        ps.setInt(1, 101);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          System.out.println(rs.getString("name")+" "+rs.getInt("id"));
        }
        rs.close();
        ps.setInt(1, 102);
        rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name")+" "+rs.getInt("id"));
        }
    }
}

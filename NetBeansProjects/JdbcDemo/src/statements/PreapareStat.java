package statements;

import DatabaseConnectivity.database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class PreapareStat 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con=database.connect();
        String query="insert into jdbcTest values(?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,107);
        ps.setString(2,"kiki");
        ps.addBatch();
        //ps.executeUpdate();
        /*for(int i=0;i<2;i++)
        {   ps.setInt(1,a[i]);
            ps.setString(2,str[i]);      
            ps.addBatch();
        }*/
        ps.executeBatch();
        
        query="update jdbcTest set name=? where id=?";
        ps=con.prepareStatement(query);
        //PreparedStatement ps1=con.prepareStatement(query1);
        ps.setInt(2,2);
        ps.setString(1,"wassabi");
        ps.addBatch();
        
       // ps.executeBatch();
        ps.executeBatch();
        
        query="delete from jdbcTest where id between ? and ?";
        ps=con.prepareStatement(query);
        ps.setInt(1,104);
        ps.setInt(2,120);
        
        ps.executeUpdate();
    }
}
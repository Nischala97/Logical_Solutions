package com.demojdbc.insert;
import DatabaseConnectivity.database;
import java.sql.*;

public class Retrieve 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
      /*  Class.forName("oracle.jdbc.driver.OracleDriver");
        String url="jdbc:oracle:thin:@192.168.1.47:1521:xe";
        Connection connection=DriverManager.getConnection(url,"user8","password");
       */ 
        Connection connection=database.connect();
        Statement statement=connection.createStatement();
        int id=1;
        String name="sam";
        String query1="delete from jdbcTest where id="+id;
        String query2="delete from jdbcTest where name='"+name+"'";
        int result=statement.executeUpdate(query1);
        if(result>0)
        {
            System.out.println("data added");
        }
        connection.close();
    }
}

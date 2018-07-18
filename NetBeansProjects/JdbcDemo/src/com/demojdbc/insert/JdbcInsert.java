package com.demojdbc.insert;

import DatabaseConnectivity.database;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.SQLException;

public class JdbcInsert 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //String url="jdbc:oracle:thin:@192.168.1.47:1521:xe";
        //Connection connection=DriverManager.getConnection(url,"user8","password");
        Connection con=database.connect();
        Statement statement=con.createStatement();
        String query="insert into account values(105,1100)";
        int result=statement.executeUpdate(query);
        if(result>0)
        {
            System.out.println("data added");
        }
        con.close();
    }
}

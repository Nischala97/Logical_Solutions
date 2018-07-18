package com.demojdbc.bank;

import DatabaseConnectivity.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Scanner s=new Scanner(System.in);
    /*    Class.forName("oracle.jdbc.driver.OracleDriver");
        String url="jdbc:oracle:thin:@192.168.1.47:1521:xe";
        Connection connection=DriverManager.getConnection(url,"user8","password");
    */
        Connection connection=database.connect();
        Statement statement=connection.createStatement();
        
        while(true)
        {
            System.out.println("Enter username");
            String name=s.next();
            String pwd="";
            String check="select umane from login";
            ResultSet che=statement.executeQuery(check);
            int flag=0; 
            while(che.next())
            {
                if(che.getString(1).equals(name))
                {
                    flag=1;break;
                }
            }
            if(flag==1)
            {
                System.out.println("Enter password");
                pwd=s.next();
                String query="select password from login where umane='"+name+"'";
                ResultSet result=statement.executeQuery(query);
                
                while(result.next())
                {
                    if(result.getString(1).equals(pwd))
                    {
                        System.out.println("login successful");flag=0;break;
                    }   
                }
                if(flag==1) System.out.println("wrong password");
            }
            else
            {
                System.out.println("No such username found");flag=1;
            }
            if(flag==0)
            {    
                int opt=-1;
                do
                {
                    System.out.println("menu page: \n1.Account creation \n2.Deposit \n3.withdraw \n4.Balance check \n5.exit");
                    System.out.println("choose option");
                    opt=s.nextInt();
                    switch(opt)
                    {
                        case 1:
                                System.out.println("Enter username");
                                name=s.next();
                                System.out.println("Enter password");
                                pwd=s.next();
                                String query="insert into credentials values('"+name+"'"+","+"'"+pwd+"')";
                                statement.executeUpdate(query);
                                
                                break;
                        case 2:
                                System.out.println("Enter account number:");
                                int acc=s.nextInt();
                                String acheck="select acc from account";
                                ResultSet rs=statement.executeQuery(acheck);
                                
                                while(rs.next())
                                {
                                    flag=0;
                                    if(rs.getInt(1)==acc)
                                    {
                                        System.out.println("Enter amount");
                                        double amt=s.nextDouble();
                                        if(amt<500){System.out.println("minimum deposit value:500 ");flag=1;break;}
                                        String amtval="select bal from account where acc="+acc;
                                        ResultSet val=statement.executeQuery(amtval);
                                        while(val.next())
                                        {
                                            amt+=val.getDouble(1);flag=1;
                                            statement.executeUpdate("update account set bal="+amt+"where acc="+acc);                   
                                            break;
                                        }
                                    }
                                }
                                if(flag==0){ System.out.println("No such account exists");}
                                
                                break;
                            
                    case 3:
                                System.out.println("Enter account number:");
                                acc=s.nextInt();
                                acheck="select acc from account";
                                rs=statement.executeQuery(acheck);
                                
                                while(rs.next())
                                {
                                    flag=0;
                                    if(rs.getInt(1)==acc)
                                    {
                                        System.out.println("Enter amount");
                                        double amt=s.nextDouble();
                                        
                                        String amtval="select bal from account where acc="+acc;
                                        ResultSet val=statement.executeQuery(amtval);
                                        while(val.next())
                                        {
                                            if(amt>val.getDouble(1)){System.out.println("Insusfficient amount in account");flag=1;break;}
                                            amt=val.getDouble(1)-amt;flag=1;
                                            statement.executeUpdate("update account set bal="+amt+"where acc="+acc);                   
                                            break;
                                        }
                                    }
                                }
                                if(flag==0) System.out.println("No such account exists");
                                
                                break;
                    case 4:
                                System.out.println("Enter account number:");
                                acc=s.nextInt();
                                acheck="select acc from account";
                                rs=statement.executeQuery(acheck);
                                
                                while(rs.next())
                                {
                                    flag=0;
                                    if(rs.getInt(1)==acc)
                                    {
                                        String amtval="select bal from account where acc="+acc;
                                        double amt=statement.executeUpdate(amtval);
                                        ResultSet val=statement.executeQuery(amtval);
                                        while(val.next())
                                        {
                                            flag=1;
                                            System.out.println("available balance is "+val.getDouble(1));
                                            
                                            break;
                                        }
                                    }
                                }
                                if(flag==0) System.out.println("No such account exists");
                            
                                break;
                    }
                }
                while(opt>0 && opt<5);        
            }
        connection.close();
        }       //while close
    }
}
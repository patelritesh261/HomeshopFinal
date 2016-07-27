/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.*;

/**
 *
 * @author ritesh
 */
public class DBConnect {
    //variable declaration
    private  final String DB_URL="jdbc:mysql://sql.computerstudi.es:3306/gc200307232";
    private  final String username="gc200307232";
    private  final String password="GuDgA?sA";
    //declara connection variable
    private static Connection conn;
    public Connection getConnection(){
        try{
            //set connection
            conn=DriverManager.getConnection(DB_URL,username,password);
        }
        catch(SQLException error){
        System.out.println("An error occured connecting to database.");
    }catch(Exception error){
        error.printStackTrace();
    }
        //return connection status
        return conn;
    }
}

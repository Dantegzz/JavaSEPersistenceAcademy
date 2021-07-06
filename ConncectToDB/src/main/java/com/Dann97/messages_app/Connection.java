/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dann97.messages_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dante Gonzalez
 */
public class Connection {
    
    public java.sql.Connection get_connection(){
        java.sql.Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app","root","");
           
        }catch(SQLException e) {
            System.out.println(e);
        }
        return conection;
        
    }
    
}

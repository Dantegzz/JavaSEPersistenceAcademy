/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dann97.messages_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dante Gonzalez
 */
public class MessagesDAO {
    
    public static void crearMensajeDB(Messages mensaje){
        Connection db_connect = new Connection();
        
        try(Connection conexion = db_connect.get_connection())  {
            PreparedStatement  ps=null;
            try{
                String query="INSERT INTO messages ( messgae, author_message) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMessage());
                ps.setString(2, mensaje.getAuthor_Message());
                ps.executeUpdate();
                System.out.println("message created");
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void readMessagesDB(){
        Connection db_connect = new Connection();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try(Connection conexion = db_connect.get_connection())  {        
            String query="SELECT * FROM messages";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_message"));
                System.out.println("Message: "+rs.getString("message"));
                System.out.println("Author: "+rs.getString("author-message"));
                System.out.println("Dante: "+rs.getString("date-message"));
                System.out.println("");
            }
        }catch(SQLException e){
            System.out.println("unable to retrive messages");
            System.out.println(e);
        }
    }
    
    public static void deleteMessageDB(int id_message){
        Connection db_connect = new Connection();
        
        try(Connection connection = db_connect.get_connection())  {
        PreparedStatement ps=null;
        
            try {
                String query="DELETE FROM messages WHERE id_menssage = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("deleted message");
            }catch(SQLException e) {
                System.out.println(e);
                 System.out.println("unable t delete message");
            }
        
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void actualizarMensajeDB(Messgae message){
        Connection db_connect = new Connection();
        
        try(Connection conexion = db_connect.get_connection())  { 
        PreparedStatement ps=null;
        
            try{ 
                String query="UPDATE messages SET message = ? WHERE id_message = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, message.getMensaje());
                ps.setInt(2, message.getId_mensaje());
                ps.executeUpdate();
                System.out.println("message updated correctly");
            }catch(SQLException ex){ 
                System.out.println(ex);
                System.out.println("unable to update message");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}

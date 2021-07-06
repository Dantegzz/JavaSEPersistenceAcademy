/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dann97.messages_app;

import java.util.Scanner;

/**
 * @author Dante Gonzalez
 */
public class messagesService {
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String mensaje = sc.nextLine();
        
        System.out.println("Your name");
        String name = sc.nextLine();
        
        Messages register = new Messages();
        register.setMessage(message);
        register.setAuthor_message(name);
        MessagesDAO.createMessageDB(register);
    }
    
    public static void listMessages(){
        MessagesDAO.readMessagesDB();
    }
    public static void erraseMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide the ID to erase");
        int id_message= sc.nextInt();
        MessagesDAO.eraseMessageDB(id_message);
    }
    
    public static void editMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("write your new message");
        String message = sc.nextLine();
        
        System.out.println("select an ID to modify");
        int id_message= sc.nextInt();
        Messages update = new Message();
        update.setId_message(id_message);
        update.setMessage(message);
        MessagesDAO.updateMessageDB(update);
        
    }
    
}

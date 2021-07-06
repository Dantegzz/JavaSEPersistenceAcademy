/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dann97.messages_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author Dante Gonzalez
 */
public class Start {
    
    public static void main(String[] args){
    
       Scanner sc = new Scanner(System.in);
       
       int option=0;
       
       do{
            System.out.println("-----------------");
            System.out.println(" Messages APP");
            System.out.println(" 1. Create a Message");
            System.out.println(" 2. Show Messages");
            System.out.println(" 3. Delete Messages");
            System.out.println(" 4. Edit Messages");
            System.out.println(" 5. Exit");
            //Read User input
            option = sc.nextInt();
            
            switch (option){
                case 1:
                    messagesService.createMessage();
                    break;
                case 2:
                    messagesService.showMessage();
                    break;
                case 3:
                    messagesService.erraseMessage();
                    break;
                case 4:
                    messagesService.editMessage();
                    break;
                default:
                    break;
            }
           
       }while(option != 5);
        
       
    }
    
}

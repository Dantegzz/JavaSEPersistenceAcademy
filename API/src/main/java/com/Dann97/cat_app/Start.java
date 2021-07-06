/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.gatos_app;

import java.io.IOException;
import javax.swing.JOptionPane;


public class Start {
    
    public static void main(String[] args) throws IOException{
        int opcion_menu = -1;
        String[] opt = {" 1. see Cats", "2. ver Favorites", "3. Exit"};
        
        do{
            
            //menu principal
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos java", "Menu principal", JOptionPane.INFORMATION_MESSAGE,
                    null, opt,opt[0]);
            
            //validamos que opcion selecciona el usuario
            for(int i=0;i<opt.length;i++){
                if(opcion.equals(opt[i])){
                    opcion_menu = i;
                }
            }
            
            switch(opcion_menu){
                case 0:
                    catService.verGatos();
                    break;
                case 1:
                    cat gato = new cat();
                    catService.seeFav(gato.getApikey());
                default:
                    break;
            }     
        }while(opcion_menu != 1);
        
    }
    
}

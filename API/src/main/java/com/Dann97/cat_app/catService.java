/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dann97.cat_app;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CatService {

    private static int[] catsArray;

    public static void verGatos() throws IOException{
        //1. vamos a traer los datos de la API
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();

        Response response = client.newCall(request).execute();
        
        String elJson = response.body().string();
        
        //cortar los corchetes
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);
              
        //crear u objeto de la clase Gson
        Gson gson = new Gson();
        Cat cats = gson.fromJson(elJson, Cat.class);
        
        //redimensionar en caso de necesitar
        Image image = null;
        try{
            URL url = new URL(cats.getUrl());
            image = ImageIO.read(url);
            
            ImageIcon fondoGato = new ImageIcon(image);
            
            if(fondoGato.getIconWidth() > 800){
                //redimensionamos
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            
            String menu = "Options: \n"
                    + " 1. See other image \n"
                    + " 2. Fav \n"
                    + " 3. Go Back \n";
            
            String[] botones = { "See other Image", "Fav", "Go back" };
            String id_gato = cats.getId();
            String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones,botones[0]);
            
            int seleccion = -1;
            //Scan user option
            for(int i=0;i<botones.length;i++){
                if(opcion.equals(botones[i])){
                    seleccion = i;
                }
            }
            
            switch (seleccion){
                case 0:
                    seeCats();
                    break;
                case 1:
                    favCat(cats);
                    break;
                default:
                    break;
            }
            
        }catch(IOException e){
               System.out.println(e);
        }
        

    }

    private static void seeCats() {
    }

    public static void favCat(Cat cat) {
        try{
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\""+cat.getId()+"\"\n}");
            Request request = new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites")
              .post(body)
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", cat.getApikey())
              .build();
            Response response = client.newCall(request).execute();            
                  
        }catch(IOException e){
            System.out.println(e);
        }
  
    }

    public static void seeFav(String apikey) throws IOException{
    
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
          .url("https://api.thecatapi.com/v1/favourites")
          .get()
          .addHeader("Content-Type", "application/json")
          .addHeader("x-api-key", apikey)
          .build();

        Response response = client.newCall(request).execute();
        
        // guardamos el string con la respuesta
        String elJson = response.body().string();
        
        //creamos el objeto gson
        Gson gson = new Gson();
        
        favCat();[] catsArray = gson.fromJson(elJson,favCat();[].class);
        
        if(catsArray.length > 0){
            int min = 1;
            int max  = catsArray.length;
            int aleatorio = (int) (Math.random() * ((max-min)+1)) + min;
            int indice = aleatorio-1;
            
            favCat(); favCat(); = catsArray[indice];
            
                //redimensionar en caso de necesitar
                Image image = null;
                try{
                    URL url = new URL(favCat().image.getUrl());
                    image = ImageIO.read(url);

                    ImageIcon fondoGato = new ImageIcon(image);

                    if(fondoGato.getIconWidth() > 800){
                        //redimensionamos
                        Image fondo = fondoGato.getImage();
                        Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                        fondoGato = new ImageIcon(modificada);
                    }

                    String menu = "Options: \n"
                            + " 1. see other image \n"
                            + " 2. Delete Cat \n"
                            + " 3. Go Back \n";

                    String[] botones = { "See other image", "Delete Cat", "Go Back" };
                    String id_gato = favCat().getId();
                    String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones,botones[0]);

                    int seleccion = -1;
                    //validamos que opcion selecciona el usuario
                    for(int i=0;i<botones.length;i++){
                        if(opcion.equals(botones[i])){
                            seleccion = i;
                        }
                    }

                    switch (seleccion){
                        case 0:
                            seeCats(apikey);
                            break;
                        case 1:
                            EraseFav(favCat);
                            break;
                        default:
                            break;
                    }

                }catch(IOException e){
                       System.out.println(e);
                }
            
        }
        
    }

    public static void EraseFav(FCat gatofav){
        try{
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites/"+gatofav.getId()+"")
              .delete(null)
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", gatofav.getApikey())
              .build();

            Response response = client.newCall(request).execute();
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
}

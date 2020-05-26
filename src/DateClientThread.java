/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.net.*;
import java.io.*;

public class DateClientThread implements Runnable{
    public void run(){
        try{
            GetDate();
        }catch(InterruptedException ex){
            System.out.println("Error getting date");
        }
    }
    public void GetDate() throws InterruptedException{
        try{
            	Socket sock = new Socket ("127.0.0.1",6013);
                System.out.println("Connection au server...");
                InputStream in = sock.getInputStream();
                BufferedReader bin = new BufferedReader(
                        new InputStreamReader(in));
                Thread.sleep(1500);
                System.out.println("Connection reussie");
                String line;
                while( (line = bin.readLine()) != null)
                        System.out.println(line);
                sock.close();
        }catch(IOException ioe){
            System.out.println("error");
        }
    }
    
    public static void main(String[] args){
        Runnable runnable = new DateClientThread();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

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

public class DateServer {
    public static void main(String[] args){
        try{
            ServerSocket sock = new ServerSocket(6013);
            //listen for connection
            while(true){
                Socket client = sock.accept();
                System.out.println("Server in ON an listening on localhost:6013");
                //connected
                PrintWriter pout  = new PrintWriter(
                client.getOutputStream(), true);
                
                //write date
                pout.println(new java.util.Date().toString());
                //close socket and restart listening for connection
                client.close();
                  System.out.println("Client session is closed");
               
                
            }
        }
    catch(IOException ioe){
        System.out.println(ioe);
    }
}

}

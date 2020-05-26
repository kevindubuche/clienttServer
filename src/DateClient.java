/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.io.*;
import java.net.Socket;

public class DateClient {
    public static void main(String[] args){
        try{
            //CREATION DU SOCKET : IP + PORT
            Socket sock = new Socket("127.0.0.1",6013);
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new
                InputStreamReader(in));
            String line;
            while( (line =bin.readLine()) != null)
                System.out.println(line);
            sock.close();
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
}

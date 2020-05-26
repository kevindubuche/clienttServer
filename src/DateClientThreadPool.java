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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateClientThreadPool implements Runnable{    
	public DateClientThreadPool(String s){
        this.message=s;
    }
        private String message;
        public void run(){
            try {
                //omn  identifie le thread en cours
              System.out.println("Thread " +Thread.currentThread().getName()+" Started. ID = " + message);
              GetDate();
	      System.out.println("Thread " +Thread.currentThread().getName()+" finished)");
            }catch(InterruptedException ex){
                System.out.println("Error getting the date");
            }
        }
        public void GetDate() throws InterruptedException{
            try{
                Socket sock = new Socket ("127.0.0.1",6013);
                System.out.println("Connection au server...");
                InputStream in = sock.getInputStream();
                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
                Thread.sleep(1500);
                System.out.println("Connection reussie");
                String line;
                while( (line = bin.readLine()) != null)
                        System.out.println(line);
                sock.close();
            }catch(IOException ioe){
                System.out.println("Error");
            }
        }
        
        public static void main(String[] args){
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i=0; i< 80; i++){
                Runnable Date = new DateClientThreadPool(""+i);
                executor.execute(Date);
            }
            executor.shutdown();
            while(!executor.isTerminated()){
                
            }
            System.out.println("Finished all thread");
        }
}

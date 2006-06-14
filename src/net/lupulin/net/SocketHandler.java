/* SocketHandler.java */

package net.lupulin.net;

import java.io.*;
import java.net.*;

public class SocketHandler extends Thread {

    public Socket incoming;

    public SocketHandler(Socket incoming) {
        this.incoming = incoming;
    }

    public void run() {
        try {
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        
            PrintStream out =
                new PrintStream(incoming.getOutputStream());
	    
            out.println("enter \"exit\" to exit...");
	    
            boolean done = false;
            while( ! done){
                String str = reader.readLine();
                if( str == null ) 
                    done = true;
                else {
                    out.println("this: " + str);
                    System.out.println("this: " + str);
                    if( str.trim().equals("exit") ){
                        done = true;
                    }
                }
		
            }
            incoming.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}


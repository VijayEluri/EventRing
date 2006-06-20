/* ERSSocketHandler.java */

package net.lupulin.net;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import net.lupulin.event.EventRing;

public class ERSSocketHandler extends Thread {

    public Socket incoming;
    private EventRing ER;
    
    public ERSSocketHandler(Socket incoming, EventRing er) {
        this.incoming = incoming;
        this.ER = er;
    }

    private void process_input( String input ){
        
    }
    
    public void run() {
        try {
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        
            PrintStream out = new PrintStream(incoming.getOutputStream());
	    
            //out.println("ERS: enter \"exit\" to exit...");
            out.println("^:READY:$");
	    
            boolean done = false;
            while( ! done){
                String str = reader.readLine();
                if( str == null ) 
                    done = true;
                else {
                    out.println("this: " + str);
                    out.println( ER.get(1).toString() );
                    System.out.println("ERS: " + str);
                    System.out.println( "ER.size(): " + ER.size());
                    System.out.println( ER.get(1).toString() );
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


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

    private boolean process_input( PrintStream out, String input ){

        //boolean ret_val = false;
        boolean done = false;
        
        input = input.trim();
        
        if( input == null ){ 
            done = true;
        }
        System.out.println("input: " + input);
        //System.out.println( ER.get(1).toString() );
        
        
        if(        input.equals( "^:QUIT:$" ) || input.equals( "quit" ) ){
            done = true;
        } else if( input.equals( "^:GET:$" ) || input.equals( "get" ) ){
            out.println( ER.get_random().toString() );
            //out.println( ER.get(0).toString() );
        } else if( input.equals( "^:KILL:$" ) || input.equals( "kill" )){
            //kill server
        } else if( input.equals( "^:QUERY:$" ) || input.equals( "query" )){
            //query server for options (event-encoded-of-course)
            out.println( "^:QUIT::QUERY::GET::KILL:$" );
        } else {
            out.println( "^:UNKNOWN:$" );
        }
        
        return done;
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
                
                System.out.println("recvd [" + str + "]" );
                done = process_input( out, str );
            }
            
            incoming.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}


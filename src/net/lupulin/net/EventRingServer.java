/* EventRingServer.java */

package net.lupulin.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import net.lupulin.event.EventRing;

public class EventRingServer {
    
    private EventRing event_ring;
    private int port = 6160;
    //private int PORT = 6160; //default (for now)
    private ServerSocket server_sock;
    //private String conf_file = null;
  
    //contructor
    public EventRingServer(){}
    public EventRingServer(int port){
        this.port = port;
        //this.PORT = port;
    }

    public void set_ER( EventRing event_ring ){
        this.event_ring = event_ring;
    }
    
    /* -- */
    public boolean setup_server() {
        try {
            server_sock = new ServerSocket( port );
        } catch(IOException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    /* -- */
    public void start_server(){  
    
        while (true) {  
            Socket incoming = null;
            try {
                incoming = server_sock.accept();
            } catch(IOException e) {
                System.out.println(e);
                continue;
            }

            new ERSSocketHandler( incoming, event_ring ).start();
        }
    }
        
 
}

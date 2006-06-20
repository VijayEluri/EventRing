/* MultiSocketServer */

package net.lupulin.net;

import java.io.*;
import java.net.*;

public class MultiSocketServer {
    
    private int PORT = 6160; //default (for now)
    private ServerSocket server_sock;
    private String conf_file = null;
    
    public MultiSocketServer(){
    }
    public MultiSocketServer(int PORT){
        this.PORT = PORT;
    }
    
    /* -- */
    public boolean setup() {
        try {
            server_sock = new ServerSocket( PORT );
        } catch(IOException e) {
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    /* -- */
    public void start(){  
    
        while (true) {  
            Socket incoming = null;
            try {
                incoming = server_sock.accept();
            } catch(IOException e) {
                System.out.println(e);
                continue;
            }

            new ERSSocketHandler(incoming).start();
        }
    }
        
 
}


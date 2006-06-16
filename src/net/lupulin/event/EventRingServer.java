/* EventRingServer.java */

package net.lupulin.event;

import net.lupulin.net.MultiSocketServer;

public class EventRingServer {

    private EventRing ER;
    private int port;
    private MultiSocketServer sock_obj;

    //contructor
    public EventRingServer(){}
    public EventRingServer(int port){
        this.port = port;
        sock_obj = new MultiSocketServer(port);
    }

    public void set_ER( EventRing ER ){
        this.ER = ER;
    }

    public void start_server(){
        sock_obj.setup();
        sock_obj.start();
    }
}

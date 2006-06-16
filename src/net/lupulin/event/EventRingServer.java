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
        //this.name = name;
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

/*
 * after we fall to the heavens , we go to the shroud , and then where are we.
 * but gone, to always gone and leaving. to 
 * 
 */

/*
 * for seven starts in the abyss            
 * 
 */

/*
 * there are reasons to go further than you would want to go
 * and in goming futher you will be gone forever from the eyes of god and men
 * you don't know  where you go and   what you speak of , yet you insist on going to the 
 * end of it all
 * 
 */


/* ers_test.java */

import net.lupulin.event.EventRingServer;
import net.lupulin.net.MultiSocketServer;
import net.lupulin.net.SocketHandler;


public class  ers_test {
    public static void main(String[] args ){

        int port = 6061;
        EventRingServer ers = new EventRingServer("Ers-1",port);
        System.out.println("main...");

        ers.start_server();


        System.out.println("done.");        
    }
}   

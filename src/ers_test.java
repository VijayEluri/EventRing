/* ers_test.java */

import net.lupulin.event.EventRingServer;
import net.lupulin.event.EventRing;
import net.lupulin.event.MidiEvent;
import net.lupulin.net.MultiSocketServer;
import net.lupulin.net.SocketHandler;


public class  ers_test {
    public static void main(String[] args ){

        int port = 6061;
        EventRing er = new EventRing();
        EventRingServer ers = new EventRingServer("Ers-1",port);
        System.out.println("main...");

        er.get_events_from_file( "/home/wise/workspace/er_java/data/ev_file.txt" );

        //System.out.println("-2-");
        ers.set_ER( er );

        MidiEvent mev = null;
        for(int i=0; i< er.size(); i++ ){

            mev = (MidiEvent)er.get(i);
            System.out.println( mev.getData().toString() );

        }

        //ers.start_server();


        System.out.println("done.");        
    }
}   

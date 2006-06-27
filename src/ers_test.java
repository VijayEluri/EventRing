/* ers_test.java */

import net.lupulin.net.EventRingServer;
import net.lupulin.event.EventRing;
import net.lupulin.event.EventRingFile;
//import net.lupulin.event.MidiEvent;
import net.lupulin.event.AbsEvent;
//import net.lupulin.net.MultiSocketServer;
//import net.lupulin.net.SocketHandler;


public class  ers_test {
    public static void main(String[] args ){
        String ev_file = "/home/wise/workspace/er_java/data/ev_file.txt";
        EventRing er = new EventRing(EventRingFile.GetDataFromFile(ev_file));

        int port = 6061;
        EventRingServer ers = new EventRingServer(port);        
        ers.set_ER( er );

        AbsEvent mev = null;
        for(int i=0; i< er.size(); i++ ){

            mev = (AbsEvent)er.get(i);
            System.out.println( mev.getData().toString() );

        }

        ers.setup_server();
        ers.start_server();

        System.out.println("done.");        
    }
}   








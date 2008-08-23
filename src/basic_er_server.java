/* basic_er_server.java */

import net.lupulin.net.EventRingServer;
import net.lupulin.event.EventRing;
import net.lupulin.event.MidiEventGenerator;

public class  basic_er_server 
{
    public static void main(String[] args)
    {
        EventRing er = new EventRing();
        EventRingServer ers = new EventRingServer(60061);        
        MidiEventGenerator meg = new MidiEventGenerator();

        ers.set_ER( er );

        for(int i=0; i< 999; i++){
            er.add( meg.getRandMidiEvent() );
        }

        for(int i=0; i<er.size(); i++){
        	System.out.println( er.get(i).toString() );
        }

        ers.setup_server();
        ers.start_server();
    }
}   








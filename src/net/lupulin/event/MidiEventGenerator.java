/* MidiEventGenerator.java */

package net.lupulin.event;

import java.util.Random;
import java.util.HashMap;

public class  MidiEventGenerator {
    
    Random rand;

    //HashMap midi_hash = null;

    MidiEvent place_holder ;

    public MidiEventGenerator(){
        rand = new Random();
        //midi_hash = new HashMap();
        place_holder = new MidiEvent();
    }   
    
    public void test(){
        System.out.println(  random_midi_note() );
    }

    private int rand_0_127(){
        return rand.nextInt(128); /* 0-127 */
    }

    private int random_midi_note(){
        return rand_0_127();
    }   
    
    public MidiEvent randMidiEvent(){
        MidiEvent me = new MidiEvent();

        return me;
    }
    
}

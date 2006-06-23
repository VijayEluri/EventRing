/* MidiEventGenerator.java */

package net.lupulin.event;

import java.util.Random;
import java.util.HashMap;

public class  MidiEventGenerator {
    
    Random rand = null;

    HashMap midi_hash = null;

    public MidiEventGenerator(){
        rand = new Random();
        midi_hash = new HashMap();
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
    
}


package net.lupulin.event;

import java.util.Random;
import java.util.HashMap;

public class  MidiNoteGenerator {
    
    Random rand = null;

    HashMap midi_hash = null;

    public MidiNoteGenerator(){
        rand = new Random();
        midi_hash = new HashMap();
    }   
    
    /*  as d asd a d asd as d */

    public void test(){
        System.out.println(  random_midi_note() );
    }

    private int random_midi_note(){
        return rand.nextInt(128); /* 0-127 */
    }   
    
}

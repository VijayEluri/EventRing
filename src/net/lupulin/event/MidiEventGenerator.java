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
    }   

    public void test(){
        System.out.println(  random_midi_note() );
    }

    private int rand_0_127(){
        return rand.nextInt(128); /* 0-127 */
    }

    private int rand_0_15(){
        return rand.nextInt(16); /* 0-15 */
    }

    private int random_midi_note(){
        return rand_0_127();
    }   

    public MidiEvent getRandMidiEvent(){
        MidiEvent me = new MidiEvent();

        int note  =  rand_0_127();    
        int dur   =  rand_0_127();  
        int vel   =  rand_0_127();  
        int chan  =  rand_0_15();   

        me.set_note(note);
        me.set_duration(dur);
        me.set_velocity(vel);
        me.set_channel(chan);
        
        return me;
    }
    
}

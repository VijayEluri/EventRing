/* MidiEvent.java */

package net.lupulin.event;

public class MidiEvent extends AbsEvent {
    
    final static public String EVENT_TYPE = "MidiEvent"; 
    
    //private String ascii_rep;
    private AsciiRep ascii_rep = null;

    //constructor
    public MidiEvent(){}
    public MidiEvent( AsciiRep ascii_rep ){
        this.ascii_rep = ascii_rep;
    }

    public void set_ascii_rep( AsciiRep ascii_rep ){
        this.ascii_rep = ascii_rep;
    }
    
}   

/* MidiEvent.java */

package net.lupulin.event;

public class MidiEvent extends AbsEvent {
    final static public String EVENT_TYPE = "MidiEvent"; 

    //constructor
    public MidiEvent(){}
    public MidiEvent( AsciiRep ascii_rep ){
        super( ascii_rep );
    }
    
    public void print(){
        System.out.println( data.toString());
    }
}   

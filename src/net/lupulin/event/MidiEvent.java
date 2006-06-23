/* MidiEvent.java */

package net.lupulin.event;

public class MidiEvent extends AbsEvent {
    final static public String EVENT_TYPE = "MidiEvent"; 

    private int note;
    private int duration;
    private int velocity;
    
    //constructor
    public MidiEvent(){}
    public MidiEvent( AsciiRep ascii_rep ){
        super( ascii_rep );
    }
    
    public void print(){
        System.out.println( data.toString());
    }
}   

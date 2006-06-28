/* MidiEvent.java */

package net.lupulin.event;

public class MidiEvent extends AbsEvent {
    final static public String EVENT_TYPE = "MidiEvent"; 

    private int note;      // 0 - 127
    private int duration;  // 0 - 127
    private int velocity;  // 0 - 127
    private int channel;   // 0 - 15
    
    //constructor
    public MidiEvent(){}
    public MidiEvent( AsciiRep ascii_rep ){
        super( ascii_rep );
    }
    
    public void print(){
        System.out.println( data.toString());
    }
}   

/* MidiEvent.java */

package net.lupulin.event;

public class MidiEvent extends AbsEvent {
    
    final static public String EVENT_TYPE = "MidiEvent"; 
    
    //do this in AbsEvent
    //private AsciiRep ascii_rep;

    //constructor
    public MidiEvent(){}
    public MidiEvent( AsciiRep ascii_rep ){
        super( ascii_rep );
        //this.ascii_rep = ascii_rep;
        //System.out.println( ascii_rep.toString()+"POOP");
    }
    
    public void print(){
        //System.out.println( ascii_rep.toString());
        System.out.println( data.toString());
    }
    
}   

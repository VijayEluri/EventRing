/* MidiEvent.java */

package net.lupulin.event;

public class MidiEvent extends AbsEvent {
    final static public String EVENT_TYPE = "MidiEvent"; 

    private int note;      // 0 - 127
    private int duration;  // ?
    private int velocity;  // 0 - 127
    private int channel;   // 0 - 15
    
    //constructor
    public MidiEvent(){}
    public MidiEvent( AsciiRep ascii_rep ){
        super( ascii_rep );
    }
    
    public String toString(){
        return(
            "[note:" + note     +    
            " dur:"  + duration +
            " vel:"  + velocity +
            " chan:" + channel  + "]" );
    }
            

    public void set_note(int note){
        this.note = note;
    }
    public void set_duration(int dur){
        this.duration = dur;
    }
    public void set_velocity(int vel){
        this.velocity = vel;
    }
    public void set_channel(int chan){
        this.channel = chan;
    }


}   

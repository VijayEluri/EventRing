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

        if( data == null ){
            setAsciiRep();
        }

        return super.toString();

        /*
          return(
          "[note:" + note     +
          " dur:"  + duration +
          " vel:"  + velocity +
          " chan:" + channel  + "]" );
        */
    }

    public void setAsciiRep(){
        AsciiRep ar = new AsciiRep();
        String ar_str;
        char sep = ar.getSep();

        ar_str = "^" + sep +
            "NOTE" + sep + Integer.toString(note)     + sep +
            "DUR"  + sep + Integer.toString(duration) + sep +
            "VEL"  + sep + Integer.toString(velocity) + sep +
            "CHAN" + sep + Integer.toString(channel)  + "$" ;
        try{
            ar.setData( ar_str );
            setData( ar );
        } catch( EventException e){
            setData( null );
            System.out.println( e.toString() );
        }

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

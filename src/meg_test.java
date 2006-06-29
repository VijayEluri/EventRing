/* meg_test.java */

import net.lupulin.event.*; 

public class  meg_test {
    public static void main( String[] args ){
        MidiEventGenerator meg = new  MidiEventGenerator();
        MidiEvent me = null;
        for( int i=0; i< 20; i++ ){
            me = meg.getRandMidiEvent();
            System.out.println( me.toString() );
            if( (i % 2) == 0 ){
                me.setAsciiRep();
                System.out.print( me.toString() );
                System.out.println("--");
            }
        }
    }
}   

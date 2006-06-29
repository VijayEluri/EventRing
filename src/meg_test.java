/* meg_test.java */

import net.lupulin.event.*; 

public class  meg_test {

    public static void main( String[] args ){

        System.out.println("meg-test...");

        MidiEvent me = new MidiEvent();
        MidiEventGenerator meg = new  MidiEventGenerator();



        MidiEvent me1 = meg.getRandMidiEvent();

        System.out.println( me1.toString() );


        for( int i=0; i< 20; i++ ){
            System.out.println( meg.getRandMidiEvent().toString() );
        }

    }


}   

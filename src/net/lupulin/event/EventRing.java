/* EventRing.java */

package net.lupulin.event;

import java.util.LinkedList;
import java.util.Random;

/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
*/

public class EventRing {
    
    private LinkedList ev_ring; 
    private Random rand;

    //contructor
    public EventRing(){
        ev_ring = new LinkedList();
        rand = new Random();
    }
    public EventRing(LinkedList ev_ring){
        this.ev_ring = ev_ring;
        rand = new Random();
    }
    
    public void add(AbsEvent ev){
        ev_ring.add( ev );
    }
    public void remove(int idx){
        ev_ring.remove(idx);
    }
    public AbsEvent get(int idx){
        return (AbsEvent)ev_ring.get(idx);
    }

    public AbsEvent get_random(){
        int r = rand.nextInt( ev_ring.size() );
        return (AbsEvent)ev_ring.get(r);
    }

    /*
    public void get_events_from_file(String ev_file){
        ev_ring = EventRingFile.GetDataFromFile( ev_file );
        
        AsciiRep ar = null;
        MidiEvent ev = null;

        //AsciiRep ar_arr
        //System.out.println("here in file reader ...");
        BufferedReader file_in = null;
        String line_in = null;
        try{
            file_in = new BufferedReader(new FileReader(ev_file));
            try{
                while (( line_in = file_in.readLine()) != null) {  
                    //System.out.println(  "#" + line_in + "#" );
                    try {
                        ar = null;
                        ar = new AsciiRep(line_in);
                        //ar.setData( line_in );
                        //System.out.println( "ar.toString(): " + ar.toString() );
                        ev = null;
                        ev = new MidiEvent( ar );
                        //System.out.println( "ev.toString(): " + ev.toString() );
                        //ev.print();
                        ev_ring.add( ev );
                    } catch( EventException e){
                        System.out.println( e.toString());
                    }
                }
            }
            catch( IOException e){
                System.out.println( e.toString() );
            }                

        } catch(FileNotFoundException e){
            System.out.println( e.toString() );
        }
        
        if( file_in != null){
            try{
                file_in.close();
            } catch( IOException e){}
        }
       
    }*/
    

    public int size(){
        return ev_ring.size();
    }

}   

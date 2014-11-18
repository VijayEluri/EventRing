package net.lupulin.event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedList;

public class EventRingFile {
    //public String filename;
    
    public static LinkedList<AbsEvent> GetDataFromFile( String ev_file ){

        LinkedList<AbsEvent> ev_ring_data = new LinkedList<AbsEvent>();
        //EventRing  er = null;
        AsciiRep ar = null;
        AbsEvent ev = null;

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
                        ev = new AbsEvent( ar );
                        //System.out.println( "ev.toString(): " + ev.toString() );
                        //ev.print();
                        ev_ring_data.add( ev );
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
        
        return ev_ring_data;
    }
}

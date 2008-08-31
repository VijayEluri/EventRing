/* hr_test.java */

import java.io.*;

import net.lupulin.event.*; 

public class  hr_test {

    public static void main( String[] args ){

        System.out.println();
        System.out.println("hr-test...");
        System.out.println();
        System.out.println();
        
        AsciiRep ar1 = new AsciiRep();
        AsciiRep ar2 = null;
    
        HashRep hr = new HashRep();
        
        //setup a HashRep ...
        hr.put( "n-1", "v-1" );
        hr.put( "n-2", "v-2" );
        hr.put( "n-3", "v-3" );
        hr.put( "n-4", "v-4" );
        hr.put( "n-5", "v-5" );
        hr.put( "n-6", "v-6" );

//      check some vals of the HashRep
        System.out.println();
        System.out.println();
        System.out.println( "check some vals of the HashRep:" );
        System.out.println( hr.get( "n-1" ));
        System.out.println( hr.get( "n-2" ));
        System.out.println( hr.get( "probabl-not-1" )); //this should be null
        System.out.println();
        System.out.println();
        
        //convert to an AsiiRep
        ar2 = hr.toAsciiRep();
        System.out.println();
        System.out.println( "converted to AsciiRep:" );
        ar2.printData();

        //HashRep hr2 = new HashRep( ar2 );
        HashRep hr2 = new HashRep();
        System.out.println();
        System.out.println( "AsciiRep back to HashRep:" );
        hr2.readAsciiRep( ar2 );
        hr2.printData();
        
        //----------------------------------
        System.out.println();
        System.out.println( "AsciiRep back to HashRep via constructor ..." );
        AsciiRep ar3 = new AsciiRep();
        ar3.printData();
        
        HashRep hr3 = new HashRep( ar2 );

        hr3.printData();
        
        
    }

}   

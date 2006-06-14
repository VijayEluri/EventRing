/* arhr_test.java */

import java.io.*;

import net.lupulin.event.*; 
import net.lupulin.event.util.*; 

public class  arhr_test {

    public static void main( String[] args ){
        System.out.println("arhr-test...");
        System.out.println();


        HashRep h2 = new HashRep();
        //setup a HashRep ...
        h2.put( "n-1", "v-1" );
        h2.put( "n-2", "v-2" );
        h2.put( "n-3", "v-3" );
        h2.put( "n-4", "" );
        h2.put( "n-5", "v-5" );
        h2.put( "n-6", "v-6" );
        h2.put( "n-6", "poop" );
        System.out.println( "h2: " + h2.toString() );
        


        String s1 = "^:asdasd:qweqwe:xcxcv:$"; 
        try{
            AsciiRep a1 = new AsciiRep( s1 );
            HashRep h1 = new HashRep( a1 );
        }
        catch( Exception e){
            System.out.println( e.toString() );
        }


        /*
          System.out.println( s5 );
          System.out.println("HERE2------>!");        
          AsciiRep a5 = new AsciiRep( s5 );
          System.out.println();
        */
        
        //System.out.println( "validate_key( " + hr1.validate_key( "" ) + " )");

        /*
          System.out.println("--VALIDATE--");
          System.out.println( a5.validate() );
          System.out.println("--VALIDATE--");
          System.out.println( a6.validate() );
          System.out.println( a6.toString() );
          System.out.println( hr1.toString() );        
        */

    }

}   

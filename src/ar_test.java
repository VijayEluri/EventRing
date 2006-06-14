/* ar_test.java */

import java.io.*;

import net.lupulin.event.*; 

public class  ar_test {

    public static void main( String[] args ){

        System.out.println("ar-test...");

        String s1 = "^:::asdasd:qweqwe:xcxcv:ytutyu$";
        String s2 = ":::asdasd:asda::asdad:" ;
        String s3 = "^:asdasd:qweqwe:xcxcv:ytutyu$";
        String s4 = "^:asdasd:qweqwe$";
    
        //er-test: event-ring
	//$(GCJ) -C -d $(BUILD) $(SRC)/er_test.java

  
        try{
            AsciiRep ar1 = new AsciiRep( s1 );
            AsciiRep ar2 = new AsciiRep( s2 );
            AsciiRep ar3 = new AsciiRep( s3 );
            AsciiRep ar4 = new AsciiRep( s4 );
            
            ar1.printData();
            System.out.println( ar2.getData() );
            
            if( ar1.validate() ){
                System.out.println( "ar1-VALID" );
            } else {
                System.out.println( "ar1-INVALID" );
            }        
            
            
            if( ar2.validate() ){
                System.out.println( "ar2-VALID" );
            } else {
                System.out.println( "ar2-INVALID" );
            }        
            
            
            if( ar3.validate() ){
                System.out.println( "ar3-VALID" );
            } else {
                System.out.println( "ar3-INVALID" );
            }        
        } catch( EventException e){
            System.out.println( e.toString() );
        }


        if( ar4.validate() ){
            System.out.println( "ar4-VALID" );
        } else {
            System.out.println( "ar4-INVALID" );
        }        



    }

}   

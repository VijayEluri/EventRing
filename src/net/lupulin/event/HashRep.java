/* HashRep.java */

package net.lupulin.event;

import java.util.HashMap;
import java.util.Iterator;
//import java.util.Set;

public class HashRep {
    
    private HashMap data = null;
    private char sep = ':';

    //constructor
    public HashRep(){
        data = new HashMap(); 
    }
    public HashRep( HashMap data ){
        //need a vaildate() method to validate all cells.
        //accepting the AsciiRep
        this.data = data;
    }
    public HashRep( AsciiRep ar ){
        data = new HashMap(); 
        try {
            readAsciiRep( ar );
        } 
        catch( EventException e){
            System.out.println( e.toString() );
        }
    }

    public void printData(){
        Iterator it = data.keySet().iterator();
        String key = null;
        //for (String key : data.keySet()) {
        while( it.hasNext() ){
            key = (String)it.next();
            System.out.println( "key: " + key + " val: " + data.get(key));
        }
    }

    public void setSep( char sep ){
        this.sep = sep;
    }

    public void readAsciiRep( AsciiRep ar )
        throws EventException {
        //need to somehow call AsciiRep's validate() method before 
        //accepting the AsciiRep

        //strip the outer "^" and "$" , and majke sure thats what they are
        String ar_str = new String( ar.getData() );
        char begin = ar_str.charAt( 0 );
        char end   = ar_str.charAt( ar_str.length() - 1 );
        if( (begin != '^') || (end != '$') ){
            throw new EventException("bad formatting WRT ^ and $ in HashRep::readAsciiRep()");
        }
        String tmp_str_1 = new String( ar_str.substring( 2, ar_str.length()-1 ));
        
        String[] split_arr = tmp_str_1.split( ":" );
        boolean even = true;
        String key = null;
        
        String elem = null;
        //for( String elem : split_arr ) {
        //while( it.hasNext() ){
        for( int i=0; i<split_arr.length; i++ ){  
            elem = split_arr[i];
            if( even ){
                key = elem;
                even = false;
            } else {
                put( key, elem );
                even = true;
            }
        }
    }

    public String toString(){
        AsciiRep tmp_ar = toAsciiRep();
        return tmp_ar.toString();
    }

    public AsciiRep toAsciiRep(){
        StringBuffer buf = new StringBuffer();

        boolean first_run = true;
        Iterator it = data.keySet().iterator();
        String key = null;
        //for (String key : data.keySet()) {
        while( it.hasNext() ){
            key = (String)it.next();
            String val = (String)data.get(key);
            if( first_run ){
                buf.append( "^" );
                first_run = false;
            }
            buf.append( sep + key + sep + val );
        }

        buf.append( '$' );

        try{
            AsciiRep tmp_ar = new AsciiRep( buf.toString() );
            return tmp_ar;
        }
        catch( EventException e){
            System.out.println( e.toString());
            return null;
        }
    }


    //exception land...
    public void put( String key, String val ){
        //need to call validate_key(), and validate_val();
        if( validate_key(key) && validate_val(val) ){
            data.put( key, val );
            //return true;
        } else {
            System.out.println("key/val not valid!!!");
            //return false;
        }
    }
    public boolean validate_key( String key ){
        //cannot be blank, and cannot contain any "sep" chars
        if( (key.indexOf(sep ) == -1) &&
            (key.length()      >  0 )    ){
            return true;
        } else {
            //System.out.println("sep in key-STR !!");
            //System.out.println( "len -" + key.length() );            
            return false;
        }
    }
    public boolean validate_val( String val ){
        //cannot contain any "sep" chars (can be blank?)
        if( val.indexOf(sep) == -1 ){
            return true;
        } else {
            //System.out.println("sep in val-STR !!");
            return false;
        }
    }

    public String get( String key ){
        return( (String)data.get( key ) );
    }

    public String remove( String key ){
        return( (String)data.remove( key ) );
    }

    public static void test(){
        System.out.println("test...HashRep");
    }
    
    public HashMap getData(){
        return data;
    }
    
    public void setData( HashMap  data){
        this.data = data;
    }
    
}   


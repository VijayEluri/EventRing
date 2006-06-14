/* AsciiRep.java */

package net.lupulin.event;

import java.util.HashSet;

import net.lupulin.event.util.StringUtil;

public class AsciiRep {
    
    private String data = null;
    private char sep = ':';

    //constructor
    public AsciiRep(){}
    public AsciiRep(String data)
        throws EventException {
        this.data = data;
        if( ! validate() ){
            throw new EventException("ascii-string did not validate() in constructor");
        }
    }

    public String toString(){
        return data;
    }

    public boolean validate(){
        return validate_new();
    }

    public boolean validate_new(){
        return StringUtil.validate( data, sep );
    }

    //we want to stop using this one
    public boolean validate_old(){
        boolean ret_val = false;
            
        // 1 -- check that its surrounded by "^" and "$"
        char begin = data.charAt( 0 );
        char end   = data.charAt( data.length() - 1 );
        if( (begin != '^') || (end != '$') ){
            System.out.println( "BAD" );
            return( false );
        } 
        // tmp_str_1 is now the String stripped of the outer "^" and "$"
        String tmp_str_1 = new String( data.substring( 2, data.length()-1 ));
        



        // 2 -- check thet there are an even number of elements 
        //     ( key/values come in pairs )

        /* StringUtil */

        String[] split_arr = tmp_str_1.split( Character.toString(sep) );
        if( (split_arr.length % 2) == 0 ){
            ret_val = true;
        } else {
            System.out.println( "BAD-NUM" );            
            return( false );
        }

        // 3 -- check that the "key" parts are unique and non-blank
        boolean even = true;
        HashSet hs = new HashSet();
        //for( String elem : split_arr ) {
        for( int i=0; i< split_arr.length; i++ ){
            String elem = split_arr[i];
            //check to see if elem is any prvious "even" position of the arr
            if( even ){
                if( hs.contains( elem ) ){
                    System.out.println("NAME-REUSE!!!");
                    return( false );
                }
                if( elem.equals("") ){
                    System.out.println("NAME-BLANK!!!");
                    return( false );
                }
                hs.add( elem );
                even = false;
            } else {
                even = true;
            }
        }
        ret_val = true;

        // 4 -- exception case #1 -- $sep char can be the last char between ^ and $, and still pass as 
        //    due to the way substring() parses out the parts.
        //    (I'm just gonna check for that last $sep on the string, and call INVALID if its there.)
        //    ((furthermore this check should come earlier, but since its a hack-fix, its going here.))
        end   = tmp_str_1.charAt( tmp_str_1.length() - 1 ); //end is re-used from above
        if( end == sep ){
            System.out.println( "BAD-ending sep string-:" );
            return( false );
        }
        
        return ret_val;

    }
    
    public void setSep( char sep ){
        this.sep = sep;
    }

    public static void test(){
        System.out.println("test...AsciiRep");
    }
    
    public void printData(){
            System.out.println( "data: "+ data );
    }
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
}   

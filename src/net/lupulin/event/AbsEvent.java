/* AbsEvent.java */

package net.lupulin.event;

import java.util.HashMap;
//import net.lupulin.event.util.StringUtil;

public abstract class AbsEvent {
    
    //event info stuff
    final static public String EVENT_TYPE = "AbsEvent"; 
    protected String name = "noname";
    protected AsciiRep data = null;
    protected HashMap event_info = null; 
    protected char sep = ':';

    //constructor
    public AbsEvent(){}
    public AbsEvent( AsciiRep ar ){
        data = ar;
    }
    
    public void test(){
        System.out.println("test...AbsEvent");
    }
    public void print_name(){
            System.out.println( "name: " + name );
    }

    public String toString(){
        if( data != null){
            return( data.toString() );
        } else {
            return "NULL";
        }
    }
    
    public AsciiRep getData(){
        return data;
    }
    
    public void setData(AsciiRep ar){
        data = ar;
    }
    
}   


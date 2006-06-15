/* AbsEvent.java */

package net.lupulin.event;

import java.util.HashMap;

public abstract class AbsEvent {
    
    //event info stuff
    final static public String EVENT_TYPE = "AbsEvent"; 
    protected String name = "noname";
    protected AsciiRep data;
    //protected HashMap event_info; 
    protected char sep = ':';

    //constructor
    public AbsEvent(){}
    public AbsEvent( AsciiRep ar ){
        data = ar;
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


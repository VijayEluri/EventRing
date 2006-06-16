/* AbsEvent.java */

package net.lupulin.event;

//import java.util.HashMap;

public class AbsEvent {
    final static public String EVENT_TYPE = "AbsEvent"; 
    
    protected AsciiRep data;
    //protected char sep = ':';

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


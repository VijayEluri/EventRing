/* Type2Event.java */

package net.lupulin.event;

public class Type2Event extends AbsEvent {
    
    final static public String EVENT_TYPE = "Type2Event"; 
    
    //contructor
    public Type2Event(){}
    public Type2Event(String name){
        this.name = name;
    }
}   

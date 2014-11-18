/* Type1Event.java */

package net.lupulin.event;

import java.util.Vector;

public class Type1Event extends AbsEvent {

    final static public String EVENT_TYPE = "Type1Event";

    //private Vector<int> msg = null;

    //constructor
    public Type1Event(){}
    //public Type1Event(String name){
    //    this.name = name;
    //}

    public void zero(){
        //msg = null;
    }

    public void addByte(int b){

    }

}



/*
 * eliminate the diry higher bytes data just mask the integer with a logic AND operation,
 * for example:
 * int unsignedbyte = ...; unsignedbyte = unsignedbyte & 0x000000FF;
 * That will only let the less significant byte exist.
 */


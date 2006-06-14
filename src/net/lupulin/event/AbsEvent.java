/* AbsEvent.java */

package net.lupulin.event;

import java.util.HashMap;

public abstract class AbsEvent {
    
    //event info stuff
    final static public String EVENT_TYPE = "AbsEvent"; 
    protected String name = "noname";
    protected String data = "nodata";
    protected HashMap event_info = null; 
    
    //constructor
    public AbsEvent(){}
    public AbsEvent(String name){
        this.name = name;
    }
    
    public void test(){
        System.out.println("test...AbsEvent");
    }
    public void print_name(){
            System.out.println("name: "+name);
    }
    public String serializeToString(){
        StringBuffer str_buf = new StringBuffer();
        str_buf.append(this.name);
        return str_buf.toString();
    } 
    public String toString(){
        return(":"+name+":");
    }
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
}   


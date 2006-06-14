/* EventRing.java */

package net.lupulin.event;

import java.util.LinkedList;

public class EventRing {
    
    //event info stuff
    private String name;
    private LinkedList ev_ring; 
    
    //contructor
    public EventRing(){
        ev_ring = new LinkedList();
    }
    public EventRing(String name){
        this.name = name;
        ev_ring = new LinkedList();
    }

    public void add(AbsEvent ev){
        ev_ring.add( ev );
    }
    public void remove(int idx){
        ev_ring.remove(idx);
    }
    public AbsEvent get(int idx){
        return (AbsEvent)ev_ring.get(idx);
    }
    public void test(){
        System.out.println("test...pkwEvent");
    }
    public int get_size(){
        return ev_ring.size();
    }
    public void print_all_event_names(){
        
    }
    public void print_name(){
            System.out.println("name: "+name);
    }
}   

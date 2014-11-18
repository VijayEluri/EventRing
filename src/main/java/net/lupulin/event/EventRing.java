package net.lupulin.event;

import java.util.LinkedList;
import java.util.Random;

public class EventRing {

    private LinkedList<AbsEvent> ev_ring;
    private Random rand;

    //contructor
    public EventRing(){
        ev_ring = new LinkedList<>();
        rand = new Random();
    }
    public EventRing(LinkedList<AbsEvent> ev_ring){
        this.ev_ring = ev_ring;
        rand = new Random();
    }

    public void add(AbsEvent ev){
        ev_ring.add( ev );
    }
    public void remove(int idx){
        ev_ring.remove(idx);
    }
    public AbsEvent get(int idx){
        return ev_ring.get(idx);
    }

    public AbsEvent get_random(){
        int r = rand.nextInt( ev_ring.size() );
        return ev_ring.get(r);
    }

    public int size(){
        return ev_ring.size();
    }

}

/* llist_test.java */

import java.util.LinkedList;

public class  ll_test {
    public static void main(String[] args ){

        System.out.println("main...");
        
        AbsEvent   aev = new AbsEvent("fehhy!!");
        Type1Event t1ev = new Type1Event("peekbo");
        EventRing er = new EventRing();
        LinkedList ev_ring = new LinkedList(); 
        
        /*
        aev.test();
        aev.print_name();
        t1ev.test();
        t1ev.print_name();
        */

        //er.add(aev);
        //er.add(t1ev);

        ev_ring.add( aev );
        ev_ring.add( t1ev );

        
        for(int i=0; i < ev_ring.size(); i++){
            AbsEvent tmp_o = (AbsEvent)ev_ring.get(i);
            tmp_o.print_name();
        }

    }
}   

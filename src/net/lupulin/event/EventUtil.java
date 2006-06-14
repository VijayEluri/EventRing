/* EventUtil.java */

package net.lupulin.event;

public class  EventUtil {
    //knownEventTypesArr
    //This is an EventRing with one of each known
    //eventtype in it.
    private EventRing knownEventTypes;

    //constructor
    public EventUtil() {
        knownEventTypes = new EventRing("EventUtil-EventRing");
        
        //populate the  event ring withone each of each
        //know  events


        /*
          AbsEvent  aev = new AbsEvent();
          knownEventTypes.add(aev);
        */
        
        Type1Event ev1 = new Type1Event();
        knownEventTypes.add(ev1);
        
        Type2Event ev2 = new Type2Event();
        knownEventTypes.add(ev2);
    }
}

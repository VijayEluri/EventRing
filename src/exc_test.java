/* exc_test.java */

import net.lupulin.event.*; 

public class exc_test {
    public static void main( String[] args ){
        System.out.println("exc_test.java ...");
        try { 
            test_fn();
        } catch (EventException e) {
            System.out.println( e.toString() );
        }
    }

    public static void test_fn() 
        throws EventException {
        System.out.println("exc_test.java ...");
        throw new EventException("EventException...");
    }        
}


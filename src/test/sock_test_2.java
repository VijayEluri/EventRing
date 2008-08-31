/* sock_test_2.java */
    
import java.io.*;
import java.net.*;

import net.lupulin.net.*; 

public class sock_test_2 {
    
    
    
    public static void main(String argv[]) {
        
        MultiSocketServer mss = new MultiSocketServer(6660);
        mss.setup();
        System.out.println("hey ...");
        mss.start();
        System.out.println("you!");
        
    }
    
    
}


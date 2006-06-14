/* testSocket1.java */

import java.io.*;
import java.net.*;

import net.lupulin.net.*; 

public class testSocket1 {
    
    
    
    public static void main(String argv[]) {
        
        MultiSocketServer mss = new MultiSocketServer();
        mss.setup();
        System.out.println("hey ...");
        mss.start();
        System.out.println("you!");
        
    }
    
    
}


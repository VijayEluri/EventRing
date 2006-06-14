/* str_util_test.java */

import java.io.*;

//import net.lupulin.event.*; 
import net.lupulin.event.util.*; 

public class str_util_test {
    public static void main( String[] args ){
        System.out.println("string-util-test...");
        System.out.println();

        String s1 = "^:asdasd:qweqwe:zxzxc:jjjj$";
        String s2 = "^:888:333:66:jj jj:t$";
        String s3 = "^:888:333:66:jj jj:t:::$";

        StringUtil.split( s1, ':');
        System.out.println();
        StringUtil.split( s2, ':');
        System.out.println();
        StringUtil.split( s3, ':');        
        System.out.println();

        StringUtil.validate( s1, ':');        
        StringUtil.validate( s2, ':');        
        StringUtil.validate( s3, ':');        


        //net.lupulin.event.util.StringUtilException; must be caught or declared to be thrown
        //public static String[] extract_regions( String str, int num_seps, char sep )
        System.out.println();
        System.out.println("-------------------------------------------");
        s1 = ":asdasd:qweqwe:zxzxc:jjjj";
        s2 = ":asdasd::zxzxc:";
        s3 = ":asdasd:asd::asd";
        int num_seps = 4;
        char sep = ':';
        String[] str_arr = null;
        try {
            str_arr = StringUtil.extract_regions( s3, num_seps, sep );
            //for( String elem : split_arr ) {
            //for( String elem : str_arr ) {
            for( int i=0; i<str_arr.length; i++ ){
                System.out.println("elem: " + str_arr[i]);
            }
        } catch( StringUtilException e ){
            System.out.println( e.toString());
        }

        String s4 = "^:asd:qwe:123:234$";
        s4 = "^$";
        sep = ':';

        System.out.println("-------------------------------------------");
        if( StringUtil.validate( s4, sep ) ){
            System.out.println( "VALIDate()" );
        } else {          
            System.out.println( "NOT VALIDate()" );
        }
        /*
          num_seps = StringUtil.count_seps( s4, sep );
          try {
          System.out.println("-- $$ --");
          str_arr = StringUtil.extract_regions( s4.substring(1,s4.length()-1), sep );
          for( String elem : str_arr ) {
          System.out.println("elem: "+elem);
          }
          } catch( StringUtilException e ){
          System.out.println( e.toString());
          }
        */


    }



}   

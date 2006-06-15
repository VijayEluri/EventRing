/* StringUtil.java */

package net.lupulin.event.util;

import java.util.HashSet;
import java.util.Iterator;

/*
  Basically, it goes like this:
  :<name-1>:<val-1>:<n2>:<v2>:...
  There is a element after every ":" (sep)
  The "val" part can be blank sp that there will be 2 seps in a row.
  (The "val" being the blank nothing that exists between the 2 seps.)
*/

public class StringUtil {

    //static String su_str = null;

    public static int count_seps( String str, char sep ){
        int num_seps = 0;
        for( int i=0; i< str.length(); i++ ){
            if( str.charAt(i) == sep ){
                num_seps++;
            }
        }
        return num_seps;
    }

    //This function is only used in extended circumstances, because we assume
    //that theres a elem for each sep, we dont have to count the elems seperatley
    private static int count_regions( String str, int num_seps, char sep ){
        int num_regions = 0;
        boolean last_char_was_sep = false; //consider the null beginning a "sep"
        for( int i=0; i<str.length(); i++ ){
            if( str.charAt(i) == sep ){ //cur-char IS a sep
                if( last_char_was_sep ){
                    num_regions++;
                }
                last_char_was_sep = true;
            } else { //cur-char is NOT a sep
                if( last_char_was_sep || (i == 0)){
                    num_regions++;
                }
                last_char_was_sep = false; 
            }
        }

        //if last char a sep, then that is a "trailing" region
        if( last_char_was_sep ){
            num_regions++;
        }

        return num_regions;
    }


    //----------------------------------  THE OLD one
    //all we do is....
    //1-start with the sep
    //  grab all chars till next sep
    //  make that a string and put into array
    //2-start over until eo-str
    //*-if theres a sep followd by a sep , then the str is empty (but there)
    //*-if theres a sep at the end , then there is a last empty str to put in array
    public static String[] extract_regions( String str, int num_seps, char sep )
        throws StringUtilException {
        String[] regions = new String[num_seps] ;
        StringBuffer str_buf = new StringBuffer("");

        //sanity-check:
        //1st char must be sep, or throw except.
        //System.out.println( "1st char|"+str.charAt(0)+" sep|"+sep);
        if( str.charAt(0) != sep ){
            throw new StringUtilException("1st char needs to be $sep in StringUtil.java");
        }

        int cur_reg_index = 0;
        boolean last_char_was_sep = true; //due to the above, and starting the index at 1
        //we wouldn;t be here if the 1st char was NOT a sep
        for( int i=1; i<str.length(); i++ ){
            //System.out.println("cur-char: " + str.charAt(i) );
            if( str.charAt(i) == sep ){ //cur-char IS a sep
                if( last_char_was_sep ){
                    //thise means a sep follows right after a sep
                    regions[cur_reg_index] = "";
                    cur_reg_index++;
                    //last_char_was_sep = false;
                } else { // gather our new string
                    regions[cur_reg_index] = str_buf.toString();                    
                    //System.out.println("regions[cur_reg_index] "+regions[cur_reg_index]);
                    cur_reg_index++;
                }
                //start over building the str_buf
                str_buf = new StringBuffer( "" );
                last_char_was_sep = true; 
            } else { //cur-char is NOT a sep
                str_buf.append(str.charAt(i));
                //System.out.println("str_buf["+str_buf+"]");
                last_char_was_sep = false; 
            }
        }

        //if last char a sep, then that is a "trailing" region
        //ALSO must get the last region
        if( last_char_was_sep ){
            //regions[num_seps-1] = "";
            regions[cur_reg_index] = "";
        } else {
            regions[cur_reg_index] = str_buf.toString();
        }

        return regions;
    }
    //
    //---------------------------------- THE NEW ONE !
    //all we do is....
    //1-start with the sep
    //  grab all chars till next sep
    //  make that a string and put into array
    //2-start over until eo-str
    //*-if theres a sep followd by a sep , then the str is empty (but there)
    //*-if theres a sep at the end , then there is a last empty str to put in array
    public static String[] extract_regions( String str, char sep )
        throws StringUtilException {
        int num_seps = count_seps( str, sep );
        String[] regions = new String[num_seps] ;
        StringBuffer str_buf = new StringBuffer("");

        //sanity-check:
        //1st char must be sep, or throw except.
        //System.out.println( "1st char|"+str.charAt(0)+" sep|"+sep);
        if( str.charAt(0) != sep ){
            throw new StringUtilException("1st char needs to be $sep in StringUtil.java");
        }

        int cur_reg_index = 0;
        boolean last_char_was_sep = true; //due to the above, and starting the index at 1
        //we wouldn;t be here if the 1st char was NOT a sep
        for( int i=1; i<str.length(); i++ ){
            //System.out.println("cur-char: " + str.charAt(i) );
            if( str.charAt(i) == sep ){ //cur-char IS a sep
                if( last_char_was_sep ){
                    //thise means a sep follows right after a sep
                    regions[cur_reg_index] = "";
                    cur_reg_index++;
                    //last_char_was_sep = false;
                } else { // gather our new string
                    regions[cur_reg_index] = str_buf.toString();                    
                    //System.out.println("regions[cur_reg_index] "+regions[cur_reg_index]);
                    cur_reg_index++;
                }
                //start over building the str_buf
                str_buf = new StringBuffer( "" );
                last_char_was_sep = true; 
            } else { //cur-char is NOT a sep
                str_buf.append(str.charAt(i));
                //System.out.println("str_buf["+str_buf+"]");
                last_char_was_sep = false; 
            }
        }

        //if last char a sep, then that is a "trailing" region
        //ALSO must get the last region
        if( last_char_was_sep ){
            //regions[num_seps-1] = "";
            regions[cur_reg_index] = "";
        } else {
            regions[cur_reg_index] = str_buf.toString();
        }

        return regions;
    }
    //----------------------------------

    //NOT USED??
    public static String[] split( String str, char sep ){
        System.out.println( "str[" + str + "]" );

        int num_seps = count_seps( str, sep );
        System.out.println( "num_seps: " + num_seps );

        //int num_regions = count_regions( str, num_seps, sep );
        //System.out.println( "num_regions: " + num_regions );       

        String[] ret_val = new String[num_seps] ;
        //for(int i=0; i<num_seps; i++){
            
        
        return ret_val;
        
    } 

    public static boolean validate( String ascii_rep, char sep ){
        //boolean ret_val = false;
        //System.out.println("here in StringUtil.valdate()...");

        // 1 -- check that its surrounded by "^" and "$"
        char begin = ascii_rep.charAt( 0 );
        char end   = ascii_rep.charAt( ascii_rep.length() - 1 );
        if( (begin != '^') || (end != '$') ){
            System.out.println( "BAD-not the wrapping meta-chars ^ and $" );
            return( false );
        } 
        // tmp_str_1 is now the String stripped of the outer "^" and "$"
        String tmp_str_1 = new String( ascii_rep.substring( 1, ascii_rep.length()-1 ));

        //EXCEPTION CASE!!!.... at the point a blank string is valid.
        //   zero key values pairs is stil even 
        if( tmp_str_1.length() == 0){
            System.out.println("a blank string is stil valid ...");
            return true;
        }

        //System.out.println("here in StringUtil.valdate()...2");

        //System.out.println("tmp_str_1:"+tmp_str_1);
        //System.out.println("ascii_rep:"+ascii_rep);
        //2 -- check that the 1st char is a sep
        //System.out.println("tmp_str_1|"+tmp_str_1);
        begin = tmp_str_1.charAt( 0 );
        //System.out.println( "begin|"+begin+" sep|"+sep);
        if( begin != sep ){
            System.out.println( "BAD-no-leading-sep" );
            return( false );
        } 
        
        //System.out.println("here in StringUtil.valdate()...3");

        // 3 -- check thet there are an even number of elements 
        //     ( key/values come in pairs )
        // this can be reduced to check for an even number of seps ...
        /* StringUtil */
        int num_seps = count_seps( tmp_str_1, sep );
        if( (num_seps % 2) != 0 ){
            System.out.println( "BAD-NUM(seps)((not-even))" );            
            return( false );
        }

        
        // 4 -- check that the "key" parts are unique and non-blank
        boolean even = true;
        HashSet hs = new HashSet();
        try {
            String[] str_arr = extract_regions( tmp_str_1, num_seps, sep );
            //Iterator str_arr_iter = str_arr.iterator();
            //for( String elem : str_arr ) {
            //for( str_arr_iter; str_arr_iter.hasNext(); ) {
            for( int i=0; i<str_arr.length; i++){
                String elem = str_arr[i];
                //check to see if elem is any prvious "even" position of the arr
                if( even ){
                    if( hs.contains( elem ) ){
                        System.out.println("NAME-REUSE!!!");
                        return( false );
                    }
                    if( elem.equals("") ){
                        System.out.println("NAME-BLANK!!!");
                        return( false );
                    }
                    hs.add( elem );
                    even = false;
                } else {
                    even = true;
                }
            }


        } catch(StringUtilException e) {
            //if extract_regions() doesn't work, then its defn. not a valid string
            System.out.println( e.toString() );
            return false;
        }

        return true;
    }
    
}


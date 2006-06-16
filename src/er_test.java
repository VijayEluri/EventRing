/* er_test.java */

import java.io.*;

import net.lupulin.event.*; 

public class  er_test {

    //Globals
    static EventRing er = new EventRing();
    static String choice = new String("blank");
    static BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args ){

        MidiEvent me1 = new MidiEvent();

        //MENU
        while(! choice.equals("q")){
            print_main_options();
            try{
                choice = userIn.readLine();
            } catch(IOException e) {
                System.out.println("error: "+e.toString());
            } finally {}
            
            if(choice.equals("a")){
                //process_add();
            } else if(choice.equals("p")){
                //process_print_all();
            } else if(choice.equals("d")){
                //process_delete_one();
            } else if(choice.equals("q")){ 
            } else if(choice.equals("u")){
                //testEventUtil();
            } else {System.out.println("bad choice...");}
        }
    }

    public static String get_name(){
        String name = new String();
        String my_choice = new String("blank");
        System.out.flush();
        try{my_choice = userIn.readLine();} 
        catch(IOException e) {System.out.println("error: "+e.toString());}
        System.out.println( "my_choice: "+ my_choice);
        return(my_choice);
    }

    public static String get_number(){
        String name = new String();
        String my_choice = new String("blank");
        System.out.flush();
        try{my_choice = userIn.readLine();} 
        catch(IOException e) {System.out.println("error: "+e.toString());}
        System.out.println( "my_choice: "+ my_choice);
        return(my_choice);
    }
 
    

    public static void print_main_options() {
        System.out.println();
        System.out.println();
        System.out.println("___________________");
        System.out.println("_ _             _ _");
        System.out.println("_ _   Options   _ _");
        System.out.println("_ _             _ _");
        System.out.println("(a)dd event");
        System.out.println("(d)elete event");
        System.out.println("(p)rint events");
        System.out.println("(1)print one event");
        System.out.println("(u)test EventUtil");
        System.out.println("(q)uit");
        System.out.print("--choose: ");
        System.out.flush();
    }

}   

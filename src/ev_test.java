import java.io.*;

import net.lupulin.event.*; 

public class  ev_test {

    //Globals
    static EventRing er = new EventRing();
    static String choice = new String("blank");
    static BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args ){
        
        //AbsEvent   aev  = new AbsEvent(   "fehhy!!");
        Type1Event t1ev = new Type1Event( "peekbo" );

        //MENU
        while(! choice.equals("q")){
            print_main_options();
            try{
                choice = userIn.readLine();
            } catch(IOException e) {
                System.out.println("error: "+e.toString());
            } finally {}
            
            if(choice.equals("a")){
                process_add();
            } else if(choice.equals("p")){
                process_print_all();
            } else if(choice.equals("d")){
                process_delete_one();
            } else if(choice.equals("q")){ 
            } else if(choice.equals("u")){
                testEventUtil();
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

    //PRINT ONE
    public static void process_print_one(){
    }
    
    //DELETE-ONE
    public static void process_delete_one(){
        int ring_size = er.get_size();
        System.out.flush();
        int selection = -1;
        String tmp = new String();
        int tmp_int;
        while( selection == -1 ){            
            System.out.println("Select event numer(1-"+ring_size+")");
            tmp = get_number();
            tmp_int = Integer.parseInt(tmp);
            System.out.println("number: ("+tmp+")"+"("+tmp_int+")");
            er.remove(tmp_int-1);
            selection = 1;
        }
    }
    
    //PRINT-ALL
    public static void process_print_all(){
        System.out.flush();

        for(int i=0; i<er.get_size(); i++){
            //t1ev.print_name();
            er.get(i).print_name();
        }
    }

    //ADD
    public static void process_add(){
        System.out.flush();
        String name = new String();
        while(! choice.equals("b")){
            print_add_options();
            try{ choice = userIn.readLine();} 
            catch(IOException e) {System.out.println("error: "+e.toString());}

            if(choice.equals("1")){
                System.out.println("enter name: ");
                System.out.flush();
                name = get_name();
                Type1Event new_ev = new Type1Event(name);
                er.add(new_ev);    
                choice = "b";
            } else if(choice.equals("2")){
                System.out.println("enter name: ");
                System.out.flush();
                name = get_name();
                Type2Event new_ev = new Type2Event(name);
                er.add(new_ev);    
                choice = "b";
            }
            System.out.flush();
        }
    }
    public static void print_add_options() {    
        System.out.println("choose type:");
//        System.out.println("(0) AbsEvent");        
        System.out.println("(1) Type1Event");        
        System.out.println("(2) Type2Event");        
        System.out.println("(b)ack");        
        System.out.print("--choose: ");
        System.out.flush();
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
    
    public static void testEventUtil(){
        System.out.println("EventUtil");
        EventUtil eu = new EventUtil();
    }
}   

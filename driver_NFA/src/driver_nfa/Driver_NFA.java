/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver_nfa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author M.Ahsan
 */
public class Driver_NFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        NFA n;
        int IS=0;
        int[] final_st = {3};
        int no_of_state=4;
        //FiniteAutomata(int S, String VC, ArrayList<struct>[] col, int IS, int[] FS)
        //NFA(int is, int[] fs, int nostate, int validlanguage,maximum entities,ArrayList<Node1>[] col) 

        ArrayList<ArrayList<node>> table=new ArrayList<>();
        for (int i = 0; i < no_of_state; i++) {
            table.add(new ArrayList<node>());
            
        }
        
        table.get(0).add(new node(0,'a'));
        table.get(0).add(new node(1,'a'));
        table.get(0).add(new node(0,'b'));
        table.get(0).add(new node(2,'b'));
        
        //2nd state
        table.get(1).add(new node(3,'a'));
        
        //3rd state
        table.get(2).add(new node(3,'b'));




        //first state
//        table.get(0).add(new node(0,'a'));
//        table.get(0).add(new node(1,'a'));
//        table.get(0).add(new node(3,'a'));
//        table.get(0).add(new node(4,'b'));
//        //second state
//        table.get(1).add(new node(2,'a'));
//        //third state
//        table.get(2).add(new node(2,'a'));
//        table.get(2).add(new node(2,'b'));
//        table.get(2).add(new node(3,'b'));
//        //fourth state
//        table.get(3).add(new node(2,'b'));
//        table.get(3).add(new node(1,'b'));
//        //fifth state
//        table.get(4).add(new node(3,'a'));
//        table.get(4).add(new node(4,'b'));

//        table.get(0).add(new node(0, 'a'));
//        table.get(0).add(new node(1, 'a'));
//        table.get(0).add(new node(3, 'a'));
//        
//        table.get(1).add(new node(2,'a'));
//        
//        table.get(2).add(new node(5,'b'));
//        
//        table.get(3).add(new node(3,'b'));
//        table.get(3).add(new node(4,'b'));
//        
//        table.get(4).add(new node(5,'b'));

        //NFA(int is, int[] fs, int nostate, String VC,ArrayList<ArrayList<node>> ent) 
        n = new NFA(IS, final_st, no_of_state, "ab", table);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value to validate");
       // n.validate(scan.nextLine());
        System.out.println(n.validate(scan.nextLine()));
        n.show();
    }

}

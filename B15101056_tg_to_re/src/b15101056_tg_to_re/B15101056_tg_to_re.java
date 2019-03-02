/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101056_tg_to_re;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abc
 */
public class B15101056_tg_to_re {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of states");
  int states=scan.nextInt();
        
  Conversion f=new Conversion(states);
//  f.outgoing.add("hello");
 // f.outgoingshow();
 // System.out.println(f.outgoingshow());
  
    f.initial(scan);
    f.setfinalstates(scan);
    f.create_table(scan);
    f.elimination();
    
    System.out.println("");  
        
        for (int i = 0; i <f.st_list.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < f.st_list[i].size(); j++) {
                System.out.print(f.st_list[i].get(j).show());
            }System.out.println();
        
        }
   
    
        
    };
    
}

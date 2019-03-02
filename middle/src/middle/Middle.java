/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class Middle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* int NoOfStates=5;
        int [] initialStates={0,3};
        int [] FinalStates={2,4};
        */
        int NoOfStates=2;
        int [] initialStates={0};
        int [] FinalStates={1};
        
        
        int [] Arr=new int[NoOfStates+2];
        ArrayList<ArrayList<Transition>> list=new ArrayList<ArrayList<Transition>>();
        for(int i=0;i<Arr.length;i++)
        {
             list.add(new ArrayList<Transition>());
        }
   /* list.get(0).add(new Transition(1,"a"));
    list.get(1).add(new Transition(1,"b"));
     list.get(1).add(new Transition(2,"bb"));
     
     //list.get(1).add(new Transition(3,"a"));
     //list.get(1).add(new Transition(2,"aa"));
     //list.get(1).add(new Transition(3,"b"));
     
     list.get(2).add(new Transition(2,"a"));
     list.get(2).add(new Transition(6,""));
     list.get(3).add(new Transition(1,"aa"));
     list.get(3).add(new Transition(4,"ba"));
     
     //list.get(3).add(new Transition(1,"bb"));
     
     list.get(4).add(new Transition(2,"b"));
     list.get(4).add(new Transition(6,""));
     list.get(5).add(new Transition(0,""));
     list.get(5).add(new Transition(3,""));
    
    */
    
    list.get(0).add(new Transition(1,"a"));
    list.get(0).add(new Transition(1,"ba"));
    
     //list.get(0).add(new Transition(1,"bb")); 
     //list.get(0).add(new Transition(0,"b"));
     list.get(1).add(new Transition(0,"a"));
     
     list.get(1).add(new Transition(0,"ab"));
     list.get(1).add(new Transition(1,"b"));
     
     list.get(1).add(new Transition(3,""));
     list.get(2).add(new Transition(0,""));
    
     
     TgTORe TG=new TgTORe(list,NoOfStates);
     //String RE=
             TG.TgtoRE();
     
       //System.out.println(RE);
     TG.displayList();
    }
    
}

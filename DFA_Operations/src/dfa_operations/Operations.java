/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class Operations {
    
    FiniteAutomata DFA1;
    FiniteAutomata DFA2;
    ArrayList<States> li = new ArrayList<States>();
    int count = 0;
    int[][] Trantable1;
    ArrayList<Integer> FS = new ArrayList<Integer>();
    int[] FinalStates;
    ArrayList<Integer> TT=new ArrayList<Integer>();
    char[] No_Char={'a','b'};

    public Operations(FiniteAutomata FA1, FiniteAutomata FA2) {
        this.DFA1 = FA1;
        this.DFA2 = FA2;
    }
    
    public FiniteAutomata OR(){
    
    States s= new States();
    s.x=DFA1.InitState;
    s.y=DFA2.InitState;
    li.add(s);
    States s2= new States();
    while(count<li.size()){
        s=li.get(count);
        for (int i = 0; i < 2; i++) {
            s2.x=DFA1.TranTable[s.x][i];
            s2.y=DFA2.TranTable[s.y][i];
            
            boolean check = false;
                for (int j = 0; j < li.size(); j++) {
                    if (li.get(j).equals(s2)) {
                        TT.add(j);
                        check = true;
                    }
                }
                if (check == false) {
                    li.add(s2);
                    TT.add(li.size()-1);
                }
        }
        count++;
    }
    
    Trantable1 = new int[li.size()][No_Char.length];
        int a=0;
        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < No_Char.length; j++) {
                Trantable1[i][j] = TT.get(a);
                //System.out.println("  ,  "+TT.get(i));
                a++;
            }
            //System.out.println("    hhhh");
        }
        
        for (int i = 0; i < li.size(); i++) {
            States split = li.get(i);
            boolean check = false;
            for (int j = 0; j < DFA1.FinalStates.length; j++) {
                if (split.x == DFA1.FinalStates[j]) {
                    check = true;
                }
            }
            for (int j = 0; j < DFA2.FinalStates.length; j++) {
                if (split.y == DFA2.FinalStates[j]) {
                    check = true;
                }
            }
            if (check == true) {
                FS.add(i);
            }
        }
        
    FinalStates = new int[FS.size()];
        for (int i = 0; i < FS.size(); i++) {
            FinalStates[i] = FS.get(i);
        }
        return new FiniteAutomata(li.size(), DFA1.validChars, Trantable1, 0, FinalStates);
    }
    
    
   // public DFA COMPLEMENT(DFA f1){
    
    
    
    
    //return new DFA();
    
    //return null;}
    
}

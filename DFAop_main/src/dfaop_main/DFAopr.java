/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaop_main;

import java.util.ArrayList;

/**
 *
 * @author Ahsan khan
 */
public class DFAopr {
    // public DFA(int numofstate, char[] input, int is, int[] fs) {
    ArrayList<state> statescomb;
    DFA dfa;
    state s;
    DFAopr(){
        this.statescomb=new ArrayList<>();
        this.dfa=new DFA();
        s=new state();
    }
    
    DFA dfaOR(DFA f1,DFA f2){
    DFAopr d=new DFAopr();
    s.x=f1.initialstate;
    s.y=f2.initialstate;
    this.statescomb.add(s);
    return d.dfa; 
    }
    
    
};

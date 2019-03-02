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
public class DFA {

    public int numberofstates;
    public int[] states;
    public char[] inputchar;
    public ArrayList<ArrayList<node>> transitiontable;
    public int initialstate;
    public int[] finalstate;

    public DFA(){
    this.numberofstates=2;
    this.initialstate=0;
    this.inputchar=new char[2];
    this.inputchar[0]='a';
    this.inputchar[1]='b';
    this.finalstate=new int[1];
    this.finalstate[0]=1;
    this.states=new int[2];
    this.transitiontable=new ArrayList<>();
    this.transitiontable.add(new ArrayList<node>());
    //this.transitiontable.get(0).add(new node(0,'a'));
    }
    
    public DFA(int numofstate, char[] input, int is, int[] fs) {
        this.numberofstates = numofstate;
        this.states = new int[numofstate];
        for (int i = 0; i < numofstate; i++) {
            this.states[i] = i;
        }
        this.inputchar = input;
        this.initialstate = is;
        this.finalstate = fs;
        this.transitiontable = new ArrayList<>();
        for (int i = 0; i < this.numberofstates; i++) {
            this.transitiontable.add(new ArrayList<>());
        }
        settransitiontable();
        }
    void settransitiontable(){
    this.transitiontable.get(0).add(new node(0,'a'));
    
    }

    int transition(int state, char inputchar) {
        for (int i = 0; i < transitiontable.get(state).size(); i++) {
            if (this.transitiontable.get(state).get(i).getchar() == inputchar) {
                return this.transitiontable.get(state).get(i).getstate();
            }
        }
        return -1;
    }
};

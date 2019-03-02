/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver_nfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author M.Ahsan
 */
public final class NFA {
    //for input char position
    int in_pos = 0;
    //for transition from next of previous transition
    int next_trans = 0;
    int initialstate;
    int[] finalstates;
   // int[] states;
    String validinputs;
    //array list of arraylist row of type node
    ArrayList<ArrayList<node>> entity;
    //for pushing the every step of transition
    Stack<String> stack = new Stack<>();

    /**
     *
     *
     */
    public NFA(int is, int[] fs, int nostate, String VC, ArrayList<ArrayList<node>> ent) {
        this.validinputs = VC;
        this.entity = ent;

        this.initialstate = is;
        this.finalstates = fs;
//        this.states = new int[nostate];
//        for (int i = 0; i < nostate; i++) {
//            this.states[i] = i;
//        }

    }
                        //ababb    
    boolean validate(String input_str) {
        int current = initialstate;
        for (int i = 0; i < input_str.length(); i++) {
            //transition returns state after all possible transitions of a single char
            current = transition(current, input_str.charAt(i));
            in_pos++;
        }
        if (current == -1) {//current have no nodes and stack is empty
            if (stack.isEmpty()) {
                System.out.println("i am emphty");
                return false;
            }
        } else {//if string passes from all transitions and last state of str is returned
            //check it with final states
            for (int j = 0; j < finalstates.length; j++) {
                if (current == finalstates[j]) {
                    return true;
                }
            }
        }
        //if last state of word is not final then check another path
        return backtracking(input_str, current);
    }
                            //ababb
    boolean backtracking(String inputstr, int current) {
        String str = "";
        //subtract the position of input char due to back tracking
        in_pos--;
        if (stack.isEmpty()) {
            System.out.println("i mam empty");
            return false;
        }//pop the value of stack for last step previous state and (i){i:e,index of array list} 
        str = stack.pop();
        //split is use to sperate the previous state being pushed and index of arraylist
        String[] st_val = str.split(",");
        //st_val[1] contains the last transition index//0
        next_trans = Integer.parseInt(st_val[1]);
        //increment the last transition index to find another path
        next_trans++;
        //st_val[0] would contains previous state
        current = Integer.parseInt(st_val[0]);
        //current input character
        int i = in_pos;
        for (int j = i; j < inputstr.length();) {
            current = backwardtrans(current, inputstr.charAt(in_pos), next_trans);
            if (current == -1) {
                break;
            }
            next_trans = 0;
            j++;
            in_pos++;
        }
        if (current == -1) {
            return backtracking(inputstr, current);
        } else {
            for (int j = 0; j < finalstates.length; j++) {
                if (current == finalstates[j]) {
                    return true;
                }
            }
        }

        return backtracking(inputstr, current);
    }

    int transition(int st, char ch) {
        for (int i = 0; i < entity.get(st).size(); i++) {
            if (entity.get(st).get(i).getchar() == ch) {
                stack.push("" + st + "," + i);
                return entity.get(st).get(i).getstate();
            }
        }
        return -1;
    }
        //state=st/col,in_char=ch,row_no/pos_st=value of stackst_val[1]+1
    int backwardtrans(int st, char ch, int pos_st) {
        for (int i =pos_st; i < entity.get(st).size(); i++) {
            if(entity.get(st).get(i).getchar()==ch){
                stack.push(""+st+","+i);
                return entity.get(st).get(i).getstate();
            }
        }
        //rows gone at end
        return -1;
    }
    public void show(){
        for (int i = 0; i < entity.size(); i++) {
            System.out.print(i+"\t");
            for (int j = 0; j < entity.get(i).size(); j++) {
                System.out.print(this.entity.get(i).get(j).toString()+"");
            }
                System.out.println();
            
        }
    }
};

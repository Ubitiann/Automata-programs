/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdulbasit_b15101003_bscsiii.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ABC
 */
public class DFA {
    int initial_state;
    String[] stringarr;
    int[] final_state;
    int[][] transitionTable;
    int NoOfSt;
    
     DFA(int States, String[] stringarr, int[][] transitionTable,int initial_state, int[] final_state)
    {
        this.initial_state = initial_state;
        this.stringarr = stringarr;
        this.final_state = final_state;
        this.transitionTable = transitionTable; 
        this.NoOfSt=States;
        
    }
            
    public boolean validate(String input)
    {
        int CS= initial_state;
        
        for (int i = 0; i <input.length(); i++) {
            CS = transition(CS,input.charAt(i));
            if (CS == -1)
            {
                return false;
            }
        }
        for (int i = 0; i <final_state.length; i++) {
            if(CS==final_state[i])
                return true;
        }
        return false;
    }
    
    private int transition(int state,char ch)
    {
        for (int i = 0; i <stringarr.length; i++) 
        {
            Pattern p = Pattern.compile(stringarr[i]);
            Matcher m = p.matcher(String.valueOf(ch));
            
            if (m.matches())
                return transitionTable[state][i];
        }
        return -1;
    }
    
   
    }
    
   


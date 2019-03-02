/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Junaid
 */
public class FiniteAutomata {
 
      int States;
    String[] validChars;
    int[][] TranTable;
    int InitState;
    int[] FinalStates;

    public FiniteAutomata(int S, String VC[], int[][] TT, int IS, int[] FS) {
        this.States = S;
        validChars = new String[VC.length];
        this.validChars = VC;
        TranTable = new int[S][VC.length];
        this.TranTable = TT;
        this.InitState = IS;
        this.FinalStates = FS;
    }

   public boolean validate(String word){
        int cs=InitState;
        for (int i = 0; i < word.length(); i++) {
            cs=transition(cs,word.charAt(i));
            if(cs==-1)
                return false;
        }
         
        for (int i = 0; i < FinalStates.length; i++) {
            if(cs==FinalStates[i]){
                return true;
            }
        }
           return false;
    }
     public int transition(int state,char Chr){
        
        String ss=""+Chr;
            for(int i=0;i<validChars.length;i++)
            {   
                Pattern p1=Pattern.compile(validChars[i]);
                Matcher m1=p1.matcher(ss);
                if(m1.matches())
                    return TranTable[state][i];
                
            }
         return -1;
        } 
    }
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101003_abdulbasit_bscsiiia;

/**
 *
 * @author ABC
 */
public class FiniteAutomata {
     private final int NoOfStates;
    private final char [] inputChars;
    private final int [][] transitionOfState;
    private final int init_st;
    private final int [] f_st;

    public FiniteAutomata(int noOfState, char[] inputChars, int[][] transitionOfState, int init_st, int[] f_st) {
        this.NoOfStates = noOfState;
        this.inputChars = inputChars.clone();
        this.transitionOfState = transitionOfState.clone();
        this.init_st = init_st;
        this.f_st = f_st.clone();
    }
    
   
    public boolean validate(String inp){   //testing of input.
        int cs=init_st;
        
        for (int i = 0; i < inp.length(); i++) {
            cs=transition(cs,inp.charAt(i));
             if(cs==-1){
                 return false;
             }
            
        }
        
        
        return checker(cs); 
    }
    
    
   
    private boolean checker(int state)    //checking cs is final or not.
    {
        for (int i = 0; i < f_st.length; i++) {
            if(state==f_st[i])
                return true;
        }
        
        return false;
    }
   
    private int transition(int state,char cur_Char) //transition from current state to next state.
    {
        int index=getIndex(cur_Char);
        if(index ==-1)
            return -1;
        else
        return transitionOfState[state][index];
    }
    
   
    private int getIndex(char givenChar){
        int i;
        for(i=0;i<this.inputChars.length;i++){
            if(givenChar==this.inputChars[i])
               return i;
        }
       
            return -1;
    }
    

}

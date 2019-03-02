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
public class B15101003_AbdulBasit_BSCSIIIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //this is done for Even a and b's
        
        
         char [] alphabet={'a','b'};
        int [][] tt={{1,3},{0,2},{3,1},{2,0}};
       int st=4;
       int[] f_st={0};
       int init_st=0;
       
       FiniteAutomata FA=new FiniteAutomata(st,alphabet, tt, init_st, f_st);
       
        System.out.println(FA.validate("ababababbbaa"));  //test case
       
        
    }
    
}

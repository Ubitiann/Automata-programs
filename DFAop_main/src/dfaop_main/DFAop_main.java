/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaop_main;

/**
 *
 * @author Ahsan khan
 */
public class DFAop_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//            char[] ch={'a','b'};
//            int[] fs={1};
//            
//    DFA d;
//        //public DFA(int numofstate, char[] input, int is, int[] fs)
//        d = new DFA(2,ch,0,fs);
           DFAopr d=new DFAopr();
         DFA  f1=new DFA();
         DFA  f2=new DFA();
           d.dfaOR(f1, f2);
    }
    
}

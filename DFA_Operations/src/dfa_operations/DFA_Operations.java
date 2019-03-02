/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_operations;

/**
 *
 * @author Junaid
 */
public class DFA_Operations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        String[] VC = {"a", "b"};
        int S1 = 2;
        int IS1 = 0;
        int FS1[] = {0};
        int[][] TranTable1 = {{1, 0}, {1, 0}};

//        int S2 = 3;
//        int IS2 = 0;
//        int FS2[] = {2};
//        int[][] TranTable2 = {{1, 0}, {1, 2}, {2, 2}};

        int S2 = 3;
        int IS2 = 0;
        int FS2[] = {0,1};
        int[][] TranTable2 = {{1, 0}, {2,0}, {2, 2}};
        
        FiniteAutomata DFA1 = new FiniteAutomata(S1, VC, TranTable1, IS1, FS1);
        FiniteAutomata DFA2 = new FiniteAutomata(S2, VC, TranTable2, IS2, FS2);
        Operations O1 = new Operations(DFA1, DFA2);
        FiniteAutomata ODFA = O1.OR();

        System.out.println("States\n" + ODFA.States);
        System.out.println("Initial state\n" + ODFA.InitState);
        System.out.println("Final States");
        for (int i = 0; i < ODFA.FinalStates.length; i++) {
            System.out.print(ODFA.FinalStates[i] + ",");
        }
        System.out.println();
        System.out.println("Transition Table");
        for (int i = 0; i < ODFA.TranTable.length; i++) {
            for (int j = 0; j < ODFA.validChars.length; j++) {
                System.out.print(ODFA.TranTable[i][j] + ",");
            }
            System.out.println();
        }
        //*/
    }
    
}

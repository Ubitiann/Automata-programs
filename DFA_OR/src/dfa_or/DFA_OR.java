/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_or;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hp
 */
public class DFA_OR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);

        String[] VC = {"a", "b"};
        int S1 = 2;
        int IS1 = 0;
        int FS1[] = {1};
        int[][] TranTable1 = {{1, 0}, {1, 0}};

//        int S2 = 3;
//        int IS2 = 0;
//        int FS2[] = {2};
//        int[][] TranTable2 = {{1, 0}, {1, 2}, {2, 2}};

        int S2 = 4;
        int IS2 = 0;
        int FS2[] = {3};
        int[][] TranTable2 = {{1, 2}, {3, 2}, {1, 3}, {3, 3}};

        FiniteAutomata DFA1 = new FiniteAutomata(S1, VC, TranTable1, IS1, FS1);
        FiniteAutomata DFA2 = new FiniteAutomata(S2, VC, TranTable2, IS2, FS2);
        OR O1 = new OR(DFA1, DFA2);
        FiniteAutomata ODFA = O1.ORDFA();

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

        String IC;
        boolean VI = false;
        System.out.println("Enter characters");
        IC = reader.next();

        for (int i = 0; i < IC.length(); i++) {
            int check = 0;
            for (int j = 0; j < VC.length; j++) {
                Pattern p = Pattern.compile(VC[j]);
                Matcher m = p.matcher(IC.substring(i, i + 1));
                if (m.matches()) {
                    VI = true;
                    check = 1;
                }
            }
            if (check == 0) {
                VI = false;
                break;
            }
        }
        if (VI == true) {
            FiniteAutomata FA = new FiniteAutomata(ODFA.States, ODFA.validChars, ODFA.TranTable, ODFA.InitState, ODFA.FinalStates);
            boolean valid = FA.validate(IC);
            if (valid == true) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Invalid input characters");
        }
    }
}

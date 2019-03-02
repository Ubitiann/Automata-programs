/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacon_main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ABC
 */
public class DFACON_MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
         String[] ValidCharacter = {"a", "b"};
       
        //DFA 1
        
        int NO_St2 = 3;
        int I_St2 = 0;
        int F_St2[] = {1};
        int[][] T_table2 = {{1, 2}, {1, 1}, {2 ,2}};
        
        //DFA 2
        
         int NO_St1 = 2;
        int I_St1 = 0;
        int F_St1[] = {1};
        int[][] T_table1 = {{0, 1}, {0, 1}};

        DFA DFA1 = new DFA(NO_St1, ValidCharacter, T_table1, I_St1, F_St1);
        DFA DFA2 = new DFA(NO_St2, ValidCharacter, T_table2, I_St2, F_St2);
        DFACon Result = new DFACon(DFA1, DFA2);
        DFA CON_DFA = Result.CON_DFA();

        System.out.println("No Of States\n" + CON_DFA.NoOfSt);
        System.out.println("Initial state\n" + CON_DFA.initial_state);
        System.out.println("Final States");
        for (int i = 0; i < CON_DFA.final_state.length; i++) {
            System.out.print(CON_DFA.final_state[i] + ",");
        }
        System.out.println();
        System.out.println("Transition Table");
        for (int i = 0; i < CON_DFA.transitionTable.length; i++) {
            for (int j = 0; j < CON_DFA.stringarr.length; j++) {
                System.out.print(CON_DFA.transitionTable[i][j] + ",");
            }
            System.out.println();
        }

        String InputCharacter;
        boolean status = false;
        System.out.println("Enter characters for validation");
        InputCharacter =reader.next();

        for (int i = 0; i < InputCharacter.length(); i++) {
            int check = 0;
            for (int j = 0; j < ValidCharacter.length; j++) {
                Pattern p = Pattern.compile(ValidCharacter[j]);
                Matcher m = p.matcher(InputCharacter.substring(i, i + 1));
                if (m.matches()) {
                    status = true;
                    check = 1;
                }
            }
            if (check == 0) {
                status = false;
                break;
            }
        }
        if (status == true) {
            DFA FA = new DFA(CON_DFA.NoOfSt, CON_DFA.stringarr, CON_DFA.transitionTable, CON_DFA.initial_state, CON_DFA.final_state);
            boolean valid = FA.validate(InputCharacter);
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
    


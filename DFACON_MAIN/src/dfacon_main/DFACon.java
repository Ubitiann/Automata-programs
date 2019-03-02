/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacon_main;

import java.util.ArrayList;

/**
 *
 * @author ABC
 */
public class DFACon {
   DFA DFA1;
    DFA DFA2;
    ArrayList<String> list = new ArrayList<String>();
    int count = 0;
    int[][] T_table;
    ArrayList<Integer> FS = new ArrayList<Integer>();
    int[] FinalStates;
    ArrayList<Integer> TT=new ArrayList<Integer>();

    public DFACon(DFA FA1, DFA FA2) {
        this.DFA1 = FA1;
        this.DFA2 = FA2;
    }

    public DFA CON_DFA() {
        list.add(""+DFA1.initial_state+"" );
        while (count < list.size()) {
            String[] split = list.get(count).split(",");
            for (int i = 0; i < DFA1.stringarr.length; i++) {
                String Z = "" + DFA1.transitionTable[Integer.parseInt(split[0])][i] + "," + DFA2.transitionTable[Integer.parseInt(split[1])][i];
                boolean status = false;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(Z)) {
                        TT.add(j);
                        status = true;
                    }
                }
                if (status == false) {
                    list.add(Z);
                    TT.add(list.size()-1);
                }
            }
            count++;
        }
        T_table = new int[list.size()][DFA1.stringarr.length];
        int a=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < DFA1.stringarr.length; j++) {
                T_table[i][j] = TT.get(a);
                a++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            boolean check = false;
            for (int j = 0; j < DFA1.final_state.length; j++) {
                if (Integer.parseInt(split[0]) == DFA1.final_state[j]) {
                    check = true;
                }
            }
            for (int j = 0; j < DFA2.final_state.length; j++) {
                if (Integer.parseInt(split[1]) == DFA2.final_state[j]) {
                    check = true;
                }
            }
            if (check == true) {
                FS.add(i);
            }
        }
        FinalStates = new int[FS.size()];
        for (int i = 0; i < FS.size(); i++) {
            FinalStates[i] = FS.get(i);
        }
        return new DFA(list.size(), DFA1.stringarr,T_table, 0, FinalStates);
    }
}

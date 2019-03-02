/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_or;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class OR {

    FiniteAutomata DFA1;
    FiniteAutomata DFA2;
    ArrayList<String> li = new ArrayList<String>();
    int count = 0;
    int[][] Trantable;
    ArrayList<Integer> FS = new ArrayList<Integer>();
    int[] FinalStates;
    ArrayList<Integer> TT=new ArrayList<Integer>();

    public OR(FiniteAutomata FA1, FiniteAutomata FA2) {
        this.DFA1 = FA1;
        this.DFA2 = FA2;
    }

    public FiniteAutomata ORDFA() {
        li.add("" + DFA1.InitState + "," + DFA2.InitState);
        while (count < li.size()) {
            String[] split = li.get(count).split(",");
            for (int i = 0; i < DFA1.validChars.length; i++) {
                String Z = "" + DFA1.TranTable[Integer.parseInt(split[0])][i] + "," + DFA2.TranTable[Integer.parseInt(split[1])][i];
                boolean check = false;
                for (int j = 0; j < li.size(); j++) {
                    if (li.get(j).equals(Z)) {
                        TT.add(j);
                        check = true;
                    }
                }
                if (check == false) {
                    li.add(Z);
                    TT.add(li.size()-1);
                }
            }
            count++;
        }
        Trantable = new int[li.size()][DFA1.validChars.length];
        int a=0;
        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < DFA1.validChars.length; j++) {
                Trantable[i][j] = TT.get(a);
                a++;
            }
        }
        for (int i = 0; i < li.size(); i++) {
            String[] split = li.get(i).split(",");
            boolean check = false;
            for (int j = 0; j < DFA1.FinalStates.length; j++) {
                if (Integer.parseInt(split[0]) == DFA1.FinalStates[j]) {
                    check = true;
                }
            }
            for (int j = 0; j < DFA2.FinalStates.length; j++) {
                if (Integer.parseInt(split[1]) == DFA2.FinalStates[j]) {
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
        return new FiniteAutomata(li.size(), DFA1.validChars, Trantable, 0, FinalStates);
    }
}


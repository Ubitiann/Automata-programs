/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_closure;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class CLOSURE {

    FiniteAutomata DFA;
    ArrayList<String> li = new ArrayList<String>();
    int count = 0;
    int[][] Trantable;
    ArrayList<Integer> FS = new ArrayList<Integer>();
    int[] FinalStates;
    ArrayList<Integer> TT = new ArrayList<Integer>();
    String Z;

    public CLOSURE(FiniteAutomata FA1) {
        this.DFA = FA1;
    }

    public FiniteAutomata CLODFA() {
        boolean inloop = false;
        for (int i = 0; i < DFA.validChars.length; i++) {
            if (DFA.TranTable[DFA.InitState][i] == DFA.InitState ) {
                inloop = true;
            }
        }
        if (inloop == true) {
            li.add("" + DFA.InitState);
        }

        while (count < li.size()) {
            String[] split = li.get(count).split(",");
            for (int i = 0; i < DFA.validChars.length; i++) {
                Z = "" + DFA.TranTable[Integer.parseInt(split[0])][i];
                fin(Integer.parseInt(split[0]), i);
                if (split.length > 1) {
                    boolean ch;
                    for (int j = 1; j < split.length; j++) {
                        String[] split1 = Z.split(",");
                        ch = false;
                        for (int k = 0; k < split1.length; k++) {
                            if (DFA.TranTable[Integer.parseInt(split[j])][i] == Integer.parseInt(split1[k])) {
                                ch = true;
                            }
                        }
                        if (ch == false) {
                            Z = Z + "," + DFA.TranTable[Integer.parseInt(split[j])][i];
                        }
                        fin(Integer.parseInt(split[j]), i);
                    }
                }
                boolean check = false;
                for (int j = 1; j < li.size(); j++) {
                    if (li.get(j).equals(Z)) {
                        TT.add(j);
                        check = true;
                    }
                }
                if (check == false) {
                    li.add(Z);
                    TT.add(li.size() - 1);
                }
            }
            count++;
        }
        Trantable = new int[li.size()][DFA.validChars.length];
        int a = 0;
        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < DFA.validChars.length; j++) {
                Trantable[i][j] = TT.get(a);
                a++;
            }
        }
        FS.add(0);
        for (int i = 1; i < li.size(); i++) {
            String[] split = li.get(i).split(",");
            boolean check = false;
            for (int j = 0; j < split.length; j++) {
                for (int k = 0; k < DFA.FinalStates.length; k++) {
                    if (Integer.parseInt(split[j]) == DFA.FinalStates[k]) {
                        check = true;
                    }
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
        return new FiniteAutomata(li.size(), DFA.validChars, Trantable, 0, FinalStates);
    }

    public void fin(int a, int b) {
        boolean fin = false;
        for (int j = 0; j < DFA.FinalStates.length; j++) {
            if (DFA.TranTable[a][b] == DFA.FinalStates[j]) {
                if (DFA.TranTable[a][b] != DFA.InitState) {
                    fin = true;
                    break;
                }
            }
        }
        if (fin == true) {
            Z = Z + "," + DFA.InitState;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_and;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class AND {

    FiniteAutomata DFA1;
    FiniteAutomata DFA2;
    ArrayList<String> li = new ArrayList<String>();
    int count = 0;
    int[][] Trantable;
    ArrayList<Integer> FS = new ArrayList<Integer>();
    int[] FinalStates;
    ArrayList<Integer> TT = new ArrayList<Integer>();

    public AND(FiniteAutomata FA1, FiniteAutomata FA2) {
        this.DFA1 = FA1;
        this.DFA2 = FA2;
    }

    public FiniteAutomata ANDDFA() {
        boolean in=false;
        for (int i = 0; i < DFA1.FinalStates.length; i++) {
            if(DFA1.InitState==DFA1.FinalStates[i]){
                in=true;
            }
        }
        if(in==true){
            li.add("" + DFA1.InitState + "," + DFA2.InitState);
        }
        else{
            li.add("" + DFA1.InitState);
        }
        while (count < li.size()) {
            String[] split = li.get(count).split(",");
            for (int i = 0; i < DFA1.validChars.length; i++) {
                String Z = "" + DFA1.TranTable[Integer.parseInt(split[0])][i];
                boolean fin=false;
                for (int j = 0; j < DFA1.FinalStates.length; j++) {
                    if(DFA1.TranTable[Integer.parseInt(split[0])][i]==DFA1.FinalStates[j]){
                        fin=true;
                        break;
                    }
                }
                if(fin==true){
                    Z=Z+","+DFA2.InitState;
                }
                if(split.length>1){
                    boolean ch=false;
                    for (int j = 1; j < split.length; j++) {
                        String[] split1=Z.split(",");
                        ch=false;
                        for (int k = 1; k < split1.length; k++) {
                            if(DFA2.TranTable[Integer.parseInt(split[j])][i]==Integer.parseInt(split1[k])){
                                ch=true;
                            }
                        }
                        if(ch==false){
                            Z=Z+","+DFA2.TranTable[Integer.parseInt(split[j])][i];
                        }
                    }
                }
                boolean check = false;
                for (int j = 0; j < li.size(); j++) {
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
        Trantable = new int[li.size()][DFA1.validChars.length];
        int a = 0;
        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < DFA1.validChars.length; j++) {
                Trantable[i][j] = TT.get(a);
                a++;
            }
        }
        for (int i = 0; i < li.size(); i++) {
            String[] split = li.get(i).split(",");
            boolean check = false;
            if(split.length>1){
                for (int j = 1; j < split.length; j++) {
                    for (int k = 0; k < DFA2.FinalStates.length; k++) {
                        if(Integer.parseInt(split[j])==DFA2.FinalStates[k]){
                            check=true;
                        }
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
        return new FiniteAutomata(li.size(), DFA1.validChars, Trantable, 0, FinalStates);
    }
}

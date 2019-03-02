/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class conversion {

    int States;
    String[] validChars;
    ArrayList<struct>[] columns;
    int[] InitStates;
    int[] FinalStates;

    public conversion(int S, String[] VC, ArrayList<struct>[] col, int[] IS, int[] FS) {
        this.States = S;
        this.validChars = new String[VC.length];
        this.validChars = VC;
        this.columns = new ArrayList[States];
        for (int i = 0; i < States; i++) {
            columns[i] = new ArrayList<struct>();
        }
        this.columns = col;
        this.InitStates = new int[IS.length];
        this.InitStates = IS;
        this.FinalStates = new int[FS.length];
        this.FinalStates = FS;
    }

    public void convert() {
        reduce();

        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<String> inchar = new ArrayList<String>();
        boolean loop = false;
        String loopchar = "";
        ArrayList<Integer> out = new ArrayList<Integer>();
        ArrayList<String> outchar = new ArrayList<String>();

        for (int i = 0; i < States - 2; i++) {
            for (int j = 0; j < States; j++) {                          //Incoming
                if (j != i) {
                    for (int k = 0; k < columns[j].size(); k++) {
                        if ((columns[j].get(k).st) == i) {
                            in.add(j);
                            inchar.add(columns[j].get(k).ch);
                        }
                    }
                }
            }

            for (int j = 0; j < columns[i].size(); j++) {               //loop
                if ((columns[i].get(j).st) == i) {
                    loop = true;
                    loopchar = columns[i].get(j).ch;
                }
            }

            for (int j = 0; j < columns[i].size(); j++) {               //outgoing
                if ((columns[i].get(j).st) != i) {
                    out.add(columns[i].get(j).st);
                    outchar.add(columns[i].get(j).ch);
                }
            }

            for (int j = 0; j < in.size(); j++) {
                for (int k = 0; k < out.size(); k++) {
                    String test="";
                    if (inchar.get(j).equals("") && loop == false && outchar.get(k).equals("")) {
                        test = "";
                    } else if (inchar.get(j).equals("") && loop == false) {
                        test = outchar.get(k);
                    } else if (inchar.get(j).equals("") && loop == true && outchar.get(k).equals("")) {
                        test = "(" + loopchar + ")" + "*";
                    } else if (inchar.get(j).equals("") && loop == true) {
                        test = "(" + loopchar + ")" + "*" + outchar.get(k);
                    } else if (loop == false && outchar.get(k).equals("")) {
                        test = "(" + inchar.get(j) + ")";
                    } else if (loop == false) {
                        test = "(" + inchar.get(j) + ")" + "(" + outchar.get(k) + ")";
                    } else if (loop == true && outchar.get(k).equals("")) {
                        test = "(" + inchar.get(j) + ")" + "(" + loopchar + ")" + "*";
                    } else if (loop == true) {
                        test="(" + inchar.get(j) + ")" + "(" + loopchar + ")" + "*" + "(" + outchar.get(k) + ")";
                    }
                    for (int l = 0; l < in.size(); l++) {
                        for (int m = 0; m < columns[in.get(j)].size(); m++) {
                            if((columns[in.get(j)].get(m).st)==i){
                                columns[in.get(j)].remove(m);
                            }
                        }
                    }
                    struct c = new struct(test, out.get(k));
                    columns[in.get(j)].add(c);
                }
            }
            columns[i].clear();
            reduce();
            in.clear();
            inchar.clear();
            out.clear();
            outchar.clear();
            loop = false;
            loopchar = "";
        }
    }

    public void reduce() {
        String temp = "";                     //Reduce edges
        int temp1;
        for (int i = 0; i < columns.length; i++) {
            for (int j = 0; j < columns[i].size(); j++) {
                temp = columns[i].get(j).ch;
                temp1 = columns[i].get(j).st;
                for (int k = j + 1; k < columns[i].size();) {
                    if (columns[i].get(k).st == temp1) {
                        temp = temp + "+" + columns[i].get(k).ch;
                        columns[i].remove(k);
                    } else {
                        k++;
                    }
                }
                struct s = new struct(temp, temp1);
                columns[i].set(j, s);
                temp = "";
                temp1 = 0;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Hp
 */
public class FiniteAutomata {

    int pos = 0;
    int pos1 = 0;
//    ArrayList<Integer> position=new ArrayList<Integer>();
    int States;
    String validChars;
    ArrayList<struct>[] columns;
    int InitState;
    int[] FinalStates;
    Stack<String> stack = new Stack<String>();

    public FiniteAutomata(int S, String VC, ArrayList<struct>[] col, int IS, int[] FS) {
        this.States = S;
        this.validChars = VC;
        this.columns = new ArrayList[States];
        for (int i = 0; i < States; i++) {
            columns[i] = new ArrayList<struct>();
        }
        this.columns = col;
        this.InitState = IS;
        this.FinalStates = new int[FS.length];
        this.FinalStates = FS;
    }

    boolean validate(String inputChars) {
        int CS = InitState;
        for (int j = 0; j < inputChars.length(); j++) {
            CS = transition(CS, inputChars.charAt(j));
            pos++;
        }
        if (CS == -1) {
            if (stack.empty()) {
                return false;
            }
        } else {
            for (int j = 0; j < FinalStates.length; j++) {
                if (CS == FinalStates[j]) {
                    return true;
                }
            }
        }
        return backtracking(inputChars, CS);
    }

    public boolean backtracking(String inputChars, int CS) {
        String p = "";
        pos--;
        if (stack.empty()) {
            return false;
        }
        p = stack.pop();
        String[] pts = p.split(",");
        pos1 = Integer.parseInt(pts[1]);
        pos1++;
        CS = Integer.parseInt(pts[0]);

        int k = pos;
        for (int j = k; j < inputChars.length();) {
            CS = tranback(CS, inputChars.charAt(pos), pos1);
            if (CS == -1) {
                break;
            }
            pos1 = 0;
            j++;
            pos++;
        }
        if (CS == -1) {
            return backtracking(inputChars, CS);
        } else {
            for (int j = 0; j < FinalStates.length; j++) {
                if (CS == FinalStates[j]) {
                    return true;
                }
            }
            return backtracking(inputChars, CS);
        }
    }

    int transition(int st, char ch) {
        for (int i = 0; i < columns[st].size(); i++) {
            if ((columns[st].get(i).ch) == ch) {
                stack.push("" + st + "," + i);
                return columns[st].get(i).st;
            }
        }
        return -1;
    }

    int tranback(int st, char ch, int pts) {
        for (int i = pts; i < columns[st].size(); i++) {
            if ((columns[st].get(i).ch) == ch) {
                stack.push("" + st + "," + i);
                return columns[st].get(i).st;
            }
        }
        return -1;
    }

    public void display() {
        System.out.println(columns[2].get(1).display());
    }
}

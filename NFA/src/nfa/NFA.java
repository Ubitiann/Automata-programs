/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfa;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Hp
 */
public class NFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here   
        Scanner reader = new Scanner(System.in);

        int S;
        String VC;
        int IS;
        String FinalStates;
        ArrayList<struct>[] columns;
        String IC;

//        S = 3;
//        columns = new ArrayList[S];
//        for (int i = 0; i < S; i++) {
//            columns[i] = new ArrayList<struct>();
//        }
//        VC = "ab";
//        IS = 0;
//        FinalStates = "2";

        S = 4;
        columns = new ArrayList[S];
        for (int i = 0; i < S; i++) {
            columns[i] = new ArrayList<struct>();
        }
        VC = "ab";
        IS = 0;
        FinalStates = "3";

//        System.out.println("Enter no. of States");
//        S = reader.nextInt();
//        System.out.println("Enter Valid Characters");
//        VC = reader.next();
//        System.out.println("Enter Initial State");
//        IS = reader.nextInt();
//        System.out.println("Enter Final States(e.g: 2,4)");
//        FinalStates = reader.next();
        String[] parts = FinalStates.split(",");
        int[] FS = new int[((FinalStates.length()) / 2) + 1];
        for (int i = 0; i < FS.length; i++) {
            FS[i] = Integer.parseInt(parts[i]);
        }
//        System.out.println("Enter Transition Table");
//        for (int i = 0; i < S; i++) {
//            System.out.println("Number of Columns in State " + i);
//            int col = reader.nextInt();
//            for (int j = 0; j < col; j++) {
//                System.out.println("Enter char at column " + (j + 1) + " of state " + i);
//                char a = reader.next(".").charAt(0);
//                System.out.println("Enter state at column " + (j + 1) + " of state " + i);
//                int b = reader.nextInt();
//                struct c = new struct(a, b);
//                columns[i].add(c);
//            }
//        }
        columns[0].add(new struct('a',0));
        columns[0].add(new struct('a',1));
        columns[0].add(new struct('b',0));
        columns[0].add(new struct('b',2));
        columns[1].add(new struct('a',3));
        columns[2].add(new struct('b',3));
        
        boolean VI = false;
        int a;
        System.out.println("Enter characters");
        IC = reader.next();

        for (int i = 0; i < IC.length(); i++) {
            a = 0;
            for (int j = 0; j < VC.length(); j++) {
                if (IC.charAt(i) == VC.charAt(j)) {
                    VI = true;
                    a = 1;
                }
            }
            if (a == 0) {
                VI = false;
                break;
            }
        }
        if (VI == true) {
            FiniteAutomata FA = new FiniteAutomata(S, VC, columns, IS, FS);
            boolean valid = FA.validate(IC);
            if (valid == true) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
//            FA.display();
        } else {
            System.out.println("Invalid input characters");
        }
    }
}

class struct {

    public char ch;
    public int st;

    public struct(char cha, int sta) {
        this.ch = cha;
        this.st = sta;
    }

    public String display() {
        return (ch + Integer.toString(st));
    }
}

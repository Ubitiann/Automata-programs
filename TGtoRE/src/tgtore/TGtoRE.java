/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class TGtoRE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);

//        int S=5;
//        String[] VC={"a","b","aa","bb","ba"};
//        String InitialStates="0,3";
//        String FinalStates="2,4";
        int S = 2;
        String Validchars = "a,b,aa";
        String InitialStates = "0";
        String FinalStates = "1";
        ArrayList<struct>[] columns;

        columns = new ArrayList[S + 2];
        for (int i = 0; i < S + 2; i++) {
            columns[i] = new ArrayList<struct>();
        }

//        System.out.println("Enter no. of States");
//        S = reader.nextInt();
//        System.out.println("Enter Valid Characters");
//        VC = reader.next();
//        System.out.println("Enter Initial State");
//        IS = reader.nextInt();
//        System.out.println("Enter Final States(e.g: 2,4)");
//        FinalStates = reader.next();
        String[] VC=Validchars.split(",");
        String[] parts = FinalStates.split(",");
        int[] FS = new int[((FinalStates.length()) / 2) + 1];
        for (int i = 0; i < FS.length; i++) {
            FS[i] = Integer.parseInt(parts[i]);
        }
        String[] parts1 = InitialStates.split(",");
        int[] IS = new int[((InitialStates.length()) / 2) + 1];
        for (int i = 0; i < IS.length; i++) {
            IS[i] = Integer.parseInt(parts1[i]);
        }
        System.out.println("Enter Transition Table");
        for (int i = 0; i < S; i++) {
            System.out.println("Number of Columns in State " + i);
            int col = reader.nextInt();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter string at column " + (j + 1) + " of state " + i);
                String a = reader.next();
                System.out.println("Enter state at column " + (j + 1) + " of state " + i);
                int b = reader.nextInt();
                struct c = new struct(a, b);
                columns[i].add(c);
            }
        }
        for (int i = 0; i < IS.length; i++) {
            struct c = new struct("", IS[i]);
            columns[S].add(c);
        }
        for (int i = 0; i < FS.length; i++) {
            struct c = new struct("", S + 1);
            columns[FS[i]].add(c);
        }
        conversion c1 = new conversion(S + 2, VC, columns, IS, FS);
        c1.convert();
        System.out.println(columns[S].get(0).display());
    }
}

class struct {

    public String ch;
    public int st;

    public struct(String cha, int sta) {
        this.ch = cha;
        this.st = sta;
    }

    public String display() {
        return (ch);
    }
}

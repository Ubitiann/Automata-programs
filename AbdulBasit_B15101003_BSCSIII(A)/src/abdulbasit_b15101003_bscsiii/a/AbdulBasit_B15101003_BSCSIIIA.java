/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdulbasit_b15101003_bscsiii.a;

import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class AbdulBasit_B15101003_BSCSIIIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Enter input String");
        Scanner input = new Scanner(System.in);
        String check;
        check = input.nextLine();

        //For identifier
        int[][] tt_I = {{2, 3, 1},
        {2, 2, 1},
        {2, 2, 2},
        {3, 3, 3}};
        int noOfStates_I = 4;
        int i_st_I = 0;
        int[] f_st_I = {2};
        String[] inputStr_I = new String[3];
        inputStr_I[0] = "[A-Za-z]";
        inputStr_I[1] = "[0-9]";
        inputStr_I[2] = "[_]";

        DFA iden = new DFA(noOfStates_I, inputStr_I, tt_I, i_st_I, f_st_I);

        //For Integer
        int[][] tt_Int = {{1, 2},
        {3, 2},
        {3, 2},
        {3, 3}};

        int noOfStates_Int = 4;
        int i_st_Int = 0;
        int[] f_st_Int = {2};
        String[] inputStr_Int = new String[2];
        inputStr_Int[0] = "[-+]";
        inputStr_Int[1] = "[0-9]";

        DFA Int = new DFA(noOfStates_Int, inputStr_Int, tt_Int, i_st_Int, f_st_Int);

        //For Float
        int[][] tt_fl = {{2, 1, 3, 2},
        {1, 1, 1, 1},
        {2, 1, 3, 1},
        {4, 1, 1, 1},
        {4, 5, 1, 1},
        {7, 1, 1, 6},
        {7, 1, 1, 1},
        {7, 1, 1, 1}};
        int noOfStates_fl = 8;
        int i_st_fl = 0;
        int[] f_st_fl = {4, 7};
        String[] inputStr_fl = new String[4];
        inputStr_fl[0] = "[0-9]";
        inputStr_fl[1] = "e";
        inputStr_fl[2] = "[.]";
        inputStr_fl[3] = "[-+]";

        DFA Float = new DFA(noOfStates_fl, inputStr_fl, tt_fl, i_st_fl, f_st_fl);

        //For Char   
        int[][] tt_chr = {{5, 5, 5, 1},
        {4, 2, 2, 5},
        {5, 5, 5, 3},
        {5, 5, 5, 5},
        {5, 2, 5, 5},
        {5, 5, 5, 5}};

        int noOfStates_chr = 7;
        int i_st_chr = 0;
        int[] f_st_chr = {3};
        String[] inputStr_chr = new String[4];
        inputStr_chr[0] = "[\\\\]";
        inputStr_chr[1] = "[nbtr0]";
        inputStr_chr[2] = "[^']";
        inputStr_chr[3] = "[']";

        DFA Chr = new DFA(noOfStates_chr, inputStr_chr, tt_chr, i_st_chr, f_st_chr);

        //For String
        int[][] tt_Str = {{1, 4},
        {3, 2},
        {3, 2},
        {3, 2},
        {4, 4},
        {4, 4}};
        int noOfStates_Str = 5;
        int i_st_Str = 0;
        int[] f_st_Str = {3};
        String[] inputStr_Str = new String[2];
        inputStr_Str[0] = "\"";
        inputStr_Str[1] = "[^\"]";

        DFA Str = new DFA(noOfStates_Str, inputStr_Str, tt_Str, i_st_Str, f_st_Str);

        if (iden.validate(check)) {
            System.out.println("Given Input is identifier");
        } else {
            if (Int.validate(check)) {
                System.out.println("Given Input Is An integer");
            } else {
                if (Float.validate(check)) {
                    System.out.println("Given Input Is A float");
                } else {
                    if (Chr.validate(check)) {
                        System.out.println("Given Input Is A character");
                    } else {
                        if (Str.validate(check)) {
                            System.out.println("Given Input Is A String");
                        } else {
                            System.out.println("Invalid");
                        }
                    }
                }
            }
        }
    }
}

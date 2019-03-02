/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver_finite_automata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author M.Ahsan
 */
public class Driver_finite_automata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //manual Solving
//        char[] char_array = {'a', 'b'};
//        int[] finalstate = {2, 3};
//        FA f = new FA(5, char_array, 0, finalstate);
//        f.validate("baaba!a");

        //auto solving
        String in, states, initial_state, finalstates, num_of_finalstates, valid_languages;
        while (true) {
            System.out.println("*********Dynamic Finite Automata*****************************");
            System.out.println("Enter valid languages");
            valid_languages = getString();
            System.out.println("Enter Number Of States");
            states = getString();
            System.out.println("Enter Initial State");
            initial_state = getString();
            System.out.println("Enter Number Of final States");
            num_of_finalstates = getString();
            System.out.println("Enter Final States");
//            String st=num_of_finalstates;

//            finalstates=getString();
            int[] array = new int[Integer.parseInt(num_of_finalstates)];
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < Integer.parseInt(num_of_finalstates); i++) {

                array[i] = input.nextInt();
            }
            int r, c;
            r = Integer.parseInt(states);
            c = Integer.parseInt(valid_languages);

            int[][] transition = new int[r][c];
            System.out.println("transition values");
            for (int row2 = 0; row2 < Integer.parseInt(states); row2++) {
                for (int col = 0; col < Integer.parseInt(valid_languages); col++) {

                    transition[row2][col] = input.nextInt();

                }
                System.out.println();

            }

            regex_FA rf;
            rf = new regex_FA(Integer.parseInt(states), Integer.parseInt(initial_state), array, transition, Integer.parseInt(valid_languages));
            System.out.println("*******************************************************************");
            System.out.println("\t\t\t TRANSITION TABLE");
            for (int i = 0; i < rf.states.length; i++) {
                if (rf.initialstate == i) {
                    System.out.print("-" + i + "\t");
                } else if (rf.compare_with_finalstates(i)) {
                    System.out.print("+" + i + "\t");
                } else {
                    System.out.print(" " + i + "\t");
                }

                for (int j = 0; j < rf.transitiontable[i].length; j++) {
                    System.out.print(" " + rf.transitiontable[i][j] + " ");
                }
                System.out.println();
            }

            System.out.print("Enter The Identifier You Want to validate:");
            String str = getString();
            if (str.equals("")) {
                break;
            }
            System.out.println("Enter type of validation");
            System.out.println("1.Integer");
            System.out.println("2.Identifier");
            System.out.println("3.float");
            System.out.println("4.character");
            String val = getString();
            if (val.equals("")) {
                break;
            }
            switch (val) {
                case "1":
                    System.out.print("Validating integer" + "\t");
                    rf.valid_integer(str);
                    break;
                case "2":
                    System.out.print("identifier" + "\t");
                    rf.valid_identifier(str);

                    break;
                case "3":
                    System.out.print("float" + "\t");
                    rf.validate_float(str);

                    break;
                case "4":
                    System.out.print("character" + "\t");
                    rf.char_validate(str);

                    break;
                default:
                    System.out.println("enter numbers between 1-5");
                    throw new AssertionError();
            }

            System.out.println("Do you Want To Contine (Y/N)");
            in = getString();
            switch (in) {
                case "no":

                    break;
                case "NO":
                    break;
                case "N":
                    break;
                case "n":
                    break;
                default:
                    System.out.println("Wrong input");
                    throw new AssertionError();
            }
            break;
        }

    }

    ;
    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}

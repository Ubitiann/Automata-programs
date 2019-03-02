/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdulbasit_b15101003_bscsiiia;

import java.util.Scanner;
import java.util.regex.*;
/**
 *
 * @author ABC
 */
public class AbdulBasit_B15101003_BSCSIIIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          Scanner reader = new Scanner(System.in);
        String input = reader.next();
        Pattern pn1 = Pattern.compile("\"(\\w+)\"");  //RE For String 
        // this RE for String is failed to satisfy all test cases
        //    \"(\\\\(\\\\|\"|\'|r|b|t|n|o))*\")|(\".*\"
        Pattern pn2 = Pattern.compile("[+-]?[0-9]+");  //RE For Int
        Pattern pn3 = Pattern.compile("[+-]?[0-9]*[.][0-9]+([Ee]([+-]?[0-9]+))?");  // RE For Float
        Pattern pn4 = Pattern.compile("\'(([.]*{1}?[^\\\\\"]?)?(\\\\[n|t|r|o|b|\"])?)\'"); //RE For Char
        Pattern pn5 = Pattern.compile("[A-Za-z][A-Za-z0-9]*|[_$][A-Za-z0-9]+");  // RE For Identifier
        
        
        Matcher mtch1 = pn1.matcher(input);
        Matcher mtch2 = pn2.matcher(input);
        Matcher mtch3 = pn3.matcher(input);
        Matcher mtch4 = pn4.matcher(input);
        Matcher mtch5 = pn5.matcher(input);

        if (mtch1.matches()) {
            System.out.println("Given Input Is String");
        } else if (mtch2.matches()) {
            System.out.println("Given Input Is Int");
        } else if (mtch3.matches()) {
            System.out.println("Given Input Is Float");
        } else if (mtch4.matches()) {
            System.out.println("Given Input Is Char");
        } else if (mtch5.matches()) {
            System.out.println("Given Input Is Identifier");
        } else {
            System.out.println("You Entered Invalid Input");
        }
    }
        
        
    }
    


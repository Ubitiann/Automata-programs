/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfgmain;

/**
 *
 * @author ABC
 */
public class CFG {

    static int index = 0;
    String input = "";

    boolean validate() {
        if (S() && input.charAt(index) == '$') {
            return true;

        }

        return false;
    }

    public CFG(String input) {
        this.input = input+"$";

    }

    boolean S() {
        if (input.charAt(index) == 'a') {
            index++;
            if (S()) {
                if (input.charAt(index) == 'b') {
                    index++;
                    return true;
                }
            }

        } else {
            return true;
        }
        return false;
    }

}

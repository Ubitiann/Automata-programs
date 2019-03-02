/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver_nfa;
import java.util.ArrayList;
/**
 *
 * @author M.Ahsan
 */
public class node {

    private char validchar;
    private int state;



    public node(int transition, char value) {
     
        this.validchar= value;
        this.state = transition;
    }

    public void setstate(int state) {
        this.state = state;
    }

    public int getstate() {
        return this.state;
    }

    public void setString(char str) {
        this.validchar = str;
    }

    public char getchar() {
        return this.validchar;
    }
    public String toString(){
        String result = "";
        result+="("+this.getstate()+","+this.getchar()+")";
    return result;
    }
};

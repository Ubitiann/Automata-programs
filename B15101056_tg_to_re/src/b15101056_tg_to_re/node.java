/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101056_tg_to_re;

/**
 *
 * @author abc
 */
public class node {

    String language = " ";
    int state = 0;

    public node(int st, String str) {
        this.state = st;
        this.language = str;
    }

    public String show() {
        return "{" + this.state + "," + this.language + "}";
    }
};

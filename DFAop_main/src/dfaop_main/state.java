/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaop_main;

/**
 *
 * @author Ahsan khan
 */
public class state {
    public int x;
    public int y;
   

    public state() {
        this.x=0;
        this.y=0;
    }
public String ToString(){
String result="";
result+="("+this.x+","+this.y+")";
return result;
}
}

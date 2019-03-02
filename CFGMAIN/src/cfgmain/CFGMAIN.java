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
public class CFGMAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CFG OP=new CFG("aabbb");
        if(OP.validate())
        {
            System.out.println("validate"); 
        }
        else
        {
            System.out.println("invalid");
        }
        
    }
    
}

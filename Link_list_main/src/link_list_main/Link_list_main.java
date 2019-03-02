/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package link_list_main;

/**
 *
 * @author prompt
 */
public class Link_list_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkList ll=new LinkList();
        ll.insertAtFirst(10);
        ll.insertAtFirst(20);
        ll.insertAtFirst(30);
        ll.append(5);
        ll.find(15);
        ll.insertAt(10, 8);
        ll.delete(50);
        ll.displayList();
        // TODO code application logic here
    }
    
}

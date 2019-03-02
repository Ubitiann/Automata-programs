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
public class Node {
    private int data;
    private Node next;
    
    public Node(int inp){
    this.data=inp;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNode() {
        return next;
    }

    public void setNode(Node node) {
        this.next = node;
    }
    
    public void display(){
    
        System.out.println("    "+this.data);
    }
    
    
}

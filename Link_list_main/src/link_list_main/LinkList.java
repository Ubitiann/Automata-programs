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
public class LinkList {
    
    public Node first;
    
    
    
    public LinkList(){
    this.first=null;
    }
    
   public boolean isempty(){
   
   return (first==null);
   
   }
   
   
   public void insertAtFirst(int val){
   Node node=new Node(val);
   node.setNode(first);
   first=node;
  
   }                                        //insert at first ends
   
  
   public void append(int val){
    Node current=first;
   Node newNode=new Node(val);
   if(!isempty()){
       while(current.getNode()!=null){
   current=current.getNode();
   }
   current.setNode(newNode);
   }
   else
       first=newNode;
  
   }                                        //append function ends
   
   public void deleteFirst(){
       
   if(!isempty())
       first=first.getNode();
   else
       System.out.println("Impossible ");
   }                                           //deletefirst function ends
   
   public Node find(int data){
   Node current=first;
   while(current!=null && current.getData()!=data){
   current=current.getNode();
   }
      // System.out.println(" "+current.getData());
   if (isempty())
       return null;
   else
       return current;
               
   }                                               //find function ends
   
   public void insertAt(int pos,int placed){
   
   Node current=first;
   Node newnode=new Node(placed);
     while(current!=null &&current.getData()!=pos){
   current=current.getNode();
   }
   if (current==null)
           System.out.println("Imposiible to insert ");
   else{
   newnode.setNode(current.getNode());
   current.setNode(newnode);
   }
   }
   
   public Node delete(int key){
       Node current = first;
       Node previous = first;
       if(!isempty())
           while(current.getData() != key)
{
if(current.getNode() == null)
    return null;
else
{
previous = current;

current = current.getNode();
}
}
if(current == first)
    first = first.getNode();
else{
previous.setNode(current.getNode());
return current;
}
return null;
} 
   
   public void displayList(){
   Node current=first;
   
   while(current!=null){
   current.display();
   current=current.getNode();
   }
   
   }                                           //displaylist ends
   
}

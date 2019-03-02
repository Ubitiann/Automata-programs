/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtoremain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABC
 */
public class TEtoRE {
     ArrayList<ArrayList<Transition>> list;
     int states;
     
     
     
    public  TEtoRE( ArrayList<ArrayList<Transition>> list,int states)
    { this.list=list;
    this.states=states;
    }
    
    public String ConvertToRE()
    {
        String p="";
        for(int i=0;i<states;i++)
        {
            p+=this.reduceedge(i);
           
        }
        return p;
    }
    
    public String reduceedge(int i)
    {
         List<String> St=new ArrayList<String>();
            for(int y=0;y<states;y++)
            { String incomingEdge="",result="";
           
                if(y!=i)
                {
              for(int r=0;r<list.get(y).size();r++)
            {int s;
               if(list.get(y).get(r).state==i)
               { 
                  incomingEdge=list.get(y).get(r).str;  
                 
                
                  
                result+=incomingEdge;
                
                
                
                 for(s=r+1;s<list.get(y).size();s++)
                 {
                       if(list.get(y).get(s).state==i)
                       {
                           result+=" + ";
                       }
                     
                 }      
            } 
            }
            
         
          
     
          
     
     
            } 
            
          String pr=(loop_out(result,i,y)) ;
          if(pr!="")
          {
              St.add(pr);
          }
         
   //his.list.get(i).remove();
    }
         String qr="";
         int t;
      for(int u=0;u<St.size();u++)
         { if(St.get(u)!="")
         {
          qr+=St.get(u);
         // t=u+1;
          //if(St.get(t)!=null)
          //{
             qr+=" + "; 
          //}
         }     
         }
          
       
        return qr;
 }
     public String loop_out(String inc,int i,int y)  
       {
         
          if(inc=="")
          {
            return inc;  
          }
          else
          {
          
                String loop="";
          for(int k=0;k<list.get(i).size();k++)
            { int t;
               if(list.get(i).get(k).state==i)
               {  
                   loop=list.get(i).get(k).str;
                   
               }
              
    }
              
          if(loop!="")
          {
     inc+="("+loop+")* ";
          }
          
          boolean status=false;
          for(int n=0;n<list.get(i).size();n++)
          {
             if(list.get(i).get(n).state!=i)
             {
                 status=true;
             }
          }
          
          String re="";
          re+=inc; 
          if(status==true)
          {
           for(int  f=0;f<list.get(i).size();f++)
              { if(list.get(i).get(f).state!=i)
              { 
                  re+="("+list.get(i).get(f).str+")";
              //list.get(i).get(f).str=re;
                if(list.get(i).get(f).state==3|| list.get(i).get(f).state==3) 
                {
                    for(int x=0;x<list.get(i).size();x++)
                    { if(list.get(list.get(i).get(f).state).get(x).state==list.get(i).get(f).state)
                    {    
                        re+="("+list.get(list.get(i).get(f).state).get(x).str+")*";
                    }      
                                
                            
                       
                    }
                  
                }
              }
              }
          }
          else
              if(status==false)
              {
                  
               for(int  v=0;v<list.get(i).size();v++)
              {
               re+="("+list.get(i).get(v).str+")";
              list.get(i).get(v).str=re;
                  
              
              
              }
                  
              }
           return re;
       }
       }
}
    
     

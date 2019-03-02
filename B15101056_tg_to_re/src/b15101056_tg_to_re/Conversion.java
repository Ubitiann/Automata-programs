/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b15101056_tg_to_re;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author abc
 */
public class Conversion {

    ArrayList<node> list;
    List<node> st_list[];
    int initial[];
    int finalst[];
    int states;
    ArrayList<String> incoming;
    ArrayList<String> outgoing;
    ArrayList<String> loop;
    String regex;

    Conversion(int no_of_states) {
        this.states = no_of_states;
        this.st_list = new ArrayList[no_of_states + 1];
        this.incoming = new ArrayList<>();
        this.loop = new ArrayList<>();
        this.outgoing = new ArrayList<>();
        regex = "";
        this.initial = new int[no_of_states - 1];
        this.finalst = new int[no_of_states];
    }

    public void initial(Scanner scan) {
        System.out.println("enter number of intial states");
        int input = scan.nextInt();
        list = new ArrayList<>();
        System.out.println("Enter initial states");
        for (int i = 0; i < input; i++) {
            initial[i] = scan.nextInt();

            list.add(new node(initial[i], "null"));
        }

        st_list[states] = list;

    }

    void setfinalstates(Scanner scan) {
        System.out.println("enter number of final states");
        int input = scan.nextInt();
        this.finalst = new int[input];
        System.out.println("Enter final states");
        for (int i = 0; i < input; i++) {
            finalst[i] = scan.nextInt();
            // list.add(new node(finalst[i],"null"));
        }
        // st_list[states]=list;
    }

    void create_table(Scanner scan) {
        String n = "";
        //scan=new Scanner(System.in);

        for (int i = 0; i < states; i++) {
            list = new ArrayList<>();
            int k = i + 1;
            System.out.println(k + "state:");
            while (!"no".equals(n)) {

                System.out.println("Enter state");
                int state = scan.nextInt();
                System.out.println("Enter langauge");
                String input = scan.next();
                list.add(new node(state, input));

                System.out.println("Do you want to enter another node(no/Y)");

                n = scan.next();

            }
            for (int j = 0; j < finalst.length; j++) {
                if (i == finalst[j]) {
                    list.add(new node(states + 1, "null"));
                }
            }
            st_list[i] = list;
            n = "yes";

        }
    }

    void elimination() {
        for (int i = 0; i < states; i++) {
            for (int j = 0; j < finalst.length; j++) {
                // while((!this.st_list[i].get(i).equals(this.initial[j]))&&(!this.st_list[i].get(i).equals(this.finalst[j]))){}    
                if (i != this.finalst[j] && i != this.initial[j]) {//having other state than(initial and final)
                    for (int k = 0; k < this.st_list[i].size(); k++) {
                        if ((this.st_list[i].get(k).state) == i) {//with loop
                            //until reached at last index of
                            loop.add(this.st_list[i].get(k).language);
                            if (this.incoming.isEmpty()) {
                                regex += "(" + this.loopshow() + ")*" + "(" + this.outgoingshow() + ")";
                            } else if (this.outgoing.isEmpty()) {
                                regex += "(" + this.incomingshow() + ")" + "(" + this.loopshow() + ")*";
                            } else if ((this.incoming.isEmpty()) && (this.outgoing.isEmpty())) {
                                regex += "(" + this.loopshow() + ")*";
                            } else {
                                regex += "(" + this.incomingshow() + ")" + "(" + this.loopshow() + ")*" + "(" + this.outgoingshow() + ")";
                            }
                            //regex += "(" + this.incomingshow() + ")" + "(" + this.loopshow() + ")*" + "(" + this.outgoingshow() + ")";
                        } else {//for having no loop

                            if ((this.st_list[i].get(k).state) > i) {
                                outgoing.add(this.st_list[i].get(k).language);
                            } else if ((this.st_list[i].get(k).state) < i) {
                                incoming.add(this.st_list[i].get(k).language);
                            }
                            regex += "(" + this.incomingshow() + ")" + "(" + this.outgoingshow() + ")";
                        }
                    }
//                    regex += "(" + this.incomingshow() + ")" + "(" + this.loopshow() + ")*"+"("+this.outgoingshow()+")";
//                    System.out.println(regex);
//                    this.loop.clear();
//                    this.incoming.clear();
//                    this.outgoing.clear();

                } else {
                    for (int k = 0; k < this.st_list[i].size(); k++) {
                        if ((this.st_list[i].get(k).state) == i) {//with loop
                            //until reached at last index of
                            loop.add(this.st_list[i].get(k).language);

//                           if ((this.st_list[i].get(k).state) > i) {
//                                outgoing.add(this.st_list[i].get(k).language);
//                            }
//                        else    if ((this.st_list[i].get(k).state) < i) {
//                                incoming.add(this.st_list[i].get(k).language);
//                            }
                            regex += "(" + this.incomingshow() + ")" + "(" + this.loopshow() + ")*" + "(" + this.outgoingshow() + ")";
                        } else {//for having no loop

                            if ((this.st_list[i].get(k).state) > i) {
                                outgoing.add(this.st_list[i].get(k).language);
                            } else if ((this.st_list[i].get(k).state) < i) {
                                incoming.add(this.st_list[i].get(k).language);
                            }
                            if(this.incoming.isEmpty()){
                            regex += "(" + this.outgoingshow() + ")";
                            }else if(this.outgoing.isEmpty()){
                            regex += "(" + this.incomingshow() + ")" ;
                            }else{
                            regex += "(" + this.incomingshow() + ")" + "(" + this.outgoingshow() + ")";
                            }
                            //regex += "(" + this.incomingshow() + ")" + "(" + this.outgoingshow() + ")";
                        }
                    }
//with loop
//                    for (int k = 0; k < st_list[0].size(); k++) {
//                        if ((this.st_list[i].get(k).state) > i) {
//                            outgoing.add(this.st_list[i].get(k).language);
//                        }
//                        if ((this.st_list[i].get(k).state) < i) {
//                            incoming.add(this.st_list[i].get(k).language);
//                        }
//                    }
//                    regex+="(" + this.incomingshow() + ")"+"("+this.outgoingshow()+")";
//                    System.out.println(regex);
//                    this.loop.clear();
//                    this.incoming.clear();
//                    this.outgoing.clear();

                }

            }
            this.loop.clear();
        this.incoming.clear();
        this.outgoing.clear();

        }
        System.out.println(regex);
        this.loop.clear();
        this.incoming.clear();
        this.outgoing.clear();

    }

    public String loopshow() {
        String str = "";
        for (int i = 0; i < this.loop.size(); i++) {
            str += this.loop.get(i);
        }
        return str;
    }

    public String incomingshow() {
        String str = "";
        for (int i = 0; i < this.incoming.size(); i++) {
            str += this.incoming.get(i);
        }
        return str;
    }

    public String outgoingshow() {
        String str = "";
        for (int i = 0; i < this.outgoing.size(); i++) {
            str += this.outgoing.get(i);
        }
        return str;
    }

};

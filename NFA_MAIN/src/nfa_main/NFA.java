/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfa_main;

import java.util.ArrayList;

/**
 *
 * @author ABC
 */
public class NFA {
    
        private Transition[][] TT;
        private char[] inputs;
        private int IS;
        private int[] FS;
        static string S = null;
        static Stack<Transition> backtracking = new Stack<Transition>();
        static Stack<List<int>> Paths = new Stack<List<int>>();
        static string S2 = "";

        public NFA(int IS, int[] FS, int noOfStates, char[] inputs, Transition[][] TT)
        {
            // Console.Write("Total No. of States = ");
            //int st = Convert.ToInt32(Console.ReadLine());
            this.TT = TT;
            // Console.Write("Total No. of InitialStates = ");
            //int st1 = Convert.ToInt32(Console.ReadLine());
            this.IS = IS;


            // Console.Write("Total No. of FinalStates = ");
            //int st2 = Convert.ToInt32(Console.ReadLine());
            this.FS = FS;

            //for (int i = 0; i < st2; i++)
            //{
            //    Console.Write("FinalState{0} : ", i + 1);
            //    FS[i] = Convert.ToInt32(Console.ReadLine());
            //}

            TT = new Transition[noOfStates][];

            // Console.Write("Total No. of Inputs = ");
            // int ipt = Convert.ToInt32(Console.ReadLine());
            this.inputs = inputs;



            //Console.WriteLine();


        }

        private List<int> Transition(int state, string inputstr)
        {
            List<int> index = new List<int>();

            for (int i = 0; i < TT[state].Length; i++)
            {
                if (TT[state][i].input == inputstr)
                {
                    index.Add(TT[state][i].state);
                }
            }

            return index;
        }

        private int MaxlengthTransition(int state)
        {
            int temp = 0;

            for (int i = 0; i < TT[state].Length; i++)
            {
                if (temp < TT[state][i].input.Length)
                {
                    temp = TT[state][i].input.Length;
                }
            }

            return temp;
        }

        private List<int> Recursion(int t, string str)
        {
            if (str != "")
            {
                List<int> temp = new List<int>();
                temp = Transition(t, str);
                S = str;

                if (temp.Count == 0)
                {
                    str = str.Remove(str.Length - 1);
                    temp = Recursion(t, str);
                }


                return temp;
            }
            else
            {
                return new ArrayList<int>();
            }

        }

        public boolean Validation(String VerifyString)
        {
            S = "";
            S2 = "";
            Paths.Clear();

            int CurrentState = IS;

            while (S2.Length != VerifyString.Length)
            {
            E:
                String verify = VerifyString;
                verify = verify.Remove(0, S2.Length);
                int max = MaxlengthTransition(CurrentState);
                if (max == 0)
                {
                    List<int> temp1 = Paths.Pop();
                    CurrentState = temp1[0];
                    temp1.RemoveAt(0);
                    S2 = S2.Remove(S2.Length - 1);
                    Paths.Push(temp1);
                    goto E;
                }
                if (verify.Length > max)
                {
                    verify = verify.Remove(max);
                }


                List<int> temp = Recursion(CurrentState, verify);
                S2 += S;


                if (temp.Count != 0)
                {
                    CurrentState = temp[0];
                    temp.RemoveAt(0);
                    if (temp.Count != 0)
                    {
                        Paths.Push(temp);
                    }

                }
                else
                {
                    List<int> temp1 = Paths.Pop();
                    CurrentState = temp1[0];
                    temp1.RemoveAt(0);
                    S2 = S2.Remove(S2.Length - 1);
                    Paths.Push(temp1);
                }
            }

            for (int i = 0; i < FS.Length; i++)
            {
                if (CurrentState == FS[i])
                {
                    return true;
                }
            }



            return false;
        }

}

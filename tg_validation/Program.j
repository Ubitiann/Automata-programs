package tg_validation;

import java.util.*;

//========================================================================
// This conversion was produced by the Free Edition of
// C# to Java Converter courtesy of Tangible Software Solutions.
// Order the Premium Edition at https://www.tangiblesoftwaresolutions.com
//========================================================================



public class Program
{
	static void main(String[] args)
	{
		Transition[][] TT;

		System.out.println("Enter number of states : ");
		int noOfStates = Integer.parseInt(new Scanner(System.in).nextLine());

		TT = new Transition[noOfStates][];

		System.out.println("Enter initial state : ");
		int IS = Integer.parseInt(new Scanner(System.in).nextLine());

		 System.out.println("Enter no if final states : ");
		int nfs = Integer.parseInt(new Scanner(System.in).nextLine());
		int[] FS = new int[nfs];

		for (int i = 0; i < nfs; i++)
		{
			System.out.printf("final state %1$s" + "\r\n",i);
		 FS[i] = Integer.parseInt(new Scanner(System.in).nextLine());
		}
		System.out.println("Enter number of input characters : ");
		int noInp = Integer.parseInt(new Scanner(System.in).nextLine());
		char[] input = new char[noInp];
		for (int i = 0; i < noInp; i++)
		{

			input[i] = (char)new Scanner(System.in).nextLine();
		}
		System.out.println("Create Transition Table");


		for (int i = 0; i < noOfStates; i++)
		{
			System.out.println();
			System.out.printf("No. of Transition on state%1$s : ", i);
			int temp = Integer.parseInt(new Scanner(System.in).nextLine());
			if (temp == 0)
			{
				TT[i] = null;
			}
			else
			{
			TT[i] = new Transition[temp];
			}

			for (int j = 0; j < temp; j++)
			{
				System.out.printf("Transition No.%1$s : ", j + 1);
				String s1 = new Scanner(System.in).nextLine();
				String[] str = s1.split("[,]", -1);
				TT[i][j] = new Transition(str[0].charAt(0), Integer.parseInt(str[1]));
			}
		}


		System.out.println();
		System.out.println("Enter any String for Validation");
		for (int i = 0; i < 5; i++)
		{
			DFA Check = new DFA(IS, FS, noOfStates, input, TT);
			String strng = new Scanner(System.in).nextLine();
			boolean abc = Check.Validation(strng);
			if (abc)
			{
				System.out.println("Valid");
			}
			else
			{
				System.out.println("InValid");
			}
		}


	}
}
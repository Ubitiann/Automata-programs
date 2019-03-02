package tg_validation;

import java.util.*;

public class Transition
{
	public char input;
	public int state;

	public Transition(char str, int index)
	{
		input = str;
		state = index;
	}
}
package com.iterativeProject;

import java.util.ArrayList;
import java.util.List;

public class Merge {
	public List<Integer> c = new ArrayList<Integer>();
	private int counter = 0;
	private List<Integer> arrayA = new ArrayList<Integer>();
	private List<Integer> arrayB = new ArrayList<Integer>();
	
	public void flushAll() 
	{
		arrayA.clear();
		arrayB.clear();
		c.clear();
	}
	public void setArray1(List<Integer> in) 
	{
		arrayA = in;
	}
	public void setArray2(List<Integer> in) 
	{
		arrayB = in;
	}
	public String startMerge() 
	{
		counter = 0;
		System.out.println(arrayA.size() + " " + arrayB.size());
		if(arrayA.size() == arrayB.size()) 
		{
			for (int i : arrayA) 
			{
				if(i < arrayB.get(counter)) 
				{
					c.add(i);
					c.add(arrayB.get(counter));
				} else if (i > arrayB.get(counter)) 
				{
					c.add(arrayB.get(counter));
					c.add(i);
				} else if (i == arrayB.get(counter)) 
				{
					c.add(i);
					c.add(arrayB.get(counter));
				}
				counter++;
			}
			return "Merge Successful, final array:\n" + c;
		} else {
			return "Merge failed, use int arrays of the same length!";
		}
	}
}

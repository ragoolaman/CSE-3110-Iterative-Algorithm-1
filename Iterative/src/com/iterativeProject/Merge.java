package com.iterativeWork;

import java.util.ArrayList;
import java.util.List;

public class Merge {
	
	//Variable declarations
	public List<Integer> c = new ArrayList<Integer>();
	private int counter = 0;
	private List<Integer> arrayA = new ArrayList<Integer>();
	private List<Integer> arrayB = new ArrayList<Integer>();
	
	public void flushAll() 
	{
		//Flush all list data from the last merge cycle
		arrayA.clear();
		arrayB.clear();
		c.clear();
	}
	public void setArray1(List<Integer> in) 
	{
		//Set first array values
		arrayA = in;
	}
	public void setArray2(List<Integer> in) 
	{
		//Set second array values
		arrayB = in;
	}
	public String startMerge() 
	{
		//Iteration counter
		counter = 0;
		//Ensure that the data is a similar size, or nullPointerException time!
		if(arrayA.size() == arrayB.size()) 
		{
			for (int i : arrayA) 
			{
				//compare orders to add data together
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
			//Return true
			return "Merge Successful, final array:\n" + c;
		} else {
			//Return false
			return "Merge failed, use int arrays of the same length!";
		}
	}
}

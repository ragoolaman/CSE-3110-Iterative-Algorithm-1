package com.iterativeWork;

public class Sort {
	
	//Variable declaration
	private int[] output;
	
	public void setoutputArray(int[] input) 
	{
		//Parse input array into output array
		output = new int[input.length];
		output = input;
	}
	
	public int[] bubbleSort() 
	{
		//Start the loop based upon output array length (The minus one is necessary
		//because array.length fails to take the zeroeth term into account, so array[0,1,2,3,4] would have an array.length return of 5
		//and the for() loop would then assume that the array was actually array[0,1,2,3,4,5]
		System.out.println(output.length);
		for(int a = output.length - 1; a >= 0; a--) 
		{
			for(int b = 1; b <= a; b++) 
			{
				//Checks if the current term is greater than the term next to it
				if(output[b - 1] > output[b] && b < output.length) 
				{
					//If they are, swap positions until all data is in order
					int last = output[b - 1];
					output[b - 1] = output[b];
					output[b] = last;
				}
			}
		}
		//No pos/neg, just raw output
		return output;
	}
	
	public int[] insertSort() 
	{
		//Because this type of sort runs in a reverse for() loop, the minus one is no longer necessary
		for(int a = 0; a < output.length; a++) 
		{
			//Keep the data before processing to ensure no loss of information
			int last = output[a];
			int b = a;
			while (b > 0 && output[b - 1] > last) 
			{
				//Replace data as necessary based on the for loop
				output[b] = output[b - 1];
				b--;
			}
			//ensure that the first value is maintained
			output[b] = last;
		}
		//Return the output array
		return output;
	}
}

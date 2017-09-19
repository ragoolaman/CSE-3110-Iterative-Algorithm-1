package com.iterativeWork;

import java.util.ArrayList;
import java.util.List;

public class Search {
	
	//Variable declarations
	private static int counter = 0;
	private static List<String> list = new ArrayList<String>();
	private static String searchKey;
	
	//Take input text from the user for the search
	public void setInputText(String[] input) 
	{
		for(String i : input) 
		{
			//generate a list for the input[] data
			list.add(i);
		}
	}
	public void setSearchKey(String key) 
	{
		//Set the search index term
		searchKey = key;
	}
	public String search() 
	{
		//Start a counter to track the number of iterations per run
		counter = 0;
		for (String i : list)
		{
			//Check if input[i] equals the index term
			if (list.get(counter).toLowerCase().equals(searchKey.toLowerCase())) 
			{
				//Return true
				return "Target: \"" + i + "\" located at array location: " + counter;
			}
			counter++;
		}
		//Return false
		return "Target: \"" + searchKey + "\" not found";
	}
}

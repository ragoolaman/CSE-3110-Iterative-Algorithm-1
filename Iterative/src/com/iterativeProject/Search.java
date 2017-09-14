package com.iterativeProject;

import java.util.ArrayList;
import java.util.List;

public class Search {
	
	private static int counter = 0;
	private static List<String> list = new ArrayList<String>();
	private static String searchKey;
	
	public void setInputText(String[] input) 
	{
		for(String i : input) 
		{
			list.add(i);
		}
	}
	public void setSearchKey(String key) 
	{
		searchKey = key;
	}
	public String search() 
	{
		counter = 0;
		for (String i : list)
		{
			if (list.get(counter).toLowerCase().equals(searchKey.toLowerCase())) 
			{
				return "Target: \"" + i + "\" located at array location: " + counter;
			}
			counter++;
		}
		return "Target: \"" + searchKey + "\" not found";
	}
}

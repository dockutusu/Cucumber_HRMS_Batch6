package com.hrms.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalVariables {
	
	public static String empID;
	
	public static void main(String [] args) {
		
		String name= "Kerim Dogan";
		
		String [] arr = name.split(" ");
		
		System.out.println(arr[0]);
		
		List<String> list = Arrays.asList(arr);
		
		System.out.println(list);

		
		
		
		
		
	}
	
	

}

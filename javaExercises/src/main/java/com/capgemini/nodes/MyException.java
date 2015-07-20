package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

public class MyException extends Exception {

	public static List<Exception> listOfException = new ArrayList<Exception>();
	public MyException(String msg) {
		super("MyException: \n"+msg);
		System.out.println(getMessage());
		listOfException.clear();			
	}
	
	
	
	
	
}
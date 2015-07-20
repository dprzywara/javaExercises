package com.capgemini.nodes;

public class DescriptionException extends Exception {
	
	public DescriptionException(String msg) {
		super("DescriptionException:\n" +msg+" has to long description\n");
		  }
}

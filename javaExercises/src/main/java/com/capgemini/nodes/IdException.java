package com.capgemini.nodes;

public class IdException extends Exception {

	public IdException(String msg) {
		super("IdException:\n"+msg+" has not property length of Id\n");
	}
}

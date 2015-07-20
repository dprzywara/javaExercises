/**
 * 
 */
package com.capgemini.nodes;

/**
 * @author DAPRZYWA
 *
 */
public class CycleException extends Exception {

	public CycleException(String msg) {
		super("CycleException: \n"+msg+" graph has a cycle\n");
	}
}

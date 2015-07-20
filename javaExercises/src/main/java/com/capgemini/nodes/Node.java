package com.capgemini.nodes;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node {
 
	private String id;
    private String description;
    private String predecessorId;
    
    public Node(String id, String description, String predecessorId) {
 		super();
 		this.id = id;
 		this.description = description;
 		this.predecessorId = predecessorId;
 	}
    
	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getPredecessorId() {
		return predecessorId;
	}

    
    
}

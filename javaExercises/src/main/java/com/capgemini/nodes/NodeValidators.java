package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {
	public void validateMethod(List<Node> nodes) throws MyException {
		String fullMsg = "";
		validateId(nodes);
		validateDescription(nodes);
		validateCycle(nodes);
		validatePenultimate(nodes);

		for (Exception ex : MyException.listOfException) {
			fullMsg += ex.getMessage();
		}
		if (!MyException.listOfException.isEmpty()) {
			throw new MyException(fullMsg);
		}

	}

	public void validateId(List<Node> nodes) {
		String msg = "";
		for (Node node : nodes) {
			if (node.getId().length() != 4) {
				msg += " Node nr " + node.getId();
			}
		}
		if (msg != "") {
			MyException.listOfException.add(new IdException(msg));
		}
	}

	public void validateDescription(List<Node> nodes) {
		String msg = "";
		for (Node node : nodes) {
			if (node.getDescription().length() > 128) {
				msg += " Node nr " + node.getId();
			}
		}
		if (msg != "") {
			MyException.listOfException.add(new DescriptionException(msg));
		}
	}

	public void validateCycle(List<Node> nodes) {
		String msg = "";
		int oldSize;
		boolean hasChanged = true;
		List<Node> nodesCopy = new ArrayList<Node>(nodes);
		while (hasChanged) {
			oldSize = nodesCopy.size();
			removeIfLastNode(nodes, nodesCopy);
			if (oldSize == nodesCopy.size()) {
				hasChanged = false;
			}
		}
		for (Node node : nodesCopy) {
			msg += " Node nr " + node.getId();
		}
		if (msg != "") {
			MyException.listOfException.add(new CycleException(msg));
		}
	}

	private void removeIfLastNode(List<Node> nodes, List<Node> nodesCopy) {
		boolean hasnextNode;
		for (Node ni : nodes) {
			hasnextNode = false;
			for (Node nj : nodes) {
				if (ni.getId() == nj.getPredecessorId() && nodesCopy.contains(ni) && nodesCopy.contains(nj)) {
					hasnextNode = true;
				}
			}
			if (!hasnextNode) {
				nodesCopy.remove(ni);
			}
		}
	}

	public void validatePenultimate(List<Node> nodes) {
		String msg = "";
		Map<String, Integer> mapOfSubsequents = new HashMap<String, Integer>();

		for (Node node : nodes) {
			if (node.getPredecessorId() != "") {
				countPredecessors(mapOfSubsequents, node);
				if (mapOfSubsequents.get(node.getPredecessorId()) > 2) {
					msg += "Node nr " + node.getPredecessorId() + " has more than 2 subsequents\n";
				}

				msg += checkIfPenultimate(nodes, mapOfSubsequents, node);
			}
		}
		if (msg != "") {
			MyException.listOfException.add(new PenultimateException(msg));
		}

	}

	private String checkIfPenultimate(List<Node> nodes, Map<String, Integer> mapOfSubsequents, Node node) {
		boolean isLast;
		String msg = "";
		if (mapOfSubsequents.get(node.getPredecessorId()) == 2) {
			isLast = true;
			for (Node ni : nodes) {
				if (node.getId() == ni.getPredecessorId()) {
					isLast = false;
				}
			}
			if (!isLast) {
				msg += "Node nr " + node.getPredecessorId() + " has 2 subsequents and is not penultimate\n";
			}
		}
		return msg;
	}

	private void countPredecessors(Map<String, Integer> mapOfSubsequents, Node node) {
		int counter;
		if (mapOfSubsequents.containsKey(node.getPredecessorId())) {
			counter = mapOfSubsequents.get(node.getPredecessorId());
			mapOfSubsequents.put(node.getPredecessorId(), counter = counter + 1);
		}
		if (!mapOfSubsequents.containsKey(node.getPredecessorId())) {
			mapOfSubsequents.put(node.getPredecessorId(), 1);
		}
	}

}

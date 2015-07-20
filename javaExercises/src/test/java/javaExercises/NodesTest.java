package javaExercises;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.nodes.CycleException;
import com.capgemini.nodes.DescriptionException;
import com.capgemini.nodes.IdException;
import com.capgemini.nodes.MyException;
import com.capgemini.nodes.Node;
import com.capgemini.nodes.NodeValidators;
import com.capgemini.nodes.PenultimateException;

public class NodesTest {
	private Node node;
	private NodeValidators nvalidator;
	private List<Node> nodes;

	@Before
	public void Before() {
		nvalidator = new NodeValidators();
		nodes = new ArrayList<Node>();
		MyException.listOfException.clear();

	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldAddIdExceptionToExceptionList() {
		buildNodeList(new Node("0000", "Am I wrong?0", ""), new Node("001", "Am I wrong?1", "0000"),
				new Node("0002", "Am I wrong?2", "0001"));

		nvalidator.validateId(nodes);
		Assert.assertEquals(true,
				MyException.listOfException.size() == 1 && MyException.listOfException.get(0) instanceof IdException);

	}

	@Test
	public void shouldAddDescriptionExceptionToExceptionList() {
		buildNodeList(new Node("0000", "Am I wrong?0", ""), new Node("0001", "Am I wrong?1", "0000"),
				new Node("0002",
						"Am I wrong?21110000222211112226335454555555566666666666666666666666666666666655555555555454545545454545454545454545454545454545454545",
						"0001"));
		nvalidator.validateDescription(nodes);
		Assert.assertEquals(true, MyException.listOfException.size() == 1
				&& MyException.listOfException.get(0) instanceof DescriptionException);

	}

	@Test
	public void shouldThrowCycleException() {
		buildNodeList(new Node("0000", "Am I wrong?0", "0003"), new Node("0001", "Am I wrong?1", "0000"),
				new Node("0002", "Am I wrong?21", "0001"), new Node("0003", "Am I wrong?12", "0002"));

		nvalidator.validateCycle(nodes);
		Assert.assertEquals(true, MyException.listOfException.size() == 1
				&& MyException.listOfException.get(0) instanceof CycleException);

	}

	@Test
	public void shouldThrowPenultimateException() {
		buildNodeList(new Node("0000", "Am I wrong?0", ""), new Node("0001", "Am I wrong?1", "0000"),
				new Node("0002", "Am I wrong?21", "0001"), new Node("0003", "Am I wrong?12", "0002"),
				new Node("0004", "Am I wrong?12", "0002"), new Node("0005", "Am I wrong?12", "0002"));
		nvalidator.validatePenultimate(nodes);
		Assert.assertEquals(true, MyException.listOfException.size() == 1
				&& MyException.listOfException.get(0) instanceof PenultimateException);

	}

	@Test
	public void shouldThrowMyException() throws MyException {
		buildNodeList(new Node("0000", "Am I wrong?0", "0006"), new Node("001", "Am I wrong?1", "0000"),
				new Node("0002",
						"Am I wro55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555ng?21",
						"001"),
				new Node("0003", "Am I wrong?12", "0002"), new Node("0004", "Am I wrong?12", "0002"),
				new Node("0005", "Am I wrong?12", "0002"), new Node("0006", "Am I wrong?12", "0000"));

		thrown.expect(MyException.class);
		nvalidator.validateMethod(nodes);

	}

	@Test
	public void shouldThrowMyExceptionForNoConnectedGraph() throws MyException {
		buildNodeList(new Node("0001", "Am I wrong?0", ""), new Node("002", "Am I wrong?1", "0001"),
				new Node("0003",
						"Am I wro55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555ng?21",
						"002"),
				new Node("0004", "Am I wrong?12", "002"), new Node("0005", "Am I wrong?12", ""),
				new Node("0006", "Am I wrong?12", "0005"), new Node("0007", "Am I wrong?12", "0006"),
				new Node("0008", "Am I wrong?12", "0006"), new Node("0015", "Am I wrong?12", "0006"),
				new Node("011", "Am I wrong?12", "0010"), new Node("0009", "Am I wrong?12", "011"),
				new Node("0010", "Am I wrong?12", "0009"), new Node("0012", "Am I wrong?12", "0014"),
				new Node("0014", "Am I wrong?12", "0013"), new Node("0013", "Am I wrong?12", "0012"),
				new Node("0020",
						"Am I wro7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777ng?12",
						""));

		thrown.expect(MyException.class);
		nvalidator.validateMethod(nodes);

	}

	private void buildNodeList(Node... nodesArray) {
		for (Node n : nodesArray) {
			nodes.add(n);

		}
	}

}

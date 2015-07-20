package javaExercises;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.gameoflife.Cell;
import com.capgemini.gameoflife.Game;
import com.capgemini.gameoflife.Position;



public class GoLTest {
	Game game ;
	@Before
	public void before(){
		
		game = new Game(new Boolean[][]{ { false, true, false }, { true, true, true },

			{ false, true, false } });
		
	}

	
	@Test
	public void shouldReturnListOfNeightbours() {
		
		List<Cell> listOfneightbours = new ArrayList<Cell>();
		Cell c = new Cell(true, new Position(0,0));
		listOfneightbours.add(new Cell(true,new Position(0, 1)));
		listOfneightbours.add(new Cell(true,new Position(1, 0)));
		listOfneightbours.add(new Cell(true,new Position(1, 1)));
		
		Assert.assertArrayEquals(listOfneightbours.toArray(), game.findCellNeightbours(c).toArray());
	}
	@Test
	public void shouldReturnTrueForDeadCellAnd3Neightbours() {

		game.nexIteration();
		Assert.assertEquals(true,game.getMapOfCells().get(new Position(0,0)).isAlife() );
	}
	@Test
	public void shouldReturnFalseForDeadCellAnd0Neightbours() {

		game.nexIteration();
		game.nexIteration();
		game.nexIteration();
		game.nexIteration();
		Assert.assertEquals(false,game.getMapOfCells().get(new Position(1,1)).isAlife() );
	}
	
	
	@Test
	public void shouldReturnTrueForLifeCellAnd2Neightbours() {
		
		game.nexIteration();
		game.nexIteration();
		Assert.assertEquals(true,game.getMapOfCells().get(new Position(0,2)).isAlife() );
	}
	@Test
	public void shouldReturnFalseForLifeCellAnd4Neightbours() {
		
		game.nexIteration();
		Assert.assertEquals(false,game.getMapOfCells().get(new Position(1,1)).isAlife() );
	}
	@Test
	public void shouldReturnFalseForLifeCellAnd0Neightbours() {
		
		game.nexIteration();
		game.nexIteration();
		game.nexIteration();
		Assert.assertEquals(false,game.getMapOfCells().get(new Position(2,0)).isAlife() );
	}
	@Test
	public void shouldReturnTrueForLifeCellAnd3Neightbours() {
		
		game.nexIteration();
		game.showGameMap();
		Assert.assertEquals(true,game.getMapOfCells().get(new Position(1,2)).isAlife() );
	}
	@Test
	public void shouldReturn9KeysInMapOf9Cells() {
		
		Game g = new Game(3,3);
		Assert.assertEquals(9,g.getMapOfCells().keySet().size());
	}
	
	
	
	
	
	

}

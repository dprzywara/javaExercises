package com.capgemini.gameoflife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

	private int maxlengthOfTable;
	private int maxwidthOfTable;

	private Map<Position, Cell> mapOfCells = new HashMap<Position, Cell>();

	public Map<Position, Cell> getMapOfCells() {
		return mapOfCells;
	}


	public Game(Boolean[][] booleans) {
		this.maxlengthOfTable = booleans.length;
		this.maxwidthOfTable = booleans[0].length;

		for (int i = 0; i < maxlengthOfTable; i++) {
			for (int j = 0; j < maxwidthOfTable; j++) {
				Position tempPosition = new Position(i, j);
				mapOfCells.put(tempPosition, new Cell(booleans[i][j], tempPosition));
			}
		}

	}

	public Game(int x, int y) {
		this.maxlengthOfTable = y;
		this.maxwidthOfTable = x;
		Random rand = new Random();
		Position tempPosition;
		for (int i = 0; i < maxlengthOfTable; i++) {
			for (int j = 0; j < maxwidthOfTable; j++) {
				tempPosition = new Position(i, j);
				mapOfCells.put(tempPosition, (new Cell(rand.nextBoolean(), tempPosition)));
			}
		}

	}

	public List<Cell> findCellNeightbours(Cell cell) {
		List<Cell> templistOfneightbours = new ArrayList<Cell>();

		for (int i = cell.getPos().getPosx() - 1; i <= cell.getPos().getPosx() + 1; i++) {
			for (int j = cell.getPos().getPosy() - 1; j <= cell.getPos().getPosy() + 1; j++) {
				Position tempKey = new Position(i, j);
				if (mapOfCells.containsKey(tempKey) && !cell.getPos().equals(tempKey)) {
					templistOfneightbours.add(mapOfCells.get(tempKey));
				}
			}
		}
		return templistOfneightbours;
	}


	public void nexIteration() {
		
		for (Cell c : mapOfCells.values()) {
			c.setListOfNeightbours(findCellNeightbours(c));
			c.calculateNextState();
		}
		updateCellState();
	}


	private void updateCellState() {
		for (Cell cell : mapOfCells.values()) {
			cell.updateState();
		}
	}

	public void showGameMap() {
		String symbol = "   ";
		
		System.out.println("Game of Life: ");
		for (int n = 0; n < maxwidthOfTable; n++) {
			System.out.print(" ___");
		}
		System.out.println();
		for (int i = 0; i < maxlengthOfTable; i++) {
			for (int j = 0; j < maxwidthOfTable; j++) {
				symbol = "   ";
				Position tempKey = new Position(i, j);
				if (mapOfCells.get(tempKey).isAlife()) {
					symbol = " * ";
				}
				System.out.print("|" + symbol);

				if (j == maxwidthOfTable - 1) {
					System.out.println("|");
				}

			}
			for (int n = 0; n < maxwidthOfTable; n++) {
				System.out.print(" ___");
			}
			System.out.println();

		}
		System.out.println();
	}

}

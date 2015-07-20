package javaExercises;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.placeToSplit.PlaceToSplit;

public class PlaceToSplitTest {

	@Test
	public void shouldReturnTrueForPositiveNumbers() {
		Assert.assertEquals(true, PlaceToSplit.canBalance(new int[] {1, 1, 1, 2, 1}));
	}
	@Test
	public void shouldReturnTrueForNegativeNumbers() {
		Assert.assertEquals(true, PlaceToSplit.canBalance(new int[] {2, 1, -1, 2, 0}));
	}
	@Test
	public void shouldReturnFalseForPositiveNumbersEvenSumOfArray() {//parzysta
		Assert.assertEquals(false, PlaceToSplit.canBalance(new int[] {2, 0, 4}));
	}
	@Test
	public void shouldReturnFalseForPositiveNumbersOddSumOfArray() {
		Assert.assertEquals(false, PlaceToSplit.canBalance(new int[] {2, 1, 1, 2, 1}));
	}
	@Test
	public void shouldReturnFalseForNegaitiveNumbersEvenSumOfArray() {
		Assert.assertEquals(false, PlaceToSplit.canBalance(new int[] {-2, 1, 1, 2, 6}));
	}

}

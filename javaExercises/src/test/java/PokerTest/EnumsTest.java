package PokerTest;
import org.junit.Assert;
import org.junit.Test;

import com.capgemini.pokerHands.CardColors;
import com.capgemini.pokerHands.CardValues;

public class EnumsTest {

	@Test
	public void ShoudReturnTWOFor2() {
		Assert.assertEquals(CardValues.TWO,CardValues.getValueOf("2"));
	}
	
	@Test
	public void ShoudReturnACEForA() {
		Assert.assertEquals(CardValues.ACE,CardValues.getValueOf("A"));
	}
	@Test
	public void ShoudReturnHEARTForH() {
		Assert.assertEquals(CardColors.HEART,CardColors.getValueOf("H"));
	}

}

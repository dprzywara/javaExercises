package Poker2Test;
import org.junit.Assert;
import org.junit.Test;

import com.capgemini.pokerHands2.Colors;
import com.capgemini.pokerHands2.CardValues;

public class EnumsTest {

	@Test
	public void ShoudReturnTWOFor2() {
		Assert.assertEquals(CardValues.TWO,CardValues.selectValue("2"));
	}
	
	@Test
	public void ShoudReturnACEForA() {
		Assert.assertEquals(CardValues.ACE,CardValues.selectValue("A"));
	}
	@Test
	public void ShoudReturnHEARTForH() {
		Assert.assertEquals(Colors.HEART,Colors.selectColor("H"));
	}

}

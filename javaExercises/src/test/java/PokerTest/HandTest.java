package PokerTest;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.pokerHands.CardValues;
import com.capgemini.pokerHands.Hand;
import com.capgemini.pokerHands.PokerGame;
import com.capgemini.pokerHands.Rank;

public class HandTest {
	Hand hand ;
	PokerGame game = new PokerGame();
	Rank rank;
@Before
public void before(){
	hand =new Hand();
	rank = new Rank();
	
}
	@Test
	public void shouldReturn3AsSizeOfMap() {
		hand=game.assignHand("8C TS TC 2H 2S");
		Assert.assertEquals(3, hand.getMapOfOccurance().size());
	}
	@Test
	public void shouldReturn5AsSizeOfMap() {
		hand=game.assignHand("2C 3S 4C 5H 6S");
		Assert.assertEquals(5, hand.getMapOfOccurance().size());
	}
	@Test
	public void shouldReturnTrueForCardInTheSameColor() {
		hand=game.assignHand("8C TC TC 2C 2C");
		Assert.assertEquals(true, hand.isColor());
	}
	@Test
	public void shouldReturnFalseForCardNotInTheSameColor() {
		hand=game.assignHand("8C TH TC 2C 2C");
		Assert.assertEquals(false, hand.isColor());
	}
	@Test
	public void shouldReturnKINGasFirstElement() {
		hand=game.assignHand("2C 2H KC KC AC");
		rank.sortMapOfOccurance(hand.getMapOfOccurance());
		Assert.assertEquals(CardValues.KING, rank.getSortedMapOfOccurance().firstKey());
	}
	@Test
	public void shouldReturnFIVEasFirstElement() {
		hand=game.assignHand("AC 5H 5C KC 5C");
		rank.sortMapOfOccurance(hand.getMapOfOccurance());
		Iterator<Integer> iterP1 =rank.getSortedMapOfOccurance().values().iterator(); 
		
		Assert.assertEquals(CardValues.FIVE, rank.getSortedMapOfOccurance().firstKey());
	}
	@Test
	public void shouldReturnTRUEForTheSameColor() {
		hand=game.assignHand("8C TC 9C 2C AC");
		rank = game.createRank(hand);
		
		Assert.assertEquals(true, rank.isColor());
	}
	@Test
	public void shouldReturnFALSEForDiferentColor() {
		hand=game.assignHand("8C TC 9C 2H AC");
		rank = game.createRank(hand);
		
		Assert.assertEquals(false, rank.isColor());
	}

}

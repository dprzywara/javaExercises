package Poker2Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.pokerHands2.CardValues;
import com.capgemini.pokerHands2.Hand;
import com.capgemini.pokerHands2.PokerGame;
import com.capgemini.pokerHands2.Rank;

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
		rank=game.createRank(hand);
		Assert.assertEquals(3, rank.getHandsRanked().size());
	}
	@Test
	public void shouldReturn5AsSizeOfList() {
		hand=game.assignHand("2C 3S 4C 5H 6S");
		rank=game.createRank(hand);
		Assert.assertEquals(5, rank.getHandsRanked().size());
	}
	@Test
	public void shouldReturnTrueForCardInTheSameColor() {
		hand=game.assignHand("8C TC TC 2C 2C");
		Assert.assertEquals(true, hand.isTheSameColor());
	}
	@Test
	public void shouldReturnFalseForCardNotInTheSameColor() {
		hand=game.assignHand("8C TH TC 2C 2C");
		Assert.assertEquals(false, hand.isTheSameColor());
	}
	@Test
	public void shouldReturnKINGasFirstElement() {
		hand=game.assignHand("2C 2H KC KC AC");
		rank=game.createRank(hand);
		
		Assert.assertEquals(CardValues.KING, rank.getListOfOccuranceValues().getFirst());
	}
	@Test
	public void shouldReturnFIVEasFirstElement() {
		hand=game.assignHand("AC 5H 5C KC 5C");
		rank=game.createRank(hand);
		Assert.assertEquals(CardValues.FIVE, rank.getListOfOccuranceValues().getFirst());
	}
	@Test
	public void shouldReturn3ForTheHighestOccurance() {
		hand=game.assignHand("8C 8S 8H 2C AC");
		rank=game.createRank(hand);
		
		Assert.assertEquals(true, rank.getListOfOccurance().getFirst().equals(3));
	}
	@Test
	public void shouldReturnFALSEForDiferentColor() {
		hand=game.assignHand("8C TC 9C 2H AC");
		rank=game.createRank(hand);
		
		Assert.assertEquals(false, rank.getIsColor());
	}

}

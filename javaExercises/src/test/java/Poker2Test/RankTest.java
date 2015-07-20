package Poker2Test;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.pokerHands2.Hand;
import com.capgemini.pokerHands2.PokerGame;
import com.capgemini.pokerHands2.Rank;

public class RankTest {

	Hand hand1,hand2 ;
	PokerGame game = new PokerGame();
	Rank player1,player2;
@Before
public void before(){
	hand1 =new Hand();
	hand2 =new Hand();
	player1 = new Rank();
	player2 = new Rank();
}
	@Test
	public void shouldReturn1() {
		hand2=game.assignHand("8C TS 9C 2H 3S");
		hand1=game.assignHand("8C TS TC 2H 2S");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn2() {
		hand1=game.assignHand("8C TS TC 2H 2S");
		hand2=game.assignHand("8C 8S 8H 2H 3S");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		Assert.assertEquals(2, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1Color() {
		hand1=game.assignHand("8C TC 9C 2C AC");
		hand2=game.assignHand("8C 9S TH JH QS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn2Consecutive() {
		hand1=game.assignHand("8H TC 9C 2S AC");
		hand2=game.assignHand("8C 9S TH JH QS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(2, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1RoyalFlush() {
		hand1=game.assignHand("TH JH QH KH AH");
		hand2=game.assignHand("9C TS JH QH KS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1TheSameRank() {
		hand1=game.assignHand("TH TH QH QH AH");
		hand2=game.assignHand("TC TS QH QH KS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1TheSameRank3() {
		hand1=game.assignHand("TH TH TH QH AH");
		hand2=game.assignHand("8C 8S 8H QH KS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1TheSameRank1Pair() {
		hand1=game.assignHand("3S KS QS 7H KH");
		hand2=game.assignHand("7D 5H 5D JD AD");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1TheSameRank2Pairs() {
		hand1=game.assignHand("2H 2C 6H TH TC");
		hand2=game.assignHand("7D 8D 4H 8C AS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1ForNoColorNoConsecutive() {
		hand1=game.assignHand("AH AC AS AD TC");
		hand2=game.assignHand("7D 8D 4H JC AS");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn2ForColorANDConsecutive() {
		hand1=game.assignHand("AH AC AS AD TC");
		hand2=game.assignHand("7D 8D 9D TD JD");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(2, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn2ForTheSameColorAndP1Consecutive() {
		hand1=game.assignHand("AH 2H 5H 6H TH");
		hand2=game.assignHand("7D 8D 9D TD JD");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(2, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn2ForColor() {
		hand1=game.assignHand("AH 2S 5H 6H TH");
		hand2=game.assignHand("7D 8D 9D TD JD");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(2, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1ForSize5AndNoColorNoConsecutiveP2size2() {
		hand1=game.assignHand("2H 3H 4H 6H 5H");
		hand2=game.assignHand("7D 7S 7D TD TD");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	@Test
	public void shouldReturn1ForSize5AndNoColorNoConsecutiveP2size3() {
		hand1=game.assignHand("2H 3H 4H 6H 5H");
		hand2=game.assignHand("7D 7S 7D TD 5D");
		player1=game.createRank(hand1);
		player2=game.createRank(hand2);
		
		Assert.assertEquals(1, game.checkResult(player1, player2));
	}
	/*@Test
	public void shouldReturn376ForEntryFile() throws FileNotFoundException {
		game.readDataFromFile();
		Assert.assertEquals(376, game.countWins());
	}*/
	

	
}

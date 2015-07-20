package javaExercises;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.coins.Coins;

public class CoinsTest {
	private List<Integer> coins;
	
	@BeforeClass
	public static void createInstance(){
		Coins c =new Coins();
	}
	
	@Before
	public void before() {
		coins = new ArrayList<Integer>();
	}

	@Test
	public void shouldReturn4Optimal() {

		coins = Arrays.asList(1, 1, 0, 1, 0, 0);
		Assert.assertEquals(4, Coins.solution(coins));

	}

	@Test
	public void shouldReturn5() {
		coins = Arrays.asList(0, 0, 0, 0, 0, 0);
		Assert.assertEquals(5, Coins.solution(coins));

	}

	@Test
	public void shouldReturn4FullReview() {
		coins = Arrays.asList(1, 1, 0, 0, 0, 1);
		Assert.assertEquals(4, Coins.solution(coins));

	}


}

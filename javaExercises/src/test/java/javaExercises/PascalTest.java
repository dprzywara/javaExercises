package javaExercises;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.pascalrectangle.PascalRectangle;


public class PascalTest {
	PascalRectangle pascal;
	@Before
	public void before(){
		pascal = new PascalRectangle();
	}
	@Rule
    public ExpectedException thrown= ExpectedException.none();

	@Test
	public void shouldReturn1For0_0() {
		Assert.assertEquals(1,pascal.pascal(0,0));
	}
	
	@Test
	public void shouldReturn4For1_4() {
		Assert.assertEquals(4,pascal.pascal(1,4));
	}
	@Test
	public void shouldReturn126For5_9() {
		Assert.assertEquals(126,pascal.pascal(5,9));
	}
	@Test
	public void shouldReturnExceptionFor4_1() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		pascal.pascal(4,1);
	}

}

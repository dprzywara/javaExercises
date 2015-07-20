package javaExercises;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.fibonacci.Fibonacci;

public class FiboTest {
	@BeforeClass
	public static void createInstance(){
		Fibonacci f = new Fibonacci();
	}
	
	@Test
	public void shouldReturn1ForF0() {
		Assert.assertEquals(1, Fibonacci.fib(0));
	}
	@Test
	public void shouldReturn1ForF1() {
		Assert.assertEquals(1, Fibonacci.fib(1));
	}
	@Test
	public void shouldReturn2ForF2() {
		Assert.assertEquals(2, Fibonacci.fib(2));
	}
	@Test
	public void shouldReturn55ForF9() {
		Assert.assertEquals(55, Fibonacci.fib(9));
	}
	
	//iternacyjnie
	@Test
	public void shouldReturn55ForF9Iter() {
		Assert.assertEquals(55, Fibonacci.fibIter(9));
	}
	@Test
	public void shouldReturn1ForF0Iter() {
		Assert.assertEquals(1, Fibonacci.fibIter(0));
	}
	@Test
	public void shouldReturn1ForF1Iter() {
		Assert.assertEquals(1, Fibonacci.fibIter(1));
	}
	@Test
	public void shouldReturn2ForF2Iter() {
		Assert.assertEquals(2, Fibonacci.fibIter(2));
	}

}

package javaExercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.pythagorean.Pythagorean;

public class PythagoreanTest {
	Pythagorean pythagorean ;
	@Before
	public void before(){
		pythagorean = new Pythagorean();
	}
	@Test
	public void ShouldReturnCorrectProduct() {
	
		Assert.assertEquals(31875000, pythagorean.find());
	}
	@Test
	public void ShouldReturnCorrectProduct2() {
		
		Assert.assertEquals(31875000, pythagorean.find2());
	}

}

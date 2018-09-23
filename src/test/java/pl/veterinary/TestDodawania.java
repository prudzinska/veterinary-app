package pl.veterinary;

import org.junit.Assert;
import org.junit.Test;

public class TestDodawania {

	@Test
	public void testDodawania() {
		// given
		int wynik = 0;

		// when
		wynik = dodawanie(3, 5);

		// then
		Assert.assertEquals(8, wynik);
	}

	private int dodawanie(int a, int b) {
		return a + b;
	}

}

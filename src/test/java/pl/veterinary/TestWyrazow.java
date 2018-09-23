package pl.veterinary;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestWyrazow {

	@Test
	public void testPowiekszaniaLiter() {
		// given
		MojeNarzedzieDoPowiekszaniaLiter narzedzie = new MojeNarzedzieDoPowiekszaniaLiter();

		List<String> wyrazy = new ArrayList<String>();
		wyrazy.add("piesek");
		wyrazy.add("kotek");
		wyrazy.add("kwiatek");

		// when
		List<String> powiekszoneWyrazy = narzedzie.powiekszLitery(wyrazy);

		// then
		Assert.assertEquals("PIESEK", powiekszoneWyrazy.get(0));
		Assert.assertEquals("KOTEK", powiekszoneWyrazy.get(1));
		Assert.assertEquals("KWIATEK", powiekszoneWyrazy.get(2));

	}

}

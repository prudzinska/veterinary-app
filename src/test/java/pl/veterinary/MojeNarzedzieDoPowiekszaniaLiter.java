package pl.veterinary;

import java.util.ArrayList;
import java.util.List;

public class MojeNarzedzieDoPowiekszaniaLiter {

	public List<String> powiekszLitery(List<String> wyrazy) {
		List<String> powiekszoneWyrazy = new ArrayList<String>();

		for (String wyraz : wyrazy) {
			String duzyWyraz = wyraz.toUpperCase();
			powiekszoneWyrazy.add(duzyWyraz);

		}
		return powiekszoneWyrazy;
	}

}

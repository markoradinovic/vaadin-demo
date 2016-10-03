package rs.codecentric.service;

import java.util.Arrays;
import java.util.List;

public class InMemoryDataService implements DataService {

	@Override
	public List<String> readData() {
		return Arrays.asList(new String[] {"Marko", "Adriana", "Vuk"});
	}

}

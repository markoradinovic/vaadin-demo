package rs.codecentric.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryFriendsService implements FriendsService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public List<String> readFriends() {
		return Arrays.asList(new String[] {"Marko", "Adriana", "Vuk"});
	}

	@Override
	public void saveFriend(String friend) {
		LOG.info("Saving friend: '" + friend + "'.");
	}

}

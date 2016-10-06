package rs.codecentric.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.codecentric.service.FriendsService;
import rs.codecentric.service.InMemoryFriendsService;
import rs.codecentric.service.JdbcFriendsService;

@Configuration
public class DataServiceConfiguration {
	
	@Bean
	@ConditionalOnProperty(name="dataservice.type", havingValue="jdbc")
	public FriendsService dataService() {
		return new JdbcFriendsService();
	}
	
	@Bean
	@ConditionalOnMissingBean(FriendsService.class)
	public FriendsService defaultDataService() {
		return new InMemoryFriendsService();
	}

}

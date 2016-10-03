package rs.codecentric.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.codecentric.service.DataService;
import rs.codecentric.service.InMemoryDataService;
import rs.codecentric.service.JdbcDataService;

@Configuration
public class DataServiceConfiguration {
	
	@Bean
	@ConditionalOnProperty(name="dataservice.type", havingValue="jdbc")
	public DataService dataService() {
		return new JdbcDataService();
	}
	
	@Bean
	@ConditionalOnMissingBean(DataService.class)
	public DataService defaultDataService() {
		return new InMemoryDataService();
	}

}

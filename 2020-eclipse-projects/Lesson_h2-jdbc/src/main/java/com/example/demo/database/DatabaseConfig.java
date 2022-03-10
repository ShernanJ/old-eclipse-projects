package com.example.demo.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration //This is a configuration component
public class DatabaseConfig {
	
	/**
	 * A simple method that returns a NamedParameterJdbcTemplate Bean
	 * @param dataSource Will be injected by String
	 * @return the instance of NamedParameterJdbcTemplate
	 */
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}

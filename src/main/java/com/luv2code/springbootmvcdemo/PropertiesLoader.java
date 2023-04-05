package com.luv2code.springbootmvcdemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:countries.properties")
@PropertySource("classpath:operatingsystems.properties")
public class PropertiesLoader {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@Value("#{os}")
	private Map<String, String> operatingSystemOptions;
}

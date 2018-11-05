package com.figue.test.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

@Configuration
@EnableFeignClients(basePackages = {"com.figue.test"})
public class FeignConfiguration {
	@Bean
	Logger.Level feginLogLevel(){
		return Logger.Level.FULL;
	}
	
	@Bean
    public com.figue.test.filter.AMRequestFilter AMRequestFilter() {
    	return new com.figue.test.filter.AMRequestFilter();
    }
}

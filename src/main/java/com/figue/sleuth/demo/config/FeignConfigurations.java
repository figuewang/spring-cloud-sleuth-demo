package com.figue.sleuth.demo.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.figue.sleuth.demo.filter.RequestFilter;

import feign.Logger;

@Configuration
@EnableFeignClients(basePackages = {"com.figue.sleuth.demo"})
public class FeignConfigurations {
	@Bean
	Logger.Level feginLogLevel(){
		return Logger.Level.FULL;
	}
	
	@Bean
    public RequestFilter requestFilter() {
    	return new RequestFilter();
    }
}

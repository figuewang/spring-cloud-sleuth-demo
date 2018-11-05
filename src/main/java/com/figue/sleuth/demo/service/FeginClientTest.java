package com.figue.sleuth.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "demo")
public interface FeginClientTest {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test();
}

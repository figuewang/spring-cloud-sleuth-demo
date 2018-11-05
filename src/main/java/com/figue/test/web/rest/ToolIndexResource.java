package com.figue.test.web.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.figue.test.service.FeginClientTest;

import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;

@RestController
public class ToolIndexResource {

	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private Tracer tracer;
	
	@Autowired
	private FeginClientTest feginClientTest;
	
	@GetMapping("/1")
    public String test1()  {	
		log.info("1111111");
		ExtraFieldPropagation.set(this.tracer.currentSpan().context(), "foo", "ygg"+System.currentTimeMillis());		
		return feginClientTest.test();
    }

	@GetMapping("/test")
    public String test()  {	
		log.info("2222222");
		return "test" + System.currentTimeMillis();
    }
}
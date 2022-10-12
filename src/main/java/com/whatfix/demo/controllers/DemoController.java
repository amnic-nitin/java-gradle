package com.whatfix.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private Environment env;

	@RequestMapping("hello")
	public String helloWorld() {
		return "Hello World V2!";
	}

	@RequestMapping("ruok")
	public String ruok() {
		return "iamok";
	}

	@RequestMapping("hello/{name}")
	public String helloWorldName(@PathVariable String name) {
		return "Hello World! " + name + ". Greetings from " + env.getProperty("service.name");
	}

}

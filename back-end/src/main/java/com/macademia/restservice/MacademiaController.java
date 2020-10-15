package com.macademia.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MacademiaController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/macademia")
	public Macademia macademia(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Macademia(counter.incrementAndGet(), String.format(template, name));
	}
}
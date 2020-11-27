package com.macademia.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macademia.main.*;
import com.macademia.main.test.JsonTest;

@RestController
public class MacademiaController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private JsonTest tester = new JsonTest();

	@GetMapping("/macademia")
	public Macademia macademia(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Macademia(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/course")
	public Course course() {
		return tester.testCourseA;
	}

	@GetMapping("/section")
	public Section section() {
		return tester.testSectionA01;
	}

	@GetMapping("/department")
	public Department department() {
		return tester.testDepartment;
	}

	@GetMapping("/matricula")
	public Matricula matricula() {
		return tester.testMatriculaA;
	}

	@GetMapping("/addSection")
	public Section addSection() {
		tester.testMatriculaB.addSections(tester.testSectionA01);
		return tester.testSectionA01;
	}

}
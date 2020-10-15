package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.macademia.Student;
import com.example.macademia.Course;
import com.example.macademia.Department;
import com.example.macademia.Matricula;
import com.example.macademia.Section;
import com.example.macademia.auth.User;

@RestController
public class GreetingController {

	// private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	Department FunLand = new Department("The Department of Comedy", "FUNY");
	Department Drama = new Department("The Department of Drama", "DRAM");

	@GetMapping("/greeting")
	public Greeting greeting() {
		return new Greeting(0, "TEST");
	}

	@GetMapping("/course")
	public Course course() {
		return new Course("Intro to Comedy", FunLand, 3101, 3);
	}

}

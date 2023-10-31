package com.examplee;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping("/msg")
	public String helloworld()
	{
		return "Hello Spring Boot";
	}
	
	@GetMapping("/date")
	public LocalDate displayData()
	{
	LocalDate d=LocalDate.now();

	return d;
		
	
	
	}
	@GetMapping("/upd")
	public String d3()
	{
		LocalDate d1=LocalDate.now();
		DateTimeFormatter d2=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String s=d1.format(d2);
		return s;
	};
	
}

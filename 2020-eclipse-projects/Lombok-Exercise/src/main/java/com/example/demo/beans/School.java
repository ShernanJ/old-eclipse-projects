package com.example.demo.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class School {
	
	private String name;
	private String address;
	private int numStudents;
	
	public School() {
		
	}
}

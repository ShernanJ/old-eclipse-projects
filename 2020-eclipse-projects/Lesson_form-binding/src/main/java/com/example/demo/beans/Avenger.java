package com.example.demo.beans;

import lombok.Data;

@Data
public class Avenger {
	
	private String name;
	private int age;
	private String powerSource;
	
	private final String[] powerSources =
		{"Magic", "Technology", "Deity", "Training"};
}

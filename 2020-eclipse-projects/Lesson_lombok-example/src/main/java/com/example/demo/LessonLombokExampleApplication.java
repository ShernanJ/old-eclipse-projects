package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.beans.School;

@SpringBootApplication
public class LessonLombokExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LessonLombokExampleApplication.class, args);
		
		School school = (School) context.getBean("school");
		
		// Eclipse doesn't know about the getter Lombok created...
		System.out.println(school.getName());
	}

}

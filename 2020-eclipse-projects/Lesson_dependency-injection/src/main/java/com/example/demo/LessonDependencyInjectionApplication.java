package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.beans.School;

@SpringBootApplication
public class LessonDependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LessonDependencyInjectionApplication.class, args);
		
		School school = (School) context.getBean("school");
		
		System.out.println(school);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {
	
	// What are the beans? ==> @Component
	// What are the dependencies for a bean? ==> @Autowired
	// Wehere to search for beans? ==> No need

	public static void main(String[] args) {
		
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
		// Application Context
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] {12,  4, 6}, 2);
		System.out.println(result);
		// com.example.demo.BubbleSortAlgorithm@46271dd6
		// 3
		
	}

}

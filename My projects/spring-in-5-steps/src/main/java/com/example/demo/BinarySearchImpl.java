package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Indicamos que BinarySearchImpl es un bean
@Component
public class BinarySearchImpl {
	
	// Indicamos que sorAlgorithm es una dependendia
	@Autowired // ==> Incluye setter injection
	private SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int [] numbers, int numberToSearch) {
	
		// Implementing Sorting Logic
		// Bubble Sort Algorithm
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		// Search the array
	
		// Return
		return 3;
	}

}

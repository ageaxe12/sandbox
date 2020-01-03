package com.algo.sorting.impl;

import com.algo.sorting.SortArray;

public class SelectionSort implements SortArray {

	
	
	public void swap(Integer [] array,Integer firstIndex, Integer secondIndex) {
		Integer temp = array[firstIndex];
	    array[firstIndex] = array[secondIndex];
	    array[secondIndex] = temp;
	}
	
	
	public Integer indexOfMinimum(Integer [] array, Integer startIndex) {

		Integer minValue = array[startIndex];
		Integer minIndex = startIndex;

	    for(Integer i = minIndex + 1; i < array.length; i++) {
	        if(array[i] < minValue) {
	            minIndex = i;
	            minValue = array[i];
	        }
	    } 
	    return minIndex;
	}; 

	@Override
	public void sort(Integer[] numbers) {
		for (int i = 0; i < numbers.length-1; i++) {
			Integer minIndex = this.indexOfMinimum(numbers, i);
			swap(numbers, i, minIndex);
		}
	}
}

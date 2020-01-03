package com.algo.sorting.impl;

import com.algo.sorting.SortArray;

public class InsertionSort implements SortArray {

	private void insert(Integer[] numbers, Integer sortedIndex, Integer insertValue) {
		int insertIndex = sortedIndex;
		for (; insertIndex >= 0 && numbers[insertIndex] > insertValue; insertIndex--) {
			numbers[insertIndex + 1] = numbers[insertIndex];
		}
		numbers[insertIndex + 1] = insertValue;

	}

	@Override
	public void sort(Integer[] numbers) {
		// index 0 is always sorted

		// Start from index 1
		for (int i = 1; i < numbers.length; i++) {
			this.insert(numbers, i - 1, numbers[i]);
		}
	}

}

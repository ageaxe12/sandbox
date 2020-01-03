package com.algo.sorting.impl;

import com.algo.sorting.SortArray;
import com.common.ArrayUtil;

public class MergSort implements SortArray {

	@Override
	public void sort(Integer[] numbers) {

		Integer[] mergedNumbers = this.mergSort(numbers, 0, (numbers.length - 1));
		ArrayUtil.copy(mergedNumbers, numbers);
	}

	public Integer[] mergSort(Integer[] numbers, int leftIndex, int rightIndex) {

		Integer[] rightNumbers, leftNumbers = null;

		if (leftIndex == rightIndex) {
			Integer lastElement = numbers[rightIndex];
			return new Integer[] { lastElement };
		} else {
			int middle = (leftIndex + rightIndex) / 2;

			leftNumbers = this.mergSort(numbers, leftIndex, middle);

			rightNumbers = this.mergSort(numbers, middle + 1, rightIndex);

			return this.merg(leftNumbers, rightNumbers);

		}
	}

	private Integer[] merg(Integer[] leftNumbers, Integer[] rightNumbers) {

		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int mergIndex = 0;

		int arraySize = leftNumbers.length + rightNumbers.length;

		Integer[] numbers = new Integer[arraySize];

		// TODO condition
		while (mergIndex < arraySize) {
			if (leftArrayIndex != leftNumbers.length  && rightArrayIndex != rightNumbers.length &&
					leftNumbers[leftArrayIndex] < rightNumbers[rightArrayIndex]) {
				numbers[mergIndex] = leftNumbers[leftArrayIndex];
				leftArrayIndex++;
				mergIndex++;
			}else if (leftArrayIndex == leftNumbers.length  && rightArrayIndex != rightNumbers.length  ){
				numbers[mergIndex] = rightNumbers[rightArrayIndex];
				rightArrayIndex++;
				mergIndex++;
				
			}else if (leftArrayIndex != leftNumbers.length  && rightArrayIndex == rightNumbers.length  ){
				numbers[mergIndex] = leftNumbers[leftArrayIndex];
				leftArrayIndex++;
				mergIndex++;
			}else{
				numbers[mergIndex] = rightNumbers[rightArrayIndex];
				rightArrayIndex++;
				mergIndex++;
			}
		}

		return numbers;
	}

}

package com.algo.sorting;

import static com.common.ArrayUtil.print;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;

import com.algo.sorting.impl.InsertionSort;

public class TestSorting {

	public static void main(String[] args) {

		Integer[] randomSortedArray = {  12,67,2, 4, 56, 6, 99, 34,  100 , 78, 23 };

		Integer[] forwardSortedArray = { 2, 4, 6, 12, 23, 34, 56, 67, 78, 99, 100 };

		Integer[] backawardSortedArray = { 2, 4, 6, 12, 23, 34, 56, 67, 78, 99, 100 };
		
		Arrays.sort(backawardSortedArray,Collections.reverseOrder());

		Integer[] bothwaySortedArray = { 2, 4, 6, 12, 23, 34, 100, 99, 78, 67, 56 };

		SortArray sortingAlgo = new InsertionSort();

		//SortArray sortingAlgo = new SelectionSort();

		System.out.println("Array before sorting ...");
		print(randomSortedArray);

		Integer[] expectedArray = randomSortedArray.clone();
		Arrays.sort(expectedArray);
		System.out.println("Array sorted with OOTB API");
		print(expectedArray);

		// Sort using custom API
		System.out.println("Sorted array  ...");
		
		sortingAlgo.sort(randomSortedArray);
		print(randomSortedArray);
		assertArrayEquals(randomSortedArray, expectedArray);

		sortingAlgo.sort(forwardSortedArray);
		print(forwardSortedArray);
		assertArrayEquals(forwardSortedArray, expectedArray);

		sortingAlgo.sort(backawardSortedArray);
		print(backawardSortedArray);
		assertArrayEquals(backawardSortedArray, expectedArray);

		sortingAlgo.sort(bothwaySortedArray);
		print(bothwaySortedArray);
		assertArrayEquals(bothwaySortedArray, expectedArray);

	}

}

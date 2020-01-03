package com.algo.sorting;
import static com.common.ArrayUtil.print;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import com.algo.sorting.impl.InsertionSort;

public class SortArrayTest  {

	// Declare test Array

	Integer[] randomSortedArray = { 12, 67, 2, 4, 56, 6, 99, 34, 100, 78, 23 };

	Integer[] forwardSortedArray = { 2, 4, 6, 12, 23, 34, 56, 67, 78, 99, 100 };

	Integer[] backawardSortedArray = { 2, 4, 6, 12, 23, 34, 56, 67, 78, 99, 100 };

	Integer[] bothwaySortedArray = { 2, 4, 6, 12, 23, 34, 100, 99, 78, 67, 56 };

	SortArray sortingAlgo;

	Integer[] expectedArray;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public SortArrayTest() {


		sortingAlgo = new InsertionSort();
		//System.out.println("Array before sorting ...");
		//print(randomSortedArray);

		expectedArray = randomSortedArray.clone();
		Arrays.sort(expectedArray);
		//System.out.println("Array sorted with OOTB API");
		//print(expectedArray);

		Arrays.sort(backawardSortedArray, Collections.reverseOrder());
	}
	
	
	

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testRandomSortedArray() {

		sortingAlgo.sort(randomSortedArray);
		//print(randomSortedArray);
		assertArrayEquals(randomSortedArray, expectedArray);

	}

	@Test
	public void testForwardSortedArray() {
		sortingAlgo.sort(forwardSortedArray);
		//print(forwardSortedArray);
		assertArrayEquals(forwardSortedArray, expectedArray);

	}

	@Test
	public void testBackwardSortedArray() {
		sortingAlgo.sort(backawardSortedArray);
		//print(backawardSortedArray);
		assertArrayEquals(backawardSortedArray, expectedArray);

	}
	@Test
	public void testBothwaySortedArray() {
		sortingAlgo.sort(bothwaySortedArray);
		//print(bothwaySortedArray);
		assertArrayEquals(bothwaySortedArray, expectedArray);
	}

}

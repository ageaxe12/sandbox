package com.common;

import java.util.Stack;

public class ArrayUtil {

	public static void print(Integer[] numbers) {
		System.out.print("[ ");
		for (Integer i : numbers)
			System.out.print(i + " ");
		System.out.println("]");
		
	}
	
	public static void print(Stack<Integer> numbers) {
		System.out.print("[");
		for (Integer i : numbers)
			System.out.print(i + " ");
		System.out.println("]");
		
	}

	public static void copy(Integer[] source, Integer[] target) {
		for (int i = 0 ; i < source.length ; i ++){
			target[i] = source[i];
		}			
	}

}

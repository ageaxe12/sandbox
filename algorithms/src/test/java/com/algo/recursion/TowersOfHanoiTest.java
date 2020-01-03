package com.algo.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import com.common.ArrayUtil;

public class TowersOfHanoiTest {

	private Stack<Integer> sourceStack = new Stack<Integer>();
	private Stack<Integer> stagingStack = new Stack<Integer>();
	private Stack<Integer> targetStack = new Stack<Integer>();

	// Stack to make sure all the data is moved
	Stack<Integer> compareStack = new Stack<Integer>();

	private TowersOfHanoi hanoi = new TowersOfHanoi();

	final int STACK_SIZE = 64;

	public TowersOfHanoiTest() {
		for (int i = STACK_SIZE; i > 0; i--) {
			sourceStack.add(i);
			compareStack.add(i);
		}
	}

	@Test
	public void test() {

		hanoi.moveAll(sourceStack, targetStack, stagingStack);
		
		assertEquals(0, sourceStack.size());
		assertEquals(0, stagingStack.size());
		assertEquals(compareStack,targetStack);
		
		System.out.println("Printing source stack");
		ArrayUtil.print(compareStack);

		System.out.println("Printing target stack");
		ArrayUtil.print(targetStack);

	}

}

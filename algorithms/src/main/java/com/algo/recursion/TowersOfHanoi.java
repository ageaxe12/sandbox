package com.algo.recursion;

import java.util.Stack;

public class TowersOfHanoi {

	public void moveAll(Stack<Integer> sourceStack, Stack<Integer> targetStack, Stack<Integer> stagingStack) {
		this.move(sourceStack, targetStack, stagingStack, sourceStack.size());
	}

	public void move(Stack<Integer> sourceStack, Stack<Integer> targetStack, Stack<Integer> stagingStack, int size) {
		if(size ==1) {
			this.moveOne(sourceStack, targetStack);
		}else{
			this.move(sourceStack, stagingStack,targetStack,  size-1);
			this.moveOne(sourceStack, targetStack);
			this.move(stagingStack, targetStack,sourceStack,  size-1);
		}
		
	}

	private void moveOne(Stack<Integer> sourceStack, Stack<Integer> targetStack) {
		targetStack.push(sourceStack.pop());
	}
}

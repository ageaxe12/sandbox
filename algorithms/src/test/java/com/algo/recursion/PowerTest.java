package com.algo.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTest {

	Power pow = new Power();
	
	@Test
	public void testNegativeExpSuccess() {
		assertEquals(Math.pow(2, -2),pow.pow(2,-2),0);
	}

	@Test
	public void testEvenExpSuccess() {
		assertEquals(Math.pow(3, 2),pow.pow(3,2),0);
	}

	@Test
	public void testOddExpSuccess() {
		assertEquals(Math.pow(3,3),pow.pow(3,3),0);
	}

	@Test
	public void testLongExpSuccess() {
		assertEquals(Math.pow(3,30),pow.pow(3,30),0);
	}


	@Test
	public void testLongExpSuccess2() {
		assertEquals(Math.pow(9999,9999),pow.pow(9999,9999),0);
	}

	
	/*
	 * @Test public void testFailure() { assertNotEquals(Math.pow(3,
	 * 3),pow.pow(3,3)); }
	 */


}

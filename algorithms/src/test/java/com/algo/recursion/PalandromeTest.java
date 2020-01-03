package com.algo.recursion;
import static org.junit.Assert.*;

import org.junit.Test;

public class PalandromeTest {

	final Palandrome pal = new Palandrome();
	
	@Test
	public void testFailure() {
		char [] nopalString = "estme".toCharArray();
		assertEquals("String mis-matched as expected",false, pal.isPalandrome(nopalString,0,nopalString.length-1));
		
	}

	@Test
	public void testSuccess() {
		char [] nopalString = "adonnoda".toCharArray();
		assertEquals("String matched as expected",true, pal.isPalandrome(nopalString,0,nopalString.length-1));
		
	}

	
	@Test
	public void testSuccess2() {
		char [] nopalString = "adonoda".toCharArray();
		assertEquals("String matched as expected",true, pal.isPalandrome(nopalString,0,nopalString.length-1));
		
	}
}

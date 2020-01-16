package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LetterTilePossibilitiesTest {

	
	private LetterTilePossibilities testObject = new LetterTilePossibilities();

	@Test
	public void twoCharRepeatTest() {
		
		int result = testObject.numTilePossibilities("AB");
		assertEquals(4, result);
	}

	
	@Test
	public void thresCharRepeatTest() {
		
		int result = testObject.numTilePossibilities("AAB");
		assertEquals(8, result);
	}

	@Test
	public void sixCharRepeatTest() {
	int result = testObject.numTilePossibilities("AAABBC");
		assertEquals(188, result);
	}

}

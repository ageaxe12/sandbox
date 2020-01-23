package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RevealCardsInIncreasingOrderTest {

	
	private RevealCardsInIncreasingOrder testObject = new RevealCardsInIncreasingOrder();

	@Test
	public void test() {
		
		int[] myIntArray = {17,13,11,2,3,5,7};
		this.testObject.deckRevealedIncreasing(myIntArray);
	}

}

package leetcode;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * 
 * @author amitb
 *
 */
public class RevealCardsInIncreasingOrder {
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		int[] result = new int[deck.length];
		for (int i = deck.length - 1; i >= 0; i--) {
			int num = deck[i];
			if (i == deck.length - 1  ) {
				result[0] = num;
			} else {
				this.pushPopAdd(result, num,deck.length - i -2 );
			}
		}

		System.out.println(
				MessageFormat.format("Sorted Array = {0} \nResult Array = {1}", Arrays.toString(deck), Arrays.toString(result)));
		return result;
	}

	private void pushPopAdd(int[] result, int num,int lastResultIndex) {

		// POP-->I

		int popped = result[lastResultIndex];;
		
		//move all by 2
		for (int j = lastResultIndex-1; j >= 0; j--) {
			result[j+2] = result[j]; 
		}
		result[1] = popped;
		
		result[0] = num;

	}


}

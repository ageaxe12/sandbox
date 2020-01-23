package leetcode;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * 
 * @author amitb
 *
 */
public class RevealCardsInIncreasingOrder {
	public Object[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		

		Queue<Integer> result = new ArrayBlockingQueue<Integer>(deck.length);
		// List<Integer> listNum = new ArrayList<Integer>(deck.length);

		for (int i =  deck.length-1 ;i >=0;i--) {
			int num = deck[i];
			if (result.isEmpty()) {
				result.add(num);
			}else {
				this.pushPop(result);
				result.add(num);
			}

		}

		System.out.println(MessageFormat.format("Sorted Array = {0} \n Result Array = {1}", Arrays.toString(deck),result));
		return result.toArray();
	}

	private void pushPop(Queue<Integer> result) {
		Integer last = result.poll();
		result.add(last);
	}

}

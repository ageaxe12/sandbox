package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets
 * 
 * @author amitb
 *
 */
public class ThreeSum {
	public List<List<Integer>> worstCase(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {

					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> tuple = Arrays.asList(nums[i] , nums[j] , nums[k] );
						if(!ifTupleExists(result,tuple)) {
							result.add(tuple);
						}
					}
				}

			}
			return result;
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	
	private boolean ifTupleExists(List<List<Integer>> result,List<Integer> tuple) {
		for (List<Integer>  resultTuple: result) {
			return resultTuple.containsAll(tuple);
		}
		return false;
	}
}

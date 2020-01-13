package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	public List<List<Integer>> approch1(int[] nums) {
		// Time complexity o(n^3) and space complexity o(1)
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> tuple = Arrays.asList(nums[i], nums[j], nums[k]);
						if (!ifTupleExists(result, tuple)) {
							result.add(tuple);
						}
					}
				}
			}
		}

		return result;
	}

	public List<List<Integer>> approch2(int[] nums) {
		// Time complexity o(n^2) and space complexity o(n^2)
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Map<Integer, List<List<Integer>>> deficitMap = new HashMap<Integer, List<List<Integer>>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				Integer deficit = 0 - (nums[i] + nums[j]);
				if (deficitMap.containsKey(deficit)) {
					List<List<Integer>> list = deficitMap.get(deficit);
					list.add(Arrays.asList(i, j));
				} else {
					List<List<Integer>> list = new ArrayList<List<Integer>>();
					list.add(Arrays.asList(i, j));
					deficitMap.put(deficit, list);
				}

			}
		}

		for (int i = 0; i < nums.length; i++) {

			if (deficitMap.containsKey(nums[i])) {
				List<List<Integer>> indexes = deficitMap.get(nums[i]);
				for (List<Integer> deficitIndexList : indexes) {
					if (!deficitIndexList.contains(i)) {
						List<Integer> tuple = Arrays.asList(nums[deficitIndexList.get(0)],
								nums[deficitIndexList.get(1)], nums[i]);
						if (!this.ifTupleExists(result, tuple))

							result.add(tuple);
					}
				}
			}
		}

		return result;
	}

	public List<List<Integer>> approch4(int[] nums) {
		// Time complexity o(n^2) and space complexity o(n^2)
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<List<Integer>> additionMap = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				additionMap.add(Arrays.asList(i,j));
			}
		}

		for (int i = 2; i < nums.length; i++) {
			for(List<Integer> addList : additionMap) {
				if (addList.get(0)+addList.get(1)+nums[i] ==0 && !addList.contains(i) ) {
					List<Integer> tuple = Arrays.asList(addList.get(0),addList.get(1),nums[i]);
					if (!this.ifTupleExists(result, tuple))
						result.add(tuple);
				}
			}
		}

		return result;
	}

	public List<List<Integer>> approch3(Integer[] nums) {
		// Time complexity o(n^2) and space complexity o(n^2)
		// Check if result can be added without duplicate check
		// This Solution Selects number only once
		// TODO Correct the solution 
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Stack<Integer> discardStack = new Stack<Integer>();

		Stack<Integer> processStack = new Stack<Integer>();
		processStack.addAll(Arrays.asList(nums));

		Stack<Integer> tempProcessStack = new Stack<Integer>();

		Integer first, second, third = null;
		while (processStack.size() >= 3) {
			first = processStack.pop();
			second = processStack.pop();
			while (!processStack.empty()) {
				third = processStack.pop();
				if (first + second + third == 0) {
					result.add(Arrays.asList(first, second, third));
					discardStack.push(third);
					break;
				} else {
					tempProcessStack.push(third);
				}
			}

			processStack.addAll(tempProcessStack);
			tempProcessStack.clear();
		}
		return result;

	}

	private boolean ifTupleExists(List<List<Integer>> result, List<Integer> tuple) {

		for (List<Integer> resultTuple : result) {

			List<Integer> clonedResultTuple = new ArrayList<>(resultTuple);
			List<Integer> clonedTuple = new ArrayList<>(tuple);
			clonedResultTuple.removeAll(tuple);

			clonedTuple.removeAll(resultTuple);

			if (clonedResultTuple.size() == 0 && clonedTuple.size() == 0)
				return true;
		}
		return false;
	}
}

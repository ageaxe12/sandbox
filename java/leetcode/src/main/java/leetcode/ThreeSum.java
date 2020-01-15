package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	public List<List<Integer>> threeLoops(int[] nums) {
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

	public List<List<Integer>> twoLoops(int[] nums) {
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

	public List<List<Integer>> sortedArray(int[] inputArr) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(inputArr);

		int lastIndex = -99;

		for (int index = 0; index < inputArr.length; index++) {
			int topIndex = index + 1;
			int lowIndex = inputArr.length - 1;
			if (lastIndex > -99 && inputArr[lastIndex] == inputArr[index]) {
				continue;
			}

			boolean upDown = true;
			while (topIndex < lowIndex) {
				if (inputArr[index] + inputArr[topIndex] + inputArr[lowIndex] == 0) {
					result.add(Arrays.asList(inputArr[index], inputArr[topIndex], inputArr[lowIndex]));
					while (topIndex < lowIndex && inputArr[topIndex] == inputArr[topIndex + 1])
						topIndex++;
					topIndex++;

					while (topIndex < lowIndex && inputArr[lowIndex] == inputArr[lowIndex - 1])
						lowIndex--;
					lowIndex--;
					continue;
				}
				if (Math.abs(inputArr[index] + (inputArr[topIndex + 1] + inputArr[lowIndex])) == Math
						.abs(inputArr[index] + (inputArr[topIndex] + inputArr[lowIndex - 1]))) {
					if (inputArr[index] < 0) {
						topIndex++;
					} else {
						lowIndex--;
					}
				} else if (Math.abs(inputArr[index] + (inputArr[topIndex + 1] + inputArr[lowIndex])) < Math
						.abs(inputArr[index] + (inputArr[topIndex] + inputArr[lowIndex - 1]))) {
					topIndex++;
				} else {
					lowIndex--;
				}
			}
			lastIndex = index;
		}

		return result;
	}

	public List<List<Integer>> sortedArray2(int[] inputArr) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(inputArr);

		int lastIndex = -99;

		for (int select = 0; select < inputArr.length - 2; select++) {
			int frontIndex = select + 1;
			int rearIndex = inputArr.length - 1;
			if (lastIndex > -99 && inputArr[lastIndex] == inputArr[select]) {
				continue;
			}

			while (frontIndex < rearIndex) {
				if (inputArr[select] + inputArr[frontIndex] + inputArr[rearIndex] == 0) {
					result.add(Arrays.asList(inputArr[select], inputArr[frontIndex], inputArr[rearIndex]));
					while (frontIndex < rearIndex && inputArr[frontIndex] == inputArr[frontIndex + 1])
						frontIndex++;
					frontIndex++;

					while (frontIndex < rearIndex && inputArr[rearIndex] == inputArr[rearIndex - 1])
						rearIndex--;
					rearIndex--;
					continue;
				}

				if ((0-( inputArr[select] + inputArr[frontIndex] )) < inputArr[rearIndex]) {
					rearIndex--;
				} else {
					frontIndex++;

				}
			}
			lastIndex = select;
		}

		return result;
	}

	/**
	 * Use Stack to store nums In each loop we fix top two as first 2 numbers from 3
	 * to n check if it matches If march add to solution No Match add to discard
	 * stack
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> stackApproch(Integer[] nums) {
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
	
	public List<List<Integer>> programcreek(int[] nums) {
	    Arrays.sort(nums);
	 
	    ArrayList<List<Integer>> result = new ArrayList<>();
	 
	    for (int i = 0; i < nums.length; i++) {
	        int j = i + 1;
	        int k = nums.length - 1;
	 
	        if (i > 0 && nums[i] == nums[i - 1]) {
	            continue;
	        }
	 
	        while (j < k) {
	            if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
	                k--;
	                continue;
	            }
	 
	            if (nums[i] + nums[j] + nums[k] > 0) {
	                k--;
	            } else if (nums[i] + nums[j] + nums[k] < 0) {
	                j++;
	            } else {
	                ArrayList<Integer> l = new ArrayList<>();
	                l.add(nums[i]);
	                l.add(nums[j]);
	                l.add(nums[k]);
	                result.add(l);
	                j++;
	                k--;
	            }
	        }
	    }
	 
	    return result;
	}
}

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
public class ThreeSumClosest {


	public int threeLoops2(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int closest = 0;
		for (int i =0 ;i < nums.length;i++) {
			int low = i + 1;
			int high = nums.length - 1;
			while (high > low) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum == target) {
					return sum;
				}
				if (diff > this.getDifference(target,nums[i]+nums[low]+nums[high])) {
					diff = this.getDifference(target,nums[i]+nums[low]+nums[high]);
					closest = sum;
				}
				if (sum < target) {
					low++;
				} else {
					high--;
				}

			}
		}
		return closest;
	}
	public int threeLoops(int[] nums, int target) {
		int closest = 0;
		int difference = Integer.MAX_VALUE;


		for (int i =0 ;i < nums.length;i++){
			for (int j =i+1 ;j< nums.length;j++){
				for (int k =j+1 ;k < nums.length;k++){
					if (difference > getDifference(target,nums[i]+nums[j]+nums[k])){
						closest = nums[i]+nums[j]+nums[k];
						difference = getDifference(target,nums[i]+nums[j]+nums[k]);
					}
				}
			}
		}
		return closest;
	}

	private int getDifference(int firstNum , int secondNum){
		if (firstNum > secondNum){
			return firstNum - secondNum;
		}else {
			return secondNum - firstNum;
		}
	}

	public static void main(String [] s){
		System.out.println(new ThreeSumClosest().threeLoops2(new int[]{-1, 2, 1, -4},1));
	}
}

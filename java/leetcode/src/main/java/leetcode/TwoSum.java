package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSumV2(int[] nums, int target) {
		Map<Integer , Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int deficit = target - nums[i];
			
			if (deficit > 0 && map.containsKey(deficit) && i != map.get(deficit)) {
				return new int[] { i, map.get(deficit) };
				
			}
			
		}

		throw new IllegalArgumentException("No two sum solution");
	}


	public int[] twoSumV3(int[] nums, int target) {
		Map<Integer , Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int deficit = target - nums[i];
			if (map.containsKey(nums[i]) ) {
				return new int[] { map.get(nums[i]),i  };
			}
			map.put(deficit, i);
			
		}

		throw new IllegalArgumentException("No two sum solution");
	}

}

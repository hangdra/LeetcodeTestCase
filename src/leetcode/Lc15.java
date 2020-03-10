package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc15 {
	/*
	 * Given an array nums of n integers, are there elements a, b, c in nums
	 * such that a + b + c = 0? Find all unique triplets in the array which
	 * gives the sum of zero.
	 * 
	 * Note:
	 * 
	 * The solution set must not contain duplicate triplets.
	 * 
	 * Example:
	 * 
	 * Given array nums = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 */
	
	
	//time cost   O(N^3)
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if ((nums[i] + nums[j] + nums[k]) == 0) {
						List<Integer> inli = new ArrayList<Integer>();
						inli.add(nums[i]);
						inli.add(nums[j]);
						inli.add(nums[k]);
						li.add(inli);
					}
				}

			}

		}
		return li;
	}

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

}

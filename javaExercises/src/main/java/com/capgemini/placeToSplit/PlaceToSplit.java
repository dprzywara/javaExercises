package com.capgemini.placeToSplit;

/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers
 * on the other side. Example: {{{ canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true }}}
 */

public final class PlaceToSplit {
	private PlaceToSplit() {
	}

	public static boolean canBalance(int[] nums) {
		
		int leftsum = 0;
		int totalSum = 0;
		int halfOfSum=0;
	
		totalSum = counTotalSumOfArray(nums);
		if (totalSum % 2 != 0) {
			return false;
		}
		halfOfSum=totalSum/2;
		for (int i = 0; i < nums.length - 1; i++) {
				leftsum += nums[i];
				if(leftsum==halfOfSum){
					return true;
				}
		}
		return false;
	}

	private static int counTotalSumOfArray(int[] nums) {
		int sum = 0;
		for (int j = 0; j < nums.length; j++)
			sum += nums[j];
		return sum;
	}
	
	
	
	/*
	 * I sposob
	 * 
	 * for(int iter=1; iter<nums.length;iter++){ 
	 * leftsum=0; rightsum=0;
	 * for(int j=0; j<nums.length;j++){ 
	 * if(j<iter) leftsum+=nums[j]; 
	 * else
	 * rightsum+=nums[j]; } //System.out.println("lewy: "+leftsum+"prawy "
	 * +rightsum); if (leftsum==rightsum) return true;
	 */

}

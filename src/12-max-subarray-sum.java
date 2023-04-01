// https://leetcode.com/problems/maximum-subarray
// Maximum sub-array sum using Kadane's algorithm.

/**
 * Initialize max to minimum value. 
 * Iterate through the array, add the ith element to sum.
 * Assign max to max(sum,max)
 * If sum is less than zero, assign zero. 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum < 0) sum =0;
        }
        return max;
    }
}
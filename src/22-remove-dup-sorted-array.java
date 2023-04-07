// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

/**
 * Given an integer array nums sorted in non-decreasing order, 
 * remove the duplicates in-place such that each unique element 
 * appears only once. 
 * The relative order of the elements should be kept the same. 
 * Then return the number of unique elements in nums.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int newIndex = 1; //Because it is already sorted.
        for (int i = 0; i < nums.length - 1; i++) {
            // Only if the current element and next element are not same.
            if(nums[i] < nums[i + 1]){ 
                nums[newIndex] = nums[i+1];
                newIndex ++;
            }
        }
        return newIndex; // It will be pointing at the last index.
    }
}
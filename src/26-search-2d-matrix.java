// https://leetcode.com/problems/search-a-2d-matrix/
// Search a 2D Matrix
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.


// TC - O(log(m * n)), SC = O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
		int end = (matrix.length * matrix[0].length) - 1;
		while(end >= start){
			int mid = start + (end - start) / 2;
			if(matrix[mid/matrix[0].length][mid % matrix[0].length] == target) return true;
			else if(matrix[mid/matrix[0].length][mid % matrix[0].length] > target) end = mid - 1;
			else start = mid + 1;
		}
		return false;
    }
}
// https://leetcode.com/problems/set-matrix-zeroes/
class Solution {
    public void setZeroes(int[][] matrix) {
        int col = 1;

        // To mark the 0th arrays indicated the 0s.
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0) col = 0;
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0; 
                }
            }
        }

        // Traverse from back of the matrix,
        // Compare with the 0th arrays,
        // If col or row 0th array is 0, 
        // Then the element will be marked as zero.

        for(int i = matrix.length - 1; i >= 0; i --){
            for(int j = matrix[i].length - 1 ; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col == 0) matrix[i][0] = 0;
        }
    }
}
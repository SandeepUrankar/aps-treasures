// https://leetcode.com/problems/rotate-image/
/**
 * To Rotate the matrix, there are 2 steps to be followed -
 * Step 1 - Find Transpose of the Matrix.
 * Step 2 - Reverse every row in the Matrix.
 */
class Solution {
    public void rotate(int[][] matrix) {

        // Step 1 - Find Transpose of the Matrix.
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2 - Reverse every row in the Matrix.
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length / 2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }

    }
}
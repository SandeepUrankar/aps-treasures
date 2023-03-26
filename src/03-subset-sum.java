import java.util.Arrays;

class SubsetSum {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 7 };
        int sum = 9;
        System.out.println(subsetSum(nums, sum));
    }

    /**
     * Method to find whether the array contains a subset whose
     * sum is equal to the value given.
     * 
     * @param nums integer array containing the numbers
     * @param sum  the sum
     * @return 1 if sum is found; 0 otherwise.
     */
    static int subsetSum(int[] nums, int sum) {
        // Create a 2-D array
        int[][] SS = new int[nums.length + 1][sum + 1];
        Arrays.fill(SS[0], 0);
        for (int i = 0; i < SS.length; i++) {
            SS[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (SS[i - 1][j] == 1) {
                    SS[i][j] = 1;
                }else{
                    if (nums[i - 1] > j) {
                        SS[i][j] = 0;
                    } else {
                        SS[i][j] = SS[i - 1][j - nums[i - 1]];
                    }
                }
            }
        }
        for (int i = 0; i < SS.length; i++) {
            System.out.println(Arrays.toString(SS[i]));
        }
        // System.out.println(SS[0][0]);
        return SS[nums.length][sum];
    }
}
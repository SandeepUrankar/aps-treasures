import java.util.Arrays;
import java.util.Scanner;

class MinimizingCoins{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), sum = in.nextInt();
        long nums[] = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextLong();
        }
        System.out.println(getMinimum(nums, sum));
        in.close();
    }

    static private long getMinimum(long[]  nums, int sum){
        long[] dp = new long[sum + 1];
        Arrays.fill(dp, Long.MAX_VALUE - 1);
        dp[0] = 0;

        for(int i = 1; i<= sum; i++){
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - (int)nums[j]] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        if(dp[sum] == Long.MAX_VALUE - 1){
            return - 1;
        }
        return dp[sum];
    }
}
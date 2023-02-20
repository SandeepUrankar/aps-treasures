import java.util.Arrays;

class Assigment {
    public static void main(String[] args) {
        int[][] jobs = {{3,2,7},{5,1,3},{2,7,2}};
        // To find out the running time.
        long start = System.nanoTime();
        System.out.println(optimizeJobs(jobs, jobs.length));
        long end = System.nanoTime();
        long exec = end - start;
        double inSeconds = (double)exec / 1_000_000_000.0;
        System.out.println("The method takes "+exec+" nanoseconds that is "+inSeconds+" seconds to execute.");
    }

    /**
     * Method to optimize the job.
     * @param jobs 2-D array containing the cost of jobs.
     * @param n number of jobs/people.
     * @return total cost.
     */ 
    static int optimizeJobs(int[][] jobs, int n){
        // Create a dp array of size 2^n and initialize
        // the array with infinity(MAX_VALUE).
        int dp[] = new int[(int) Math.pow(2, n)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Assign 0 to 0th index of dp array.
        dp[0] = 0;
        // Loop through 0 to 2^n
        for (int mask = 0; mask < Math.pow(2, n); mask++) {
            // Count the number of bits set in the mask ana assign it to x.
            int x = countBits(mask);
            // Run a loop from 0 to n.
            for (int j = 0; j < n; j++) {
                // If jth bit is not set then perform the action
                if ((mask & 1 << j) == 0) {
                    // Assign the minimum value of dp[mask | 1 << j] and dp[mask] + jobs[x][j] to dp[mask | 1<<j]  
                    dp[mask | 1<<j] = Math.min(dp[mask | 1 << j], dp[mask] + jobs[x][j]);
                    // System.out.println(Arrays.toString(dp));
                }
            }
        }
        // The value at the last index is the optimized value. 
        // Return it as ans.
        return dp[(int) Math.pow(2, n) - 1];
    }

    /**
     * Method to calculate the number of set bits.
     * @param n number
     * @return count of bits in n
     */ 
    static int countBits(int n) {
        // Initialising a variable count to 0.
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

// Sample Output -
// --------------------
// 6
// The method takes 6178400 nanoseconds that is 0.0061784 seconds to execute.
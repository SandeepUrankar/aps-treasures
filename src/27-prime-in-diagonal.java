import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/contest/weekly-contest-340/problems/prime-in-diagonal/
// You are given a 0-indexed two-dimensional integer array nums.

// Return the largest prime number that lies on at least one of the diagonals of nums. In case, no prime is present on any of the diagonals, return 0.
class Solution {
    public int diagonalPrime(int[][] nums) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i == j) {
                    if(isPrime(nums[i][j]))
                        primes.add(nums[i][j]);
                }
            }
        }
        
         for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
 
                if ((i + j) == (nums.length - 1)) {
                   if(isPrime(nums[i][j]))
                        primes.add(nums[i][j]);
                }
            }
        }
        if(primes.size() == 0) return 0;
        Collections.sort(primes);
        return primes.get(primes.size() - 1);
    }
    
    public boolean isPrime(int n)
	{
		if(n==1)
			return false;

		for(int i=2; i*i<=n; i++)
		{
			if(n % i == 0)
				return false; 
		}

		return true;
	}
}
// https://leetcode.com/problems/next-permutation/
// Next permutation of a given number array lexicographically.

/**
 * Generating next permutation contains of 4 steps -
 * Step 1 - Iterate from the last of the array, get index of first
 *          occcurence of element whose previous element is greater.
 *          Mark that index as "first".
 * Step 2 - From the "first" index find the smallest-largest character.
 *          Mark it's index as "second".
 * Step 3 - Swap the "first" and "second".
 * Step 4 - Sort the element in the array from the "first" + 1 index.
 */

import java.util.Arrays;
class Solution 
{
	public static int[] nextPermutation(int[] permutation) 
	{
		int first = getLargestIndex(permutation);
		if(first == -1){
			Arrays.sort(permutation);
			return permutation;
		}
		// System.out.println("Chosen first is = "+permutation.get(first));
		int second = getSmallestLargest(permutation, first);
		// System.out.println("Chosen second is = "+permutation.get(second));
		swap(permutation, first,second);
		Arrays.sort(permutation, first+1, permutation.length);
		return permutation;
	}

	public static void swap(int[] permutation, int a, int b){
		int temp = permutation[a];
		permutation[a] = permutation[b];
		permutation[b] = temp;
	}

	public static int getLargestIndex(int[] permutation){
		for(int i = permutation.length -1 ; i>0 ; i--){
			if (permutation[i] > permutation[i-1]){
				return i -1;
			}
		}
		return -1;
	}

	public static int getSmallestLargest(int[] permutation, int first){
		int smallestLargest = Integer.MAX_VALUE, index = 0;
		for(int i = first + 1; i < permutation.length; i++){
			if(permutation[i] < smallestLargest && permutation[i] > permutation[first]){
				smallestLargest = permutation[i];
				index = i;
			}
		}
		return index;
	}

}

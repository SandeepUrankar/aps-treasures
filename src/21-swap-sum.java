// Problem Statement
// You are given two arrays, 'A' and 'B' of length 'N'. 
// In one operation, You can swap 'A[i]' and 'B[i]'.
// Return the maximum sum of 'A' after performing at most 'K' operations.

// Let 'N' = 5, 'K' = 2, 'A' = [1, 5, 2, 4, 4], 'B' = [2, 4, 1, 6, 2].
// We can perform the operations at indexes 1 and 4 (1-based indexing).
// 'A' becomes [2, 5, 2, 6, 4].
// So our answer is 19.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class ValueComparator implements Comparator<Integer>{ 
    int a[] = null;
    int b[] = null;
    ValueComparator(int a[], int b[]){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compare(Integer i, Integer j) {
        if(b[i] - a[i] > b[j] - a[j]) return -1;
        else if(b[i] - a[i] < b[j] - a[j]) return 1;
        else return 0;
    }
}
class Solution {
    static int swapSum(int k, int []a, int []b) {
        int sum = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            index.add(i);
        }
        Collections.sort(index, new ValueComparator(a,b));
        for(int i: index){
            if(k==0){
             break;
            }    
            else if ((b[i] - a[i]) > 0){
                a[i] =  b[i];
                k --;
            }
        }
        sum = Arrays.stream(a).sum();
        // System.out.println(index);
        return sum;
    }
}
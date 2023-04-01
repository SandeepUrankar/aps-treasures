// https://leetcode.com/problems/sort-colors
// Dutch National Flag Algorithm.
// Sort the array containing 0s 1s and 2s.
class Solution 
{
    public static void sort012(int[] arr)
    {
        int low, mid, high, n = arr.length;
        low = mid = 0;
        high = n - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid ++;
                low ++;
            }else if(arr[mid] == 1){
                mid ++;
            }else if(arr[mid] == 2){
                swap(arr, mid, high);
                high --;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
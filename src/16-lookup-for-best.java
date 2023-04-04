// https://www.hackerrank.com/contests/array-query-2023/challenges/lookup-for-the-best
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        HashMap<Long, Long> bitsSet = new HashMap<>();
        long N = in.nextLong();
        long[] nums = in.readlongarray((int)N);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(bitsSet.containsKey(nums[i])){
                sum += bitsSet.get(nums[i]);
            }else{
                bitsSet.put(nums[i], countBitsSet(nums[i]));
                sum += bitsSet.get(nums[i]);
            }
        }
        System.out.println(sum);
    }
    static long countBitsSet(long num){
        long count = 0;
        while(num > 0){
            num &= num -1 ;
            count ++;
        }
        return count;
    }
}

class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
 
        int [] readintarray(int n) {
            int res [] = new int [n];
            for(int i = 0; i<n; i++)res[i] = nextInt();
            return res;
        }
        long [] readlongarray(int n) {
            long res [] = new long [n];
            for(int i = 0; i<n; i++)res[i] = nextLong();
            return res;
        }
    }




import java.util.Arrays;

// For finding the prime numbers till n.
// TC - O(nloglogn).

class SieveOfErathosthenes {
    public static void main(String[] args) {
        sieve(100);
        sieveMinimalCode(100);
    }

    static void sieve(int n){
        boolean[] isPrime =  new boolean[n+1];
        Arrays.fill(isPrime, true);
        // Run from 2 to i * i <= n.
        for (int i = 2; i * i <= n; i++) {
            if(isPrime[i]){
                // Run from square of i and increment in terms of i.
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(isPrime[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    static void sieveMinimalCode(int n){
        boolean[] isPrime =  new boolean[n+1];
        Arrays.fill(isPrime, true);
        // Run from 2 to n.
        for (int i = 2; i <= n; i++) {
            if(isPrime[i]){
                System.out.print(i+" ");
                // Run from square of i and increment in terms of i.
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        System.out.println();
    }
}

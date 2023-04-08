class PrintDivisor {
    public static void main(String[] args) {
        printDivisor(15);
        printDivisorOrder(15);
    }   

    // Runs till sqrt(n).
    // O(sqrt(n))
    // Doesn't print in order.
    static void printDivisor(int n){
        for (int i = 1; i * i <= n; i++) {
            if(n % i == 0){
                System.out.print(i +" ");
                if( i != n/i){
                System.out.print(n/i+" ");
                }
            }
        } 
        System.out.println();
    }

    // Runs till sqrt(n).
    // O(sqrt(n))
    // Prints in order.
    static void printDivisorOrder(int n){
        int i;
        for (i = 1; i * i <= n; i++) {
            if(n % i == 0){
                System.out.print(i +" ");
            }
        } 

        for (; i >= 1; i--) {
            if(n % i == 0){
                System.out.print(n/i +" ");
            }
        }
        System.out.println();
    }
}

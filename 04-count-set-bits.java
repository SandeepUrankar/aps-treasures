class CountBits {

    public static void main(String[] args) {
        System.out.println(countBits(10));
    }
     /**
     * Method to calculate the number of set bits.
     * Brian Kernighan's Algorithm.
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

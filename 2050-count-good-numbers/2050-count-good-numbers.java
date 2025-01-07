class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int countGoodNumbers(long n) {
        // Calculate number of even and odd positions
        long numEvens = (n + 1) / 2;  // ceiling division for even positions (5 options)
        long numOdds = n / 2;         // floor division for odd positions (4 options)
        
        // Calculate (5^numEvens * 4^numOdds) % MOD using modular exponentiation
        long result = (modPow(5, numEvens) * modPow(4, numOdds)) % MOD;
        return (int)result;
    }
    
    // Recursive function for modular exponentiation
    private long modPow(long base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base % MOD;
        
        long half = modPow(base, exp/2);
        long result = (half * half) % MOD;
        
        // If exp is odd, multiply by one more base
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        
        return result;
    }
}
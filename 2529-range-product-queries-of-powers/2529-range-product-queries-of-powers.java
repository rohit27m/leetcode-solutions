class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1000000007;
        
        // Extract powers of 2
        long[] powers = new long[32];
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                powers[count++] = 1L << i;
            }
        }
        
        // Answer queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = (product * powers[j]) % MOD;
            }
            result[i] = (int) product;
        }
        
        return result;
    }
}
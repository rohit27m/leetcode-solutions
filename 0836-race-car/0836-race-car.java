class Solution {
    private final java.util.Map<Integer, Integer> memo = new java.util.HashMap<>();

    public int racecar(int t) { return dp(t); }

    private int dp(int t) {
        if (t == 0) return 0;
        if (memo.containsKey(t)) return memo.get(t);

        int k = 32 - Integer.numberOfLeadingZeros(t);   // minimal k s.t. (1<<k)-1 >= t
        int full = (1 << k) - 1;
        if (full == t) return memo.put(t, k) == null ? k : k;

        int res = k + 1 + dp(full - t);                 // overshoot, reverse once
        for (int m = 0; m < k - 1; m++) {               // stop early, reverse, back m, reverse
            int remain = t - ((1 << (k - 1)) - (1 << m));
            res = Math.min(res, k + m + 1 + dp(remain));
        }
        memo.put(t, res);
        return res;
    }
}
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skipq = questions[i][1];
            int nxtidx = i + skipq + 1;
            long nxtqpts = (nxtidx < n) ? dp[nxtidx] : 0;
            dp[i] = Math.max(points + nxtqpts, dp[i + 1]);
        }

        return dp[0];
    }
}

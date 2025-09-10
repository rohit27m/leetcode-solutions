class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // If start or end is blocked → no path
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1; // starting point

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If cell has obstacle → no path
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } 
                // Otherwise, add paths from left cell
                else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}

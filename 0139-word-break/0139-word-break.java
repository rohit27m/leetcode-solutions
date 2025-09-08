import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Put dictionary words in a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        // Base case: empty string can always be segmented
        dp[0] = true;
        
        // Iterate over all lengths of substring
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If s[0..j) can be segmented and s[j..i) is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further j's
                }
            }
        }
        
        return dp[n];
    }
}

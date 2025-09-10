class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        // build boolean matrix: knows[userIndex][lang] = true if user knows lang
        boolean[][] knows = new boolean[m][n + 1];
        for (int i = 0; i < m; i++)
            for (int lang : languages[i]) knows[i][lang] = true;

        // mark users that are in a problematic friendship (can't communicate)
        boolean[] bad = new boolean[m];
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            if (!hasCommon(knows[u], knows[v])) { bad[u] = bad[v] = true; }
        }

        int totalBad = 0;
        for (boolean b : bad) if (b) totalBad++;
        if (totalBad == 0) return 0;              // everyone already communicates

        // knownCount[lang] = how many problem-users already know `lang`
        int[] knownCount = new int[n + 1];
        for (int i = 0; i < m; i++) if (bad[i])
            for (int lang = 1; lang <= n; lang++) if (knows[i][lang]) knownCount[lang]++;

        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++)
            ans = Math.min(ans, totalBad - knownCount[lang]); // teach those who don't know it

        return ans;
    }

    // helper: do two users share at least one language?
    private boolean hasCommon(boolean[] a, boolean[] b) {
        for (int i = 1; i < a.length; i++) if (a[i] && b[i]) return true;
        return false;
    }
}

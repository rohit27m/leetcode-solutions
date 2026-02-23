class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k; // total binary codes = 2^k
        boolean[] seen = new boolean[need];
        int count = 0;
        int window = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // shift left and add new bit
            window = ((window << 1) & (need - 1)) | (s.charAt(i) - '0');
            
            // start checking once window size reaches k
            if (i >= k - 1) {
                if (!seen[window]) {
                    seen[window] = true;
                    count++;
                    if (count == need) return true;
                }
            }
        }
        return false;
    }
}
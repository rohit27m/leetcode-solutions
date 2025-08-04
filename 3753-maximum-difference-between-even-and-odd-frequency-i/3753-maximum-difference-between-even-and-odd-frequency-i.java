class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        
        int oddFreq = 0;
        int evenFreq = Integer.MAX_VALUE;
        
        for (int freq : dict.values()) {
            if (freq % 2 == 0) {  // Check if frequency is even
                evenFreq = Math.min(evenFreq, freq);
            } else {  // Frequency is odd
                oddFreq = Math.max(oddFreq, freq);
            }
        }
        
        return oddFreq - evenFreq;
    }
}
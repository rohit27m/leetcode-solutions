class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) currentVowels++;
            
            if (i >= k) {
                if (isVowel(s.charAt(i - k))) currentVowels--;
            }
            
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        
        return maxVowels;
    }
    
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

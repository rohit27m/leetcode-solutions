class Solution {
    public int minimizedStringLength(String s) {
        char[] ch= s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char t : ch){
            set.add(t);
        }
        return set.size();
    }
}
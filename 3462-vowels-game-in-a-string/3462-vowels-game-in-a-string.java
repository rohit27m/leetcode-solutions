class Solution {
    public boolean doesAliceWin(String s) {
        for (char character : s.toCharArray()) {
            if ("aeiou".indexOf(character) >= 0) return true;
        }
        return false;
    }
}

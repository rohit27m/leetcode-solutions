public class Solution {
    
    public List<String> letterCombinations(String digits) {
        // Custom List implementation without imports
        List<String> result = new ArrayList<String>();
        
        // If input is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Mapping of digits to letters (like on telephone buttons)
        String[] mapping = {
            "",     // 0
            "",     // 1 (no letters)
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        backtrack(result, mapping, digits, "", 0);
        return result;
    }
    
    private void backtrack(List<String> result, String[] mapping, 
                          String digits, String current, int index) {
        // Base case: if we've processed all digits
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        // Get the current digit and its corresponding letters
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];
        
        // Try each letter for the current digit
        for (int i = 0; i < letters.length(); i++) {
            backtrack(result, mapping, digits, current + letters.charAt(i), index + 1);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        
        List<String> combinations = solution.letterCombinations(digits);
        
        System.out.println("Input: digits = \"" + digits + "\"");
        System.out.print("Output: [");
        for (int i = 0; i < combinations.size(); i++) {
            System.out.print("\"" + combinations.get(i) + "\"");
            if (i < combinations.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
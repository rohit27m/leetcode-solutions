public class Solution {
    public static String largestPalindromic(String num) {
        int[] freq = new int[10];

        // Count frequency of each digit
        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }

        StringBuilder left = new StringBuilder();

        // Build the left half using largest digits first
        for (int d = 9; d >= 0; d--) {
            while (freq[d] >= 2) {
                // Avoid leading zero unless it's the only choice
                if (left.length() == 0 && d == 0) break;
                left.append(d);
                freq[d] -= 2;
            }
        }

        // Pick the middle digit (if any left)
        String mid = "";
        for (int d = 9; d >= 0; d--) {
            if (freq[d] > 0) {
                mid = String.valueOf(d);
                break;
            }
        }

        // Build final palindrome
        String right = new StringBuilder(left).reverse().toString();
        String result = left.toString() + mid + right;

        // Edge case: only zeros
        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) throws java.io.IOException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter digits string: ");
        String input = sc.nextLine();
        System.out.println("Largest Palindromic Integer: " + largestPalindromic(input));
    }
}

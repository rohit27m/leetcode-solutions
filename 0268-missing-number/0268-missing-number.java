class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int asum = n * (n + 1) / 2; // expected sum
        int csum = 0;

        for (int num : nums) {
            csum += num; // actual sum
        }

        return asum - csum; // missing number
    }
}

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int move = nums[i];
            int newIndex = ((i + move) % n + n) % n; // handles negative wrap
            ans[i] = nums[newIndex];
        }

        return ans;
    }
}
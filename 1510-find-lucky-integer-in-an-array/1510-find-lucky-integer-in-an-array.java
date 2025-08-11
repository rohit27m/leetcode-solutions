public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int result = -1;
        for (int num : freq.keySet()) {
            if (num == freq.get(num)) {
                result = Math.max(result, num);
            }
        }

        return result;
    }
}

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        Arrays.sort(capacity);

        int usedCapacity = 0;
        int count = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            usedCapacity += capacity[i];
            count++;
            if (usedCapacity >= totalApples) {
                return count;
            }
        }

        return count;
    }
}

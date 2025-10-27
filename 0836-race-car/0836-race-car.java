class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new int[]{0, 1});
        visited.add("0,1");
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int pos = cur[0], speed = cur[1];
                if (pos == target) return steps;
                int nextPos = pos + speed, nextSpeed = speed * 2;
                String key1 = nextPos + "," + nextSpeed;
                if (nextPos > 0 && nextPos < 2 * target && !visited.contains(key1)) {
                    visited.add(key1);
                    q.offer(new int[]{nextPos, nextSpeed});
                }
                int revSpeed = speed > 0 ? -1 : 1;
                String key2 = pos + "," + revSpeed;
                if (!visited.contains(key2)) {
                    visited.add(key2);
                    q.offer(new int[]{pos, revSpeed});
                }
            }
            steps++;
        }
        return -1;
    }
}

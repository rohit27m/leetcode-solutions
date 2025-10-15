class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        while (!s.isEmpty()) {
            int ul = s.pop();
            if (!visited[ul]) {
                visited[ul] = true;
                for (int key : rooms.get(ul)) {
                    if (!visited[key]) {
                        s.push(key);
                    }
                }
            }
        }
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int x : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && x < 0 && stack.peek() > 0) {
                if (Math.abs(stack.peek()) < Math.abs(x)) {
                    stack.pop(); // smaller right asteroid explodes
                    continue;    // keep checking for next collision
                } else if (Math.abs(stack.peek()) == Math.abs(x)) {
                    stack.pop(); // both explode
                }
                destroyed = true; // current asteroid destroyed
                break;
            }
            if (!destroyed) {
                stack.push(x);
            }
        }
        
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}

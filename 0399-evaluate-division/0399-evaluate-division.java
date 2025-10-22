import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> lis = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            lis.putIfAbsent(u, new HashMap<>());
            lis.putIfAbsent(v, new HashMap<>());
            lis.get(u).put(v, val);
            lis.get(v).put(u, 1.0 / val);
        }

        // Process queries
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();

            if (!lis.containsKey(src) || !lis.containsKey(dst)) {
                res[i] = -1.0;
            } else {
                double val = dfs(lis, src, dst, visited);
                res[i] = val == 0.0 ? -1.0 : val;
            }
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> lis, String src, String dst, Set<String> visited) {
        if (src.equals(dst)) return 1.0;

        visited.add(src);
        Map<String, Double> neighbors = lis.get(src);

        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            double val = entry.getValue();
            if (!visited.contains(next)) {
                double sub = dfs(lis, next, dst, visited);
                if (sub != 0.0) {
                    return val * sub;
                }
            }
        }

        return 0.0; // path not found
    }
}

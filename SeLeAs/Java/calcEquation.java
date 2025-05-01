import java.util.*;

public class calcEquation {
    

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, val));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, 1.0 / val));
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            results[i] = bfs(src, dest, graph);
        }

        return results;
    }

    private double bfs(String src, String target, Map<String, List<Pair>> graph) {
        if (!graph.containsKey(src) || !graph.containsKey(target)) {
            return -1.0;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair(src, 1.0));
        visited.add(src);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String node = current.node;
            double weight = current.weight;

            if (node.equals(target)) {
                return weight;
            }

            for (Pair neighbor : graph.get(node)) {
                if (!visited.contains(neighbor.node)) {
                    visited.add(neighbor.node);
                    queue.offer(new Pair(neighbor.node, weight * neighbor.weight));
                }
            }
        }

        return -1.0;
    }

    // Helper class to store a neighbor and the associated weight
    private static class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}

}

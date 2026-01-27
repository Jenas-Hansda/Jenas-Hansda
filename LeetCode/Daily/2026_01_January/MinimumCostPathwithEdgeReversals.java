import java.util.*;

class MinimumCostPathwithEdgeReversals {

    static class Pair {
        int node;
        int dist;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int minCost(int n, int[][] edges) {

        // Adjacency list: node -> (neighbor, weight)
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u  = edge[0];
            int v  = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(2 * wt, u)); // reversed edge
        }

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        // Min-heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );

        pq.offer(new Pair(0, 0)); // distance = 0, sourceNode = 0

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.dist;
            int node = curr.node;

            // Skip outdated entries
            if (d > result[node]) continue;

            if (node == n - 1) {
                return d;
            }

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int dist    = p.dist;

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new Pair(d + dist, adjNode));
                }
            }
        }

        return -1;
    }
}

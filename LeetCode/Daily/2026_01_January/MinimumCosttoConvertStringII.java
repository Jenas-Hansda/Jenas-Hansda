import java.util.*;

class MinimumCosttoConvertStringII {

    static class Edge {
        String to;
        long cost;

        Edge(String t, long c) {
            to = t;
            cost = c;
        }
    }

    static class Node implements Comparable<Node> {
        String str;
        long cost;

        Node(String s, long c) {
            str = s;
            cost = c;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    private static final long BIG_VALUE = (long) 1e10;

    // Graph: original -> (changed, cost)
    Map<String, List<Edge>> adj = new HashMap<>();

    // Memo for dijkstra: start -> (end -> cost)
    Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();

    long[] dpMemo;
    String sourceStr, targetStr;
    TreeSet<Integer> validLengths = new TreeSet<>();

    long dijkstra(String start, String end) {

        dijkstraMemo.putIfAbsent(start, new HashMap<>());
        if (dijkstraMemo.get(start).containsKey(end)) {
            return dijkstraMemo.get(start).get(end);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Long> dist = new HashMap<>();

        pq.offer(new Node(start, 0));
        dist.put(start, 0L);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            String node = curr.str;
            long currCost = curr.cost;

            if (node.equals(end)) break;
            if (!adj.containsKey(node)) continue;

            for (Edge edge : adj.get(node)) {
                String next = edge.to;
                long newCost = currCost + edge.cost;

                if (!dist.containsKey(next) || newCost < dist.get(next)) {
                    dist.put(next, newCost);
                    pq.offer(new Node(next, newCost));
                }
            }
        }

        long finalCost = dist.getOrDefault(end, BIG_VALUE);
        dijkstraMemo.get(start).put(end, finalCost);
        return finalCost;
    }

    long solve(int idx) {
        if (idx >= sourceStr.length()) return 0;
        if (dpMemo[idx] != -1) return dpMemo[idx];

        long minCost = BIG_VALUE;

        // No-op if characters already match
        if (sourceStr.charAt(idx) == targetStr.charAt(idx)) {
            minCost = solve(idx + 1);
        }

        for (int len : validLengths) {
            if (idx + len > sourceStr.length()) break;

            String srcSub = sourceStr.substring(idx, idx + len);
            String tgtSub = targetStr.substring(idx, idx + len);

            if (!adj.containsKey(srcSub)) continue;

            long pathCost = dijkstra(srcSub, tgtSub);
            if (pathCost == BIG_VALUE) continue;

            minCost = Math.min(minCost, pathCost + solve(idx + len));
        }

        dpMemo[idx] = minCost;
        return minCost;
    }

    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {
        sourceStr = source;
        targetStr = target;

        dpMemo = new long[10001];
        Arrays.fill(dpMemo, -1);

        for (int i = 0; i < original.length; i++) {
            adj.computeIfAbsent(original[i], k -> new ArrayList<>())
               .add(new Edge(changed[i], cost[i]));
            validLengths.add(original[i].length());
        }

        long ans = solve(0);
        return ans == BIG_VALUE ? -1 : ans;
    }
}

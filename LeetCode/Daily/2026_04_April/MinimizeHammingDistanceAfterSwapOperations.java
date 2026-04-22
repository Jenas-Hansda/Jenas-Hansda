import java.util.*;

class Solution {
    int[] parent;
    int[] rank;

    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootY] = rootX;

        if (rank[rootX] == rank[rootY]) {
            rank[rootX]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Union allowed swaps
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        // group -> (value -> frequency)
        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = find(i);
            groupFreq.putIfAbsent(p, new HashMap<>());
            Map<Integer, Integer> freqMap = groupFreq.get(p);
            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0) + 1);
        }

        int hammingDistance = 0;

        for (int i = 0; i < n; i++) {
            int p = find(i);
            Map<Integer, Integer> freqMap = groupFreq.get(p);

            if (freqMap.getOrDefault(target[i], 0) > 0) {
                freqMap.put(target[i], freqMap.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}
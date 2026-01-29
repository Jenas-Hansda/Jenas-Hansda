class SoluMinimumCosttoConvertStringItion {

    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        final long INF = (long) 1e18;

        // Distance matrix for 26 letters
        long[][] dist = new long[26][26];

        // Initialize distances
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        // Fill direct transformations
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall Algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < 26; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Calculate total cost
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (s == t) continue;

            if (dist[s][t] == INF) {
                return -1;
            }

            ans += dist[s][t];
        }

        return ans;
    }
}

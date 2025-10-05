class MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;

        int result = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int max = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int gcd = gcd(dy, dx);
                if (gcd != 0) {
                    dy /= gcd;
                    dx /= gcd;
                }

                String key = dy + "_" + dx;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }

            result = Math.max(result, max + 1);
        }

        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

class ErectTheFence {

    int findEquationValue(int[] P1, int[] P2, int[] P3) {
        int x1 = P1[0];
        int y1 = P1[1];
        int x2 = P2[0];
        int y2 = P2[1];
        int x3 = P3[0];
        int y3 = P3[1];

        return (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2);
    }

    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Deque<int[]> upper = new ArrayDeque<>();
        Deque<int[]> lower = new ArrayDeque<>();

        for (int[] p : trees) {

            // LOWER HULL
            while (lower.size() >= 2) {
                int[] p2 = lower.removeLast();
                int[] p1 = lower.peekLast();

                if (findEquationValue(p1, p2, p) < 0) {
                    continue;    // pop p2
                }
                lower.addLast(p2); // restore p2 if not removed
                break;
            }
            lower.addLast(p);

            // UPPER HULL
            while (upper.size() >= 2) {
                int[] p2 = upper.removeLast();
                int[] p1 = upper.peekLast();

                if (findEquationValue(p1, p2, p) > 0) {
                    continue;
                }
                upper.addLast(p2);
                break;
            }
            upper.addLast(p);
        }

        // Collect unique points
        HashSet<String> set = new HashSet<>();
        List<int[]> resultList = new ArrayList<>();

        for (int[] p : upper) {
            String key = p[0] + "," + p[1];
            if (set.add(key)) resultList.add(p);
        }
        for (int[] p : lower) {
            String key = p[0] + "," + p[1];
            if (set.add(key)) resultList.add(p);
        }

        // Convert to array
        int[][] ans = new int[resultList.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = resultList.get(i);
        }
        return ans;
    }
}

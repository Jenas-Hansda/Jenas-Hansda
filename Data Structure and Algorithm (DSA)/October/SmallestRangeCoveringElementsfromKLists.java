class SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.add(new int[]{val, i, 0});
            max = Math.max(max, val);
        }

        int[] range = { -1000000, 1000000 };

        while (true) {
            int[] curr = pq.poll();
            int min = curr[0], list = curr[1], idx = curr[2];

            if (max - min < range[1] - range[0]) {
                range[0] = min;
                range[1] = max;
            }

            if (idx + 1 == nums.get(list).size()) break;

            int next = nums.get(list).get(idx + 1);
            pq.add(new int[]{next, list, idx + 1});
            max = Math.max(max, next);
        }

        return range;
    }
}

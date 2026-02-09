class TrionicArrayII {
    int n;
    long[][] memo;

    long solve(int i, int trend, int[] nums) {
        if (i == n) {
            if (trend == 3) {
                return 0; // valid end
            } else {
                return Long.MIN_VALUE / 2; // invalid
            }
        }

        if (memo[i][trend] != Long.MIN_VALUE) {
            return memo[i][trend];
        }

        long take = Long.MIN_VALUE / 2;
        long skip = Long.MIN_VALUE / 2;

        // skip
        if (trend == 0) {
            skip = solve(i + 1, 0, nums);
        }

        // if already in trend 3, can end here
        if (trend == 3) {
            take = nums[i];
        }

        if (i + 1 < n) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (trend == 0 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 1, nums));
            } 
            else if (trend == 1) {
                if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 1, nums));
                } else if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                }
            } 
            else if (trend == 2) {
                if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                } else if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 3, nums));
                }
            } 
            else if (trend == 3 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 3, nums));
            }
        }

        return memo[i][trend] = Math.max(take, skip);
    }

    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        memo = new long[n + 1][4];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                memo[i][j] = Long.MIN_VALUE;
            }
        }

        return solve(0, 0, nums);
    }
}

import java.util.*;

class Solution {
    static final int M = 1_000_000_007;

    // Iterative binary exponentiation
    long power(long a, long b) {
        long result = 1;
        a %= M;

        while (b > 0) {
            if ((b & 1) == 1)
                result = (result * a) % M;

            a = (a * a) % M;
            b >>= 1;
        }
        return result;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int blockSize = (int)Math.ceil(Math.sqrt(n));

        // Replace unordered_map with array of lists
        List<int[]>[] smallK = new ArrayList[blockSize];
        for (int i = 0; i < blockSize; i++) {
            smallK[i] = new ArrayList<>();
        }

        // Process queries
        for (int[] q : queries) {
            int L = q[0], R = q[1], K = q[2], V = q[3];

            if (K >= blockSize) {
                for (int i = L; i <= R; i += K) {
                    nums[i] = (int)((1L * nums[i] * V) % M);
                }
            } else {
                smallK[K].add(q);
            }
        }

        // Process small K
        for (int K = 1; K < blockSize; K++) {
            if (smallK[K].isEmpty()) continue;

            long[] diff = new long[n];
            Arrays.fill(diff, 1);

            for (int[] q : smallK[K]) {
                int L = q[0], R = q[1], V = q[3];

                diff[L] = (diff[L] * V) % M;

                int steps = (R - L) / K;
                int next = L + (steps + 1) * K;

                if (next < n) {
                    long inv = power(V, M - 2);
                    diff[next] = (diff[next] * inv) % M;
                }
            }

            // Prefix multiplication
            for (int i = 0; i < n; i++) {
                if (i - K >= 0) {
                    diff[i] = (diff[i] * diff[i - K]) % M;
                }
            }

            // Apply to nums
            for (int i = 0; i < n; i++) {
                nums[i] = (int)((1L * nums[i] * diff[i]) % M);
            }
        }

        // XOR result
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
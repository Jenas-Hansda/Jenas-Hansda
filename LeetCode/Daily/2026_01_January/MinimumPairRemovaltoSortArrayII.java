import java.util.*;

class MinimumPairRemovaltoSortArrayII {

    static class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return sum == p.sum && idx == p.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, idx);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }

        TreeSet<Pair> minPairSet = new TreeSet<>(
            (a, b) -> {
                if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
                return Integer.compare(a.idx, b.idx);
            }
        );

        int[] nextIndex = new int[n];
        int[] prevIndex = new int[n];

        for (int i = 0; i < n; i++) {
            nextIndex[i] = i + 1;
            prevIndex[i] = i - 1;
        }

        int badPairs = 0;
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] > temp[i + 1]) {
                badPairs++;
            }
            minPairSet.add(new Pair(temp[i] + temp[i + 1], i));
        }

        int operations = 0;

        while (badPairs > 0) {
            Pair p = minPairSet.pollFirst();
            int first = p.idx;
            int second = nextIndex[first];

            int firstLeft = prevIndex[first];
            int secondRight = nextIndex[second];

            // remove (first, second) bad pair
            if (temp[first] > temp[second]) {
                badPairs--;
            }

            // {d, (a, b)}
            if (firstLeft >= 0) {
                if (temp[firstLeft] > temp[first] &&
                    temp[firstLeft] <= temp[first] + temp[second]) {
                    badPairs--;
                } else if (temp[firstLeft] <= temp[first] &&
                           temp[firstLeft] > temp[first] + temp[second]) {
                    badPairs++;
                }
            }

            // {(a, b), d}
            if (secondRight < n) {
                if (temp[secondRight] >= temp[second] &&
                    temp[secondRight] < temp[first] + temp[second]) {
                    badPairs++;
                } else if (temp[secondRight] < temp[second] &&
                           temp[secondRight] >= temp[first] + temp[second]) {
                    badPairs--;
                }
            }

            // update left neighbor pair
            if (firstLeft >= 0) {
                minPairSet.remove(new Pair(temp[firstLeft] + temp[first], firstLeft));
                minPairSet.add(new Pair(temp[firstLeft] + temp[first] + temp[second], firstLeft));
            }

            // update right neighbor pair
            if (secondRight < n) {
                minPairSet.remove(new Pair(temp[second] + temp[secondRight], second));
                minPairSet.add(new Pair(temp[first] + temp[second] + temp[secondRight], first));
                prevIndex[secondRight] = first;
            }

            nextIndex[first] = secondRight;
            temp[first] += temp[second];

            operations++;
        }

        return operations;
    }
}

import java.util.Arrays;

class MaximumHappinessofSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {

        // Sort in ascending order
        Arrays.sort(happiness);

        long result = 0;
        int count = 0;
        int n = happiness.length;

        // Pick from largest elements
        for (int i = n - 1; i >= n - k; i--) {
            result += Math.max(happiness[i] - count, 0);
            count++;
        }

        return result;
    }
}

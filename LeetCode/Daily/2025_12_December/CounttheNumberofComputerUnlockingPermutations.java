import java.util.*;

class CounttheNumberofComputerUnlockingPermutations {
    // Modulo value
    int M = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        long result = 1;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }

            result = (result * i) % M;
        }

        return (int) result;
    }
}

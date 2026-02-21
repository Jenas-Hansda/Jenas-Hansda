import java.util.*;

class PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = new HashSet<>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)
        );

        int result = 0;

        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);  // equivalent to __builtin_popcount
            
            if (primes.contains(setBits)) {
                result++;
            }
        }

        return result;
    }
}
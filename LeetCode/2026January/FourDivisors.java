class FourDivisors {

    // T.C : O(sqrt(num))
    // S.C : O(1)
    private int sumIfFourDivisors(int num) {
        int divisors = 0;
        int sum = 0;

        for (int div = 1; div * div <= num; div++) {
            if (num % div == 0) {
                int other = num / div;

                if (div == other) {
                    divisors++;
                    sum += div;
                } else {
                    divisors += 2;
                    sum += div + other;
                }
            }

            // Early exit if more than 4 divisors
            if (divisors > 4) {
                return 0;
            }
        }

        return divisors == 4 ? sum : 0;
    }

    // T.C : O(n * sqrt(maxNumber))
    // S.C : O(1)
    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result += sumIfFourDivisors(num);
        }

        return result;
    }
}

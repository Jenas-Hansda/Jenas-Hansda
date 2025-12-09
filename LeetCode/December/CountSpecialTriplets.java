class CountSpecialTriplets {
    static final int M = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Long> validI = new HashMap<>();
        Map<Integer, Long> validJ = new HashMap<>();

        long result = 0;

        for (int num : nums) {

            // check if it's valid k
            if (num % 2 == 0) {
                result = (result + validJ.getOrDefault(num / 2, 0L)) % M;
            }

            // update valid j
            long add = validI.getOrDefault(num * 2, 0L);
            validJ.put(num, (validJ.getOrDefault(num, 0L) + add) % M);

            // update valid i
            validI.put(num, validI.getOrDefault(num, 0L) + 1);
        }

        return (int) result;
    }
}

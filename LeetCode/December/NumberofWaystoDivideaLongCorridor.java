class NumberofWaystoDivideaLongCorridor {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        
        // Store indices of all seats
        java.util.List<Integer> seats = new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                seats.add(i);
            }
        }

        // If total seats are odd or zero, no valid partition
        if (seats.size() == 0 || seats.size() % 2 != 0) {
            return 0;
        }

        long result = 1;

        // End index of the first pair of seats
        int prev = seats.get(1);

        // Process every next pair
        for (int i = 2; i < seats.size(); i += 2) {
            int gap = seats.get(i) - prev;
            result = (result * gap) % MOD;
            prev = seats.get(i + 1);
        }

        return (int) result;
    }
}

class StudentAttendenceRecordII {
    private static final int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        long[][] prev = new long[2][3];
        long[][] curr = new long[2][3];

        // Base case: length 0 record has 1 valid way for any (A,L) state
        for (int A = 0; A <= 1; A++) {
            for (int L = 0; L <= 2; L++) {
                prev[A][L] = 1;
            }
        }

        for (int day = 1; day <= n; day++) {
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {
                    long result = 0;

                    // Add 'P' (Present)
                    result += prev[A][0];

                    // Add 'L' (Late)
                    if (L < 2) result += prev[A][L + 1];

                    // Add 'A' (Absent)
                    if (A == 0) result += prev[A + 1][0];

                    curr[A][L] = result % MOD;
                }
            }

            // Copy current state to previous for next iteration
            for (int A = 0; A <= 1; A++) {
                System.arraycopy(curr[A], 0, prev[A], 0, 3);
            }
        }

        return (int) prev[0][0]; // starting state: no absence, no consecutive late
    }

    
}

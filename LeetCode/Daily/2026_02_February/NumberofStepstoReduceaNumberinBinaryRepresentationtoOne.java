class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public int numSteps(String s) {
        int n = s.length();
        int operations = 0;
        int carry = 0;

        // Traverse from last index to index 1
        for (int i = n - 1; i >= 1; i--) {
            int currentBit = (s.charAt(i) - '0') + carry;

            if (currentBit % 2 == 1) {  // odd
                operations += 2;       // add 1 + divide by 2
                carry = 1;
            } else {                   // even
                operations += 1;       // only divide by 2
            }
        }

        // If there's a carry left, add it
        return operations + carry;
    }
}
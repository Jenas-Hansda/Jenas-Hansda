class PermutationSequence {
    List<Integer> digits = new ArrayList<>();
    List<Integer> fact = new ArrayList<>();

    // Recursive method to build the permutation
    private void solve(StringBuilder ans, int n, int k) {
        if (n == 1) {
            // Base case: only one digit left
            ans.append(digits.get(0));
            return;
        }

        // Calculate index of the current digit to place
        int index = (k - 1) / fact.get(n - 1);

        // Append selected digit
        ans.append(digits.get(index));

        // Remove used digit
        digits.remove(index);

        // Update k for the remaining recursive calls
        k = k - index * fact.get(n - 1);

        // Recurse for the next digit
        solve(ans, n - 1, k);
    }

    public String getPermutation(int n, int k) {
        // Precompute factorials up to (n - 1)!
        fact.add(1);
        int f = 1;
        for (int i = 1; i < n; i++) {
            f *= i;
            fact.add(f);
        }

        // Initialize digits list from 1 to n
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }

        // Use StringBuilder for efficient string concatenation
        StringBuilder ans = new StringBuilder();
        solve(ans, n, k);
        return ans.toString();
    }
}

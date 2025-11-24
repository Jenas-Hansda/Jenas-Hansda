class 24Game {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < EPSILON;
        }

        int n = nums.size();

        // Pick two different numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                List<Double> rest = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) rest.add(nums.get(k));
                }

                double a = nums.get(i);
                double b = nums.get(j);

                // All possible combinations between `a` and `b`
                List<Double> nextValues = new ArrayList<>();
                nextValues.add(a + b);
                nextValues.add(a - b);
                nextValues.add(b - a);
                nextValues.add(a * b);

                if (Math.abs(b) > EPSILON)
                    nextValues.add(a / b);
                if (Math.abs(a) > EPSILON)
                    nextValues.add(b / a);

                for (double val : nextValues) {
                    rest.add(val);
                    if (solve(rest)) return true;
                    rest.remove(rest.size() - 1);  // undo
                }
            }
        }

        return false;
    }
}

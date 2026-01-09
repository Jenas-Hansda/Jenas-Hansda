class CountSquareSumTriples {
    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = a + 1; b <= n; b++) {
                int s = (a * a) + (b * b);
                int x = (int) Math.sqrt(s);

                if (x * x == s && x <= n) {
                    count += 2;
                }
            }
        }
        return count;
    }
}

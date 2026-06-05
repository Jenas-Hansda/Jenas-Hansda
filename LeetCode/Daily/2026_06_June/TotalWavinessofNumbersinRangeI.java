class Solution {

    private int findWaveScore(int num) {
        String s = String.valueOf(num);

        int n = s.length();
        if (n < 3) {
            return 0;
        }

        int score = 0;

        for (int i = 1; i <= n - 2; i++) {

            // Peak
            if (s.charAt(i) > s.charAt(i - 1) &&
                s.charAt(i) > s.charAt(i + 1)) {
                score++;
            }

            // Valley
            if (s.charAt(i) < s.charAt(i - 1) &&
                s.charAt(i) < s.charAt(i + 1)) {
                score++;
            }
        }

        return score;
    }

    public int totalWaviness(int num1, int num2) {
        int score = 0;

        for (int num = num1; num <= num2; num++) {
            score += findWaveScore(num);
        }

        return score;
    }
}
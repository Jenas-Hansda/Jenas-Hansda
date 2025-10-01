class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        List<Integer> trues = new ArrayList<>();
        trues.add(0);

        for (int i = 1; i <= n; i++) {
            for (int j : trues) {
                if (wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    trues.add(i);
                    break;
                }
            }
        }

        return dp[n];
    }
}
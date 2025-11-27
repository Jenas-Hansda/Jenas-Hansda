class StickerstoSpellWord {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] counts = new int[n][26];

        // Count letter frequencies for each sticker
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                counts[i][c - 'a']++;
            }
        }

        // Memo for DP
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        return helper(target, counts, memo);
    }

    private int helper(String target, int[][] counts, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int ans = Integer.MAX_VALUE;

        // Target letter frequency
        int[] targetFreq = new int[26];
        for (char c : target.toCharArray()) {
            targetFreq[c - 'a']++;
        }

        // Try each sticker
        for (int[] sticker : counts) {

            // Optimization: skip stickers that do NOT contain the first character
            char first = target.charAt(0);
            if (sticker[first - 'a'] == 0) continue;

            // Build the "remaining" target after using one sticker
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (targetFreq[i] > 0) {
                    int remain = targetFreq[i] - sticker[i];
                    for (int k = 0; k < Math.max(0, remain); k++) {
                        sb.append((char) ('a' + i));
                    }
                }
            }

            String rest = sb.toString();
            int tmp = helper(rest, counts, memo);

            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }

        memo.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return memo.get(target);
    }
}

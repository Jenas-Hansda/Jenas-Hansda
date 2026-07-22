class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int activeCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                activeCount++;
            }
        }

        List<Integer> inactiveBlocks = new ArrayList<>();

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                inactiveBlocks.add(i - start);
            } else {
                i++;
            }
        }

        int maxPairSum = 0;

        for (int j = 1; j < inactiveBlocks.size(); j++) {
            maxPairSum = Math.max(maxPairSum, inactiveBlocks.get(j) + inactiveBlocks.get(j - 1));
        }

        return activeCount + maxPairSum;
    }
}

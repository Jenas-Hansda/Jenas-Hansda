class LongestPalindromicSubstring {
    private int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int start = left + 1;
        int end = right - 1;
        int len = end - start + 1;
        return new int[]{start, end, len};
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int maxLen = 0;
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] res1 = expandAroundCenter(s, i, i);
            if (res1[2] > maxLen) {
                maxLen = res1[2];
                left = res1[0];
                right = res1[1];
            }

            int[] res2 = expandAroundCenter(s, i, i + 1);
            if (res2[2] > maxLen) {
                maxLen = res2[2];
                left = res2[0];
                right = res2[1];
            }
        }

        return s.substring(left, right + 1);
    }

}
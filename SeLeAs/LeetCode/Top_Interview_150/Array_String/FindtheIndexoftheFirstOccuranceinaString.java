package Top_Interview_150.Array_String;

public class FindtheIndexoftheFirstOccuranceinaString {
    class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) return 0; // edge case: empty needle

        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i;
            }
        }

        return -1;
    }
}

}

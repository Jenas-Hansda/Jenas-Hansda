import java.util.*;

class PalindromePairs {

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        if (n < 2) return ans;

        // Map of reversed words -> index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            map.put(reversed, i);
        }

        // Check all splits
        for (int i = 0; i < n; ++i) {
            String word = words[i];
            for (int j = 0; j <= word.length(); ++j) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                // Case 1: reversed prefix exists and suffix is palindrome
                if (map.containsKey(prefix) && isPalindrome(suffix) && map.get(prefix) != i) {
                    ans.add(Arrays.asList(i, map.get(prefix)));
                }

                // Case 2: reversed suffix exists and prefix is palindrome
                if (!prefix.isEmpty() && map.containsKey(suffix) && isPalindrome(prefix) && map.get(suffix) != i) {
                    ans.add(Arrays.asList(map.get(suffix), i));
                }
            }
        }

        return ans;
    }
}

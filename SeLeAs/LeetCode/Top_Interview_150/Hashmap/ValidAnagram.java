package Top_Interview_150.Hashmap;

public class ValidAnagram {
    class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: Quick length check
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Step 3: Update frequencies
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Step 4: Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}

}

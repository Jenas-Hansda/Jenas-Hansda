import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public class Solution {

        // Check if a string is a palindrome
        private boolean isPalin(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }

        // Recursive function to get all palindrome partitions
        private void getAllParts(String s, List<String> partitions, List<List<String>> ans) {
            if (s.isEmpty()) {
                ans.add(new ArrayList<>(partitions)); // Make a copy
                return;
            }

            for (int i = 0; i < s.length(); i++) {
                String part = s.substring(0, i + 1);
                if (isPalin(part)) {
                    partitions.add(part);
                    getAllParts(s.substring(i + 1), partitions, ans);
                    partitions.remove(partitions.size() - 1); // backtrack
                }
            }
        }

        // Main function to return all partitions
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> partitions = new ArrayList<>();
            getAllParts(s, partitions, ans);
            return ans;
        }
    }

}
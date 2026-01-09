package Sliding_Window;
import java.util.*;
public class MinimumWindowSubstring {
    class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> requiredCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCounts.put(c, requiredCounts.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCounts = new HashMap<>();
        int formed = 0;
        int totalRequired = requiredCounts.size();

        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (requiredCounts.containsKey(c) && 
                windowCounts.get(c).intValue() == requiredCounts.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == totalRequired) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char leftChar = s.charAt(l);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (requiredCounts.containsKey(leftChar) && 
                    windowCounts.get(leftChar).intValue() < requiredCounts.get(leftChar).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
}
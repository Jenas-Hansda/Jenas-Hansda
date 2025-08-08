package Array_String;
import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    // Handle null or empty input
    if (strs == null || strs.length == 0) {
      return "";
    }

    // Sort the array so that the most dissimilar strings are at the ends
    Arrays.sort(strs);

    // Get the first and last strings after sorting
    char[] first = strs[0].toCharArray();
    char[] last = strs[strs.length - 1].toCharArray();

    StringBuilder result = new StringBuilder();

    // Compare characters of the first and last strings
    for (int i = 0; i < first.length; i++) {
      // Ensure we don't go out of bounds on 'last'
      if (i >= last.length || first[i] != last[i]) {
        break;
      }
      result.append(first[i]);
    }

    return result.toString();
  

}
}

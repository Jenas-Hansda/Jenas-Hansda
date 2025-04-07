import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Count the frequency of each element in arr
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a set to store the frequencies and check if they are unique
        Set<Integer> frequencies = new HashSet<>(countMap.values());
        
        // If the size of the set is equal to the number of unique frequencies, return true
        return countMap.size() == frequencies.size();
    }
}

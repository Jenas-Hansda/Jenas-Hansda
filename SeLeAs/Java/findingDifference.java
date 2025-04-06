import java.util.*;

public class findingDifference {

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        
        // Convert arrays to sets
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        
        // List to store the difference for nums1 - nums2
        List<Integer> ans1 = new ArrayList<>();
        // List to store the difference for nums2 - nums1
        List<Integer> ans2 = new ArrayList<>();
        
        // Find elements in set1 but not in set2
        for (int num : set1) {
            if (!set2.contains(num)) {
                ans1.add(num);
            }
        }
        
        // Find elements in set2 but not in set1
        for (int num : set2) {
            if (!set1.contains(num)) {
                ans2.add(num);
            }
        }
        
        // Add both lists to the result
        result.add(ans1);
        result.add(ans2);
        
        return result;
    }
}

}

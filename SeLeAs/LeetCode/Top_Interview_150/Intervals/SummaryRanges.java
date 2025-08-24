package Top_Interview_150.Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
    List<String> result = new ArrayList<>(length);
    
    for (int i = 0; i < length; i++) {
        int start = nums[i];
        
        // Move forward while numbers are consecutive
        while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
            i++;
        }
        
        if (start != nums[i]) {
            result.add(start + "->" + nums[i]);
        } else {
            result.add(String.valueOf(start));
        }
    }
    
    return result;
}
    }
}

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> tot = new ArrayList<>();
        tot.add(new ArrayList<>());  // Start with the empty subset

        for (int num : nums) {
            int size = tot.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(tot.get(i));
                subset.add(num);
                tot.add(subset);
            }
        }

        return tot;
    }
}
}

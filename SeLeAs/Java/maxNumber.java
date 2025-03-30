import java.util.HashMap;
import java.util.Map;

public class maxNumber {
    public int MaxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                pairs++;
                map.put(k - num, map.get(k - num) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return pairs;
    }
}

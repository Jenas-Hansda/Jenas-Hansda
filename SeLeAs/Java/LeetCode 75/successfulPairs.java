import java.util.*;
public class successfulPairs {


public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int low = 0, high = potions.length;

            while (low < high) {
                int mid = (low + high) / 2;
                if ((long) potions[mid] * spell >= success) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            pairs[i] = potions.length - low;
        }

        return pairs;
    }
}

}

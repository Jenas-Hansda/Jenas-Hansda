
public class minEatingSpeed{


    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1;
            int high = 0;
            
            // Find the maximum pile size to set the upper bound
            for (int pile : piles) {
                high = Math.max(high, pile);
            }
    
            while (low < high) {
                int mid = (low + high) / 2;
                int hours = 0;
    
                for (int pile : piles) {
                    hours += pile / mid;
                    if (pile % mid != 0) {
                        hours += 1;
                    }
                }
    
                if (hours <= h) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
    
            return low;
        }
    }
    
}
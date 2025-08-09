package Array_String;

public class Candy {
    class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = n; // Every child gets at least one candy

        int i = 1;
        while (i < n) {

            // Skip flat segments
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            // Handle increasing slope
            int up = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                up++;
                candies += up;
                i++;
            }

            // Handle decreasing slope
            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                candies += down;
                i++;
            }

            // At the peak, both up and down counted the top child
            // So subtract the smaller of up/down once
            candies -= Math.min(up, down);
        }

        return candies;
    }
}

}

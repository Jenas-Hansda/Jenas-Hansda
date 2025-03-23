class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current position can place a flower
            boolean left = (i == 0) || (flowerbed[i - 1] == 0);
            boolean right = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;  // Plant a flower
                n--;  // Decrease the required flowers

                if (n == 0) {
                    return true;  // If no more flowers are needed, return true
                }
            }
        }

        return false;  // If it's not possible to plant all flowers
    }
}

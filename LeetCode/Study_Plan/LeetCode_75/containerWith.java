class containerWith {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int lp = 0, rp = height.length - 1;

        while (lp < rp) {
            int w = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int curWater = w * ht;
            maxWater = Math.max(maxWater, curWater);

            // Move the pointers based on height comparison
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
}

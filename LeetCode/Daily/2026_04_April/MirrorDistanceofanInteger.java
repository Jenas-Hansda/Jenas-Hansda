class Solution {

    private int getReverse(int n) {
        int result = 0;

        while (n != 0) {
            int rem = n % 10;
            result = result * 10 + rem;
            n /= 10;
        }

        return result;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - getReverse(n));
    }
}
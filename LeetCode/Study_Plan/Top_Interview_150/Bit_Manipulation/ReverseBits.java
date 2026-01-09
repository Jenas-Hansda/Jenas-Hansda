public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                ans += 1 << (31 - i);
            }
            mask <<= 1;
        }
        return ans;
    }
}

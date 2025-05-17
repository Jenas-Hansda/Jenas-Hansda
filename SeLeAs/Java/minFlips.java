public class minFlips {
    public class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int abit = a & 1;
            int bbit = b & 1;
            int cbit = c & 1;

            if (cbit == 1) {
                if ((abit | bbit) != 1) {
                    flips += 1;
                }
            } else {
                if (abit == 1) {
                    flips += 1;
                }
                if (bbit == 1) {
                    flips += 1;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }
}

}

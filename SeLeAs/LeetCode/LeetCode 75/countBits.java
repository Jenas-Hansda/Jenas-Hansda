

public class countBits{
    

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0; // base case

        for (int i = 1; i <= n; i++) {
            result[i] = result[i / 2] + (i % 2);
        }

        return result;
    }
}


}
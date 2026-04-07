class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        if (k == 0) { 
            return true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int finalIdx;

                if (i % 2 == 0) { 
                    finalIdx = (j + k) % n;
                } else { 
                    finalIdx = (j - k + n) % n;
                }

                if (mat[i][j] != mat[i][finalIdx]) {
                    return false;
                }
            }
        }

        return true;
    }
}
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        int[] result = new int[n];

        boolean[] isPresentA = new boolean[n + 1];
        boolean[] isPresentB = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;

            int count = 0;

            for (int num = 1; num <= n; num++) {
                if (isPresentA[num] && isPresentB[num]) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
}
class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int k = strs[0].length();
        int count = 0;

        // Iterate over each column
        for (int i = 0; i < k; i++) {
            // Check if the column is sorted
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break; // move to next column
                }
            }
        }
        return count;
    }
}

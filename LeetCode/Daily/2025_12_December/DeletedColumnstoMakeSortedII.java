class DeletedColumnstoMakeSortedII {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;          // Number of rows
        int cols = strs[0].length();     // Number of columns

        int deletion = 0;

        // Tracks whether a row pair is already confirmed sorted
        boolean[] alreadySorted = new boolean[rows];

        for (int col = 0; col < cols; col++) {
            boolean deleted = false;

            // Check if current column makes sorting invalid
            for (int row = 0; row < rows - 1; row++) {
                if (!alreadySorted[row] &&
                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {

                    deletion++;
                    deleted = true;
                    break;
                }
            }

            // If column is deleted, skip updating alreadySorted
            if (deleted) {
                continue;
            }

            // Update alreadySorted status for row pairs
            for (int i = 0; i < rows - 1; i++) {
                alreadySorted[i] = alreadySorted[i] ||
                        (strs[i].charAt(col) < strs[i + 1].charAt(col));
            }
        }

        return deletion;
    }
}

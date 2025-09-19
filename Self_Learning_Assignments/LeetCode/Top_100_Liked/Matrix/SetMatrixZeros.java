package Matrix;


class SetMatrixZeroes {

  public void setZeroes(int[][] matrix) {
    boolean firstRow = false, firstCol = false;

    // First pass: mark rows and columns that need to be zeroed
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) firstRow = true;
          if (j == 0) firstCol = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // Second pass: zero out cells based on markers, excluding first row and col
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // Zero out the first row if needed
    if (firstRow) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }

    // Zero out the first column if needed
    if (firstCol) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}

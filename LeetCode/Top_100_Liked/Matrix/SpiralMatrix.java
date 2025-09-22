package Matrix;
import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {

      // Traverse from Left to Right
      for (int col = left; col <= right; col++) {
        result.add(matrix[top][col]);
      }
      top++;

      // Traverse from Top to Bottom
      for (int row = top; row <= bottom; row++) {
        result.add(matrix[row][right]);
      }
      right--;

      // Traverse from Right to Left
      if (top <= bottom) {
        for (int col = right; col >= left; col--) {
          result.add(matrix[bottom][col]);
        }
        bottom--;
      }

      // Traverse from Bottom to Top
      if (left <= right) {
        for (int row = bottom; row >= top; row--) {
          result.add(matrix[row][left]);
        }
        left++;
      }
    }

    return result;
  }
}

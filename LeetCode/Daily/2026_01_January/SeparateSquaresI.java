class SeparateSquaresI {

    // Check if area below midY is >= half of total area
    private boolean check(int[][] squares, double midY, double total) {
        double bottomArea = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            double bottomY = y;
            double topY = y + l;

            if (midY >= topY) {
                // Entire square is below midY
                bottomArea += l * l;
            } else if (midY > bottomY) {
                // Partially below midY
                bottomArea += (midY - bottomY) * l;
            }
        }

        return bottomArea >= total / 2.0;
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double totalArea = 0.0;

        // Compute total area and y-range
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double resultY = 0.0;

        // Binary search on Y-coordinate
        while (high - low > 1e-5) {
            double midY = low + (high - low) / 2.0;
            resultY = midY;

            if (check(squares, midY, totalArea)) {
                // Bottom area too large → move down
                high = midY;
            } else {
                low = midY;
            }
        }

        return resultY;
    }
}


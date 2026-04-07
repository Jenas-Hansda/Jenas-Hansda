import java.util.*;

class Robot {
    int idx = 0;
    boolean moved = false;
    List<int[]> pos = new ArrayList<>();

    public Robot(int width, int height) {

        // Bottom row (left → right) → East (0)
        for (int x = 0; x < width; x++) {
            pos.add(new int[]{x, 0, 0});
        }

        // Right column (bottom → top) → North (1)
        for (int y = 1; y < height; y++) {
            pos.add(new int[]{width - 1, y, 1});
        }

        // Top row (right → left) → West (2)
        for (int x = width - 2; x >= 0; x--) {
            pos.add(new int[]{x, height - 1, 2});
        }

        // Left column (top → bottom) → South (3)
        for (int y = height - 2; y > 0; y--) {
            pos.add(new int[]{0, y, 3});
        }

        // Handle special corner case
        pos.get(0)[2] = 3;
    }

    public void step(int num) {
        moved = true;

        int n = pos.size();
        idx = (idx + (num % n)) % n; // 🔥 important optimization
    }

    public int[] getPos() {
        return new int[]{pos.get(idx)[0], pos.get(idx)[1]};
    }

    public String getDir() {
        if (!moved) return "East";

        int d = pos.get(idx)[2];
        if (d == 0) return "East";
        if (d == 1) return "North";
        if (d == 2) return "West";
        return "South";
    }
}
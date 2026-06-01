import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long totalMass = mass;

        for (int asteroid : asteroids) {
            if (totalMass < asteroid) {
                return false;
            }

            totalMass += asteroid;
        }

        return true;
    }
}
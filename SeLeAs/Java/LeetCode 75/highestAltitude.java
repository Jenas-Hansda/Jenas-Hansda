import java.util.List;



public class highestAltitude {
    public int largestAltitude(List<Integer> gain) {
        int altitude = 0;
        int maxAlt = 0;
        
        for (int change : gain) {
            altitude += change;
            maxAlt = Math.max(maxAlt, altitude);
        }
        
        return maxAlt;
    }
}

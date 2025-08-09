import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots{
    class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int count = 1;
        int lastEndPoint = points[0][1];
        
        for (int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            
            if (currStartPoint > lastEndPoint) {
                count++;
                lastEndPoint = points[i][1];
            }
        }
        
        return count;
    }
}
}
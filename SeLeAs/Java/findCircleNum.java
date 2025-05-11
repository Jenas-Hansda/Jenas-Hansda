import java.util.HashSet;
import java.util.Set;

public class findCircleNum{
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        int province = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, isConnected, visited, n);
                province++;
            }
        }

        return province;
    }

    private void dfs(int i, int[][] isConnected, Set<Integer> visited, int n) {
        visited.add(i);
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited.contains(j)) {
                dfs(j, isConnected, visited, n);
            }
        }
    }
}
}
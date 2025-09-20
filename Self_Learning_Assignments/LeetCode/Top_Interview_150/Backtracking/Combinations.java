import java.util.ArrayList;
import java.util.List;

class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    
    public void solve(int start, int n, int k, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Optimization: i <= n - k + 1
        for (int i = start; i <= n; i++) {
            temp.add(i);
            solve(i + 1, n, k - 1, temp);
            temp.remove(temp.size() - 1); // backtrack
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        solve(1, n, k, temp);
        return result;
    }
}

import java.util.ArrayList;
import java.util.List;

public class combinationSumIII {


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(ans, temp, k, n, 1);
        return ans;
    }

    private void solve(List<List<Integer>> ans, List<Integer> temp, int k, int n, int start) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(temp)); // Add a deep copy of temp
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }

        for (int num = start; num <= 9; num++) {
            if (num > n) {
                break;
            }
            temp.add(num);
            solve(ans, temp, k - 1, n - num, num + 1);
            temp.remove(temp.size() - 1); // backtrack
        }
    }
}

}
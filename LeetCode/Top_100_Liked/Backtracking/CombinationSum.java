import java.util.*;

public class CombinationSum {
    

public class Solution {

    // Recursive / Backtracking Approach
    public List<List<Integer>> combinationSumRecursive(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));  // Important: create a new list
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);  // backtrack
        }
    }

    // Dynamic Programming Approach
    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());

        for (int cand : candidates) {
            for (int i = cand; i <= target; i++) {
                for (List<Integer> comb : dp.get(i - cand)) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(cand);
                    dp.get(i).add(newComb);
                }
            }
        }
        return dp.get(target);
    }
}

}
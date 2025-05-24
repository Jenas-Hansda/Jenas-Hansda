public class  minCostClimbingStairs{
    class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int step = 2; step < cost.length; step++) {
            cost[step] += Math.min(cost[step - 1], cost[step - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}

}